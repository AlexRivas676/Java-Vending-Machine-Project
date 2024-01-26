package com.example.vending_machine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class editVendorcontroller implements Initializable {
    private static final String DatabaseURL = "jdbc:mysql://localhost:3306/vendingmachine";
    private static final String DatabaseUsername = "root";
    private static final String DatabasePassword = "Password123";
    @FXML
    private TextField vendorNameText;
    @FXML
    private TextField vendorAddressText;
    @FXML
    private Button backtomenu;
    @FXML
    private ComboBox vendorCombo;
    private String editVendorName;
    private String editVendorAddress;
    private String chosenUser;
    private ObservableList vendorcomboboxvalues= FXCollections.observableArrayList();
    private PreparedStatement selectingvendor;
    private Stage stage;
    private Scene scene;
    private void gettingvendor()
    {
        //removing lists
        vendorcomboboxvalues.removeAll(vendorcomboboxvalues);
        try {
            Connection connection = DriverManager.getConnection(DatabaseURL, DatabaseUsername, DatabasePassword);
            selectingvendor = connection.prepareStatement("SELECT vendorname FROM vendor");
            ResultSet queryresult = selectingvendor.executeQuery();
            LinkedList<String> llist1 = new LinkedList<>();
            while (queryresult.next())
            {
                try
                {
                    llist1.removeAll(llist1);
                    llist1.add(queryresult.getString("vendorname"));
                    //String changeVendorName;
                }

                catch (SQLException e)
                {
                   System.out.print(e.toString());
                }
                vendorCombo.getItems().addAll(llist1);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    @Override
    public void initialize(URL link, ResourceBundle rB)
    {
        gettingvendor();
        vendorCombo.setOnAction(this::getvendor);
    }

    public void getvendor(Event event)
    {
        String vendor = vendorCombo.getValue().toString();
        final String selectingvendorquery = "SELECT vendorname FROM vendor WHERE vendorname = ?";
        try (Connection connection = DriverManager.getConnection(DatabaseURL, DatabaseUsername, DatabasePassword);
             PreparedStatement gettingvendorstatement = connection.prepareStatement(selectingvendorquery))
        {
            gettingvendorstatement.setString(1, vendor);
            ResultSet queryresults = gettingvendorstatement.executeQuery();

            if(queryresults.next())
            {
                String gotvendor = queryresults.getString("vendorname");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public void connectVendorClick()
    {
        //receiving from textfield
        editVendorName = vendorNameText.getText();
        editVendorAddress = vendorAddressText.getText();
        chosenUser = vendorCombo.getValue().toString();


        //sending to database
        try
        {
            database editDatabase = new database();
            editDatabase.editVendor(editVendorName, editVendorAddress, chosenUser);
        }

        catch(Exception e)
        {
            System.out.println(e.toString());;
        }
    }

    public void backToMenu() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("VendorAdmin.fxml"));
        stage = (Stage)  backtomenu.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
