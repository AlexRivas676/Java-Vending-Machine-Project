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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Vendingmachinecontroller {
    private static final String DatabaseURL = "jdbc:mysql://localhost:3306/vendingmachine?useSSL=false";
    private static final String DatabaseUsername = "root";
    private static final String DatabasePassword = "Password123";
    private Scene scene;
    @FXML
    private ComboBox userComboBox;
    @FXML
    private Label welcomeText;
    @FXML
    private Button purchasebutton1;
    @FXML
    private Button cancelbutton;
    @FXML
    private Button adminbutton;
    @FXML
    private Button loginbutton;
    @FXML
    private Button newproduct;
    @FXML
    private Button newvendor;
    @FXML
    private  Button editproduct;
    @FXML
    private Button editvendor;
    @FXML
    private TextField usernametext;
    @FXML
    public TextField skutext;
    @FXML
    public  TextField pricetext;
    @FXML
    public TextField expdatetext;
    @FXML
    public TextField caltext;
    @FXML
    public   TextField ccvtext;
    @FXML
    public   TextField vendornametext;
    @FXML
    public TextField vendoraddresstext;
    @FXML
    public TextField ccnumtext;
    @FXML
    public  TextField roltext;
    @FXML
    public   TextField pnametext;
    @FXML
    public TextField pdesctext;
    @FXML
    public   Button connectproduct;
    @FXML
    private  Button backbutton;
    @FXML
    public Button connectVendor;
    @FXML
    private Button backbutton1;
    @FXML
    private  Button Submit;
    @FXML
    private TextField passwordtext;
    @FXML
    private TextField vendorNameText;
    @FXML
    private TextField vendorAddressText;
    @FXML
    private ComboBox vendorCombo;
    private Stage stage;

    private ObservableList comboBoxOptions= FXCollections.observableArrayList();
    private PreparedStatement sendIt;

    public void onadminbuttonclick() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) adminbutton.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("admin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void oncancelbuton()throws IOException{
        Stage stage;
        Parent root;
        stage =(Stage)  cancelbutton.getScene().getWindow();
        root = FXMLLoader.load(this.getClass().getResource("vendingmachinemain.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void onloginbutton() throws IOException{
        Stage stage;
        Parent root;
        String username;
        String password;
        username = usernametext.getText();
        password =passwordtext.getText();
            if(username.equals("admin") && password.equals("password")){
                stage = (Stage) loginbutton.getScene().getWindow();
                root = FXMLLoader.load(this.getClass().getResource("VendorAdmin.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            if(!username.equals("admin") && !password.equals("password") || username.equals("")&& password.equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Enter a Valid Password or Username!");
                alert.show();

            }
    }

    public void onnewproductbuttonclick()throws IOException{
     Stage stage;
     Parent root1;
     stage =(Stage) newproduct.getScene().getWindow();
     root1= FXMLLoader.load(getClass().getResource("product.fxml"));
     Scene scene = new Scene(root1);
     stage.setScene(scene);
     stage.show();

    }
    public void oneditproductbuttonclick() throws IOException {
        Stage stage;
        Parent root1;
        stage =(Stage) editproduct.getScene().getWindow();
        root1= FXMLLoader.load(getClass().getResource("product.fxml"));
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }
    public void oneditvendorbuttonclick()throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) editvendor.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("vendor.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onnewvendorbuttonclick()throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) newvendor.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("newVendor.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    public void onpurchasebutton() throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) purchasebutton1.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("cc.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onbackbuttonclick() throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) backbutton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Vendoradmin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onbackbutton1click() throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) backbutton1.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void backToMenuButtonClick(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("VendorAdmin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void insertVendorClick()
    {
        //receiving from textfield
        String newUsername = vendorNameText.getText();
        String newPassword = vendorAddressText.getText();


        //sending to database
        try
        {
            database newInsert = new database();
            newInsert.insertNewVendor(newUsername, newPassword);
        }

        catch(Exception e)
        {
            printException((SQLException) e);
        }
    }

    public static void printException(SQLException ex)
    {     //sql exception
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);

                //messages to print if errors
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
/*
    vendingdao vending = new vendingdao();
    @FXML
    public void onconnectproductbuttonclick() throws IOException {
            String productsku = skutext.getText();
            String pname = pnametext.getText();
            String pdesc = pdesctext.getText();
            double itemprice = Double.parseDouble(pricetext.getText());
            int cal = Integer.parseInt(caltext.getText());
            int rol = Integer.parseInt(roltext.getText());
            if (!productsku.equals("") && !pname.equals("") && !pdesc.equals("") && itemprice != 0 || !(itemprice < 0) && cal != 0 || !(cal < 0) && rol != 0 || !(rol < 0)) {
                try {
                    product product = this.vending.creatingproduct(productsku, pname, pdesc, itemprice, cal, rol);
                    int pid = this.vending.insertingproduct(product);
                    if (pid > 0) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("Success");
                        alert.show();
                    }
                } catch (Exception e) {
                    System.out.println("Failed");
                }

            }
    }

 */
    /*
    @FXML
    public void onconnectvendorbuttonclick() throws IOException {
            String vname  = vendornametext.getText();
            String vaddress = vendoraddresstext.getText();

            if (!vname.equals("") &&!vaddress.equals("")) {
                try {
                    vendor vendor = this.vending.creatingvendor(vname,vaddress);
                    int pid = this.vending.insertingvendor(vendor);
                    if (pid > 0) {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("Success");
                        alert.show();
                    }
                } catch (Exception e) {
                    System.out.println("Failed");
                }

            }


    }

     */
}

