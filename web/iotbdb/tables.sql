CREATE TABLE USERTABLE(
    userID int NOT NULL, 
    firstName varchar(30) NOT NULL,
    lastName varchar(30) NOT NULL,
    dob date NOT NULL,
    phoneNumber varchar(20) NOT NULL,
    emailAddress varchar(50) NOT NULL,
    streetNumber int NOT NULL,
    streetName varchar(20) NOT NULL,
    postCode int NOT NULL,
    PRIMARY KEY (userID)
);


CREATE TABLE STAFFTABLE(
    userID int NOT NULL, 
    staffID int NOT NULL,
    authorised boolean,
    PRIMARY KEY (staffID),
    FOREIGN KEY (userID) REFERENCES USERTABLE(userID)
);