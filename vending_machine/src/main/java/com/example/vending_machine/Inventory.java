package com.example.vending_machine;

import java.util.HashMap;

public class Inventory extends product {
    private int productqty;
    private String producttype;
   private int location;
    private int Batchnum;
    private  String Batch;
    protected double total;
    public Inventory(){
        productqty = 0;
        producttype = "Snack";
        location =0;
    }
    public int getproductqty(){
        return productqty;
    }
    public void setProductqty(int pqty){
        productqty =pqty;
    }
    public String getProducttype(){
        return producttype;
    }
    public void setProducttype(String ptype){
        producttype = ptype;
    }

    public int getlocation(){
        return location;

    }
    public void setLocation(int loc){
        location = loc;

    }
    public double gettotal(){
        return total;
    }
    public void setTotal(double t){
        t = productqty*itemprice;
         total = t;

    }
    public int getBatchnum(){
        return  Batchnum;
    }
    public void setBatchnum(int bnum){
        Batchnum = bnum;
    }
    public String getBatch(){
        return Batch;
    }
    public void setBatch(String Batch){
        this.Batch = Batch;
    }



}

