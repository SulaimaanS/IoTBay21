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
((SELECT USERID FROM USERTABLE WHERE FIRSTNAME='Ashley'), '1998-05-02', 2567),
((SELECT USERID FROM USERTABLE WHERE PHONENUMBER='5435235'), '1997-10-28', 4632),
((SELECT USERID FROM USERTABLE WHERE PHONENUMBER='2532546'), '1997-01-30', 7543),
((SELECT USERID FROM USERTABLE WHERE PHONENUMBER='24564362'), '1997-08-12', 7562),
((SELECT USERID FROM USERTABLE WHERE PHONENUMBER='65436436'), '1997-05-14', 9857),
((SELECT USERID FROM USERTABLE WHERE PHONENUMBER='3463428'), '1997-11-15', 3748),
((SELECT USERID FROM USERTABLE WHERE PHONENUMBER='64703453'), '1997-12-18', 8644),
((SELECT USERID FROM USERTABLE WHERE PHONENUMBER='23589763'), '1997-07-20', 9648),
((SELECT USERID FROM USERTABLE WHERE PHONENUMBER='43677967'), '1998-03-22', 8563);