package iotb.model.dao;

import java.sql.Connection;

public abstract class database {
    protected String URL = "jdbc:derby://localhost:1527/";
    protected String database = "usersdb";
    protected String databaseUser = "isduser";
    protected String databasePass = "admin";
    protected String databaseDriver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection con;
}
