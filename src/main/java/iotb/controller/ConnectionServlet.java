


package iotb.controller;

 

   import java.io.IOException;

   import java.sql.Connection;

   import java.sql.SQLException;

   import java.util.logging.Level;

   import java.util.logging.Logger;

   import javax.servlet.ServletException;

   import javax.servlet.http.HttpServlet;

   import javax.servlet.http.HttpServletRequest;

   import javax.servlet.http.HttpServletResponse;

   import javax.servlet.http.HttpSession;

   import iotb.model.dao.*;

 

   public class ConnectionServlet extends HttpServlet {

 

       private DBConnector db;

       private CreditCardManager creditCardManager;
       private PaymentManager paymentManager;
       private PaypalManager paypalManager;

       private Connection conn;

        

       @Override //Create and instance of DBConnector for the deployment session

       public void init() {

           try {

               db = new DBConnector();

           } catch (ClassNotFoundException | SQLException ex) {

               Logger.getLogger(ConnectionServlet.class.getName()).log(Level.SEVERE, null, ex);

           }      

       }

      

       @Override //Add the DBConnector, DBManager, Connection instances to the session

       protected void doGet(HttpServletRequest request, HttpServletResponse response)

               throws ServletException, IOException {

           response.setContentType("text/html;charset=UTF-8");       

           HttpSession session = request.getSession();

           conn = db.openConnection();       

           try {

               creditCardManager = new CreditCardManager(conn);
               paymentManager = new PaymentManager(conn);
               paypalManager = new PaypalManager(conn);

           } catch (SQLException ex) {

               Logger.getLogger(ConnectionServlet.class.getName()).log(Level.SEVERE, null, ex);

           }

           //export the DB manager to the view-session (JSPs)

           session.setAttribute("creditCardManager", creditCardManager);
           session.setAttribute("paymentManager", paymentManager);
           session.setAttribute("paypalManager", paypalManager);

       }   

        

       @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)

        public void destroy() {

           try {

               db.closeConnection();

           } catch (SQLException ex) {

               Logger.getLogger(ConnectionServlet.class.getName()).log(Level.SEVERE, null, ex);

           }

       }

   }
