package com.example.vending_machine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class vendingmachinedatabase {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/vendingmachine";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Password123";

    private vendingmachinedatabase() {

    }

    public static Connection gettingdbconnection() throws SQLException {
        Connection dbconnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException exception) {
            System.out.println("Could not find class!");

        }
        try{
            dbconnection = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
            return dbconnection;

        }catch(SQLException exception){
            System.out.println("Failed Connection!");
        }
        return dbconnection;
    }
}
