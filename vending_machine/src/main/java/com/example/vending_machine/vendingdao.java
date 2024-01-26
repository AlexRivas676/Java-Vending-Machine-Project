package com.example.vending_machine;

import java.sql.*;

public class vendingdao {
    vendingdao(){

    }
/*
    public int insertingproduct(product vendingmachineproduct) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        //HashMap product = new HashMap();
        int var = 0;
        try {
            connection = database.gettingdbconnection();
            connection.setAutoCommit(false);
            String sqlquery = "INSERT INTO product(pid,sku,pn,pdesc,cal,rol,createdby,createddate,modifiedby,modifieddate,isdeleted) Values(?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sqlquery, 1);
            int counter = 1;
            statement.setString(counter++, vendingmachineproduct.getSku());
            statement.setString(counter++, vendingmachineproduct.getProductname());
            statement.setString(counter++, vendingmachineproduct.getProductdesc());
            statement.setDouble(counter++, vendingmachineproduct.getItemprice());
            statement.setInt(counter++, vendingmachineproduct.getCalories());
            statement.setInt(counter++, vendingmachineproduct.getRol());
            statement.executeUpdate();
            connection.commit();
            results = statement.getGeneratedKeys();
            if (results.next()) {
                return 0;
            }
            var = results.getInt(1);
        } catch (SQLException e) {
            System.out.println("failed ");
            if (null != connection) {
                connection.rollback();

            }

        } finally {
            if (null != results) {
                results.close();
            }

            if (null != statement) {
                statement.close();
            }
            if (null != connection) {
                connection.close();
            }
        }
        return var;
        }
 /*
    public int insertingvendor(vendor vendingmachinevendor) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        //HashMap product = new HashMap();
        int var = 0;
        try {
            connection = database.gettingdbconnection();
            connection.setAutoCommit(false);
            String sqlquery = "INSERT INTO vendor(vid ,vendorname,vendoraddress,createdby,createddate,modifiedby,modifieddate,isdeleted) Values(?,?,?,?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sqlquery, Statement.RETURN_GENERATED_KEYS);
            int counter = 1;
            statement.setString(counter++, vendingmachinevendor.getVendorname());
            statement.setString(counter++, vendingmachinevendor.getVendoraddress());

            statement.executeUpdate();
            connection.commit();
            results = statement.getGeneratedKeys();
            if (results.next()) {
                return results.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("failed ");
            if (null != connection) {
                connection.rollback();

            }

        } finally {
            if (null != results) {
                results.close();
            }

            if (null != statement) {
                statement.close();
            }
            if (null != connection) {
                connection.close();
            }
        }
        return  results.getInt(1);


    }
    public product creatingproduct(String sku,String pname,String productdesc,double price,int cal,int rol){
        product product = new product();
        product.setSku(sku);
        product.setProductname(pname);
        product.setProductdesc(productdesc);
        product.setItemprice(price);
        product.setCalories(cal);
        product.setRol(rol);
        return product;
    }

    /*public int  updatingproduct() throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;

    }*/

    public vendor creatingvendor(String vendorname,String vendoraddress){
        vendor vendor = new vendor();
        vendor.setVendorname(vendorname);
        vendor.setVendoraddress(vendoraddress);
        return vendor;
    }
}
