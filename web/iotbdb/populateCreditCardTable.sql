/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  1234
 * Created: 04/05/2021
 */

INSERT INTO CREDITCARDTABLE (PAYMENTID, CARDNUMBER, EXPIRYDATE, HOLDERNAME, CVV)
VALUES
((SELECT PAYMENTID FROM PAYMENTTABLE WHERE PAYMENTTYPE=1), '1234567', '2023-06-02', 'John Smith', '123'),
((SELECT PAYMENTID FROM PAYMENTTABLE WHERE PAYMENTTYPE=1), '7654321', '2023-06-12', 'Ashley Hunter', '321');