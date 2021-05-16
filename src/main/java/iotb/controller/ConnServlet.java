/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotb.controller;

import iotb.model.dao.CustomerInformationManagementManager;
import iotb.model.dao.DatabaseConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author timmy
 */
public class ConnServlet extends HttpServlet {

 

       private DatabaseConnector db;

       private CustomerInformationManagementManager customerInformationManagementManager;

       private Connection conn;

        

       @Override //Create and instance of DBConnector for the deployment session

       public void init() {

           try {

               db = new DatabaseConnector();

           } catch (ClassNotFoundException | SQLException ex) {

               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);

           }      

       }

      

       @Override //Add the DBConnector, DBManager, Connection instances to the session

       protected void doGet(HttpServletRequest request, HttpServletResponse response)

               throws ServletException, IOException {

           response.setContentType("text/html;charset=UTF-8");       

           HttpSession session = request.getSession();

           conn = db.connection();       

           try {

               customerInformationManagementManager = new CustomerInformationManagementManager(conn);

           } catch (SQLException ex) {

               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);

           }

           //export the DB manager to the view-session (JSPs)

           session.setAttribute("customerInformationManagementManager", customerInformationManagementManager);           

       }   

        

       @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)

        public void destroy() {

           try {

               db.closeConnection();

           } catch (SQLException ex) {

               Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);

           }

       }

   }