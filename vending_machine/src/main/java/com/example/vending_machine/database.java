package com.example.vending_machine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class database {
    private static final String DatabaseURL = "jdbc:mysql://localhost:3306/vendingmachine?useSSL=false";
    private static final String DatabaseUsername = "root";
    private static final String DatabasePassword = "Password123";
    private static final String insertVendor = "INSERT INTO vendor (vendorname, vendoraddress) VALUES (?,?)";
    private static final String editVendor = "UPDATE vendor SET vendorname = ?, vendoraddress = ? WHERE (vendorname = ?)";
    public void insertNewVendor(String vendorname, String vendoraddress) {
        try (Connection connection = DriverManager.getConnection(DatabaseURL, DatabaseUsername, DatabasePassword);
             PreparedStatement preparedStatement = connection.prepareStatement(insertVendor))
        {
            preparedStatement.setString(1, vendorname);
            preparedStatement.setString(2, vendoraddress);

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }

        catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public void editVendor(String vendorname, String vendoraddress, String chosenVendor) {
        try (Connection connection = DriverManager.getConnection(DatabaseURL, DatabaseUsername, DatabasePassword);
             PreparedStatement preparedStatement = connection.prepareStatement(editVendor))
        {
            preparedStatement.setString(1, vendorname);
            preparedStatement.setString(2, vendoraddress);
            preparedStatement.setString(3, chosenVendor);

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }

        catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public static void printSQLException(SQLException ex) {     //sql exception
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    }

