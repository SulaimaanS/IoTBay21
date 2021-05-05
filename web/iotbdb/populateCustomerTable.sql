/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  1234
 * Created: 04/05/2021
 */

INSERT INTO CUSTOMERTABLE (USERID, DOB, POSTCODE)
VALUES
((SELECT USERID FROM USERTABLE WHERE FIRSTNAME='John'), '1997-06-02', 2134),
((SELECT USERID FROM USERTABLE WHERE FIRSTNAME='Ashley'), '1998-05-02', 2567);