/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  1234
 * Created: 04/05/2021
 */

CREATE TABLE CREDITCARDTABLE(
    paymentID int NOT NULL,
    CardID int NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 9000, INCREMENT BY 1)
    cardNumber varchar(40) NOT NULL,
    expiryDate date NOT NULL,
    holderName varchar(50) NOT NULL,
    CVV int NOT NULL,
    PRIMARY KEY (CardID),
    FOREIGN KEY (paymentID) REFERENCES PAYMENTTABLE(paymentID)
);