package iotb.model.dao;

import java.sql.Connection;

public abstract class Database {
    protected String URL = "jdbc:derby://localhost:1527/";
    protected String database = "IoTBayDB";
    protected String databaseUser = "IoTBayAdmin";
    protected String databasePass = "admin";
    protected String databaseDriver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection con;
}
