/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  1234
 * Created: 04/05/2021
 */

INSERT INTO PAYMENTTABLE (ORDERID, PAYMENTTYPE)
VALUES
((SELECT ORDERID FROM ORDERTABLE WHERE ORDERTOTAL=100.00), 1),
((SELECT ORDERID FROM ORDERTABLE WHERE ORDERTOTAL=150.00), 2);