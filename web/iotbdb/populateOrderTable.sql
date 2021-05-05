/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  1234
 * Created: 04/05/2021
 */

INSERT INTO ORDERTABLE (CUSTOMERID, DATEORDERED, ORDERTOTAL)
VALUES
((SELECT CUSTOMERID FROM CUSTOMERTABLE WHERE POSTCODE=2134), '2021-06-02', 100.00),
((SELECT CUSTOMERID FROM CUSTOMERTABLE WHERE POSTCODE=2567), '2021-06-12', 150.00);