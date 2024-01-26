package com.example.vending_machine;
public class product {
    private int rol;
    private String Sku;
    private String productname;
    private String productdesc;
    protected double itemprice;
    private int productid;
    private String expdate;
    private int calories;
    public product(){
        productname = "product";
        itemprice=0;
        productid = 0;
        expdate = "10/25/0000";
        calories=0;
        rol = 0;

    }
    public String getProductname(){
        return productname;
    }
    public void setProductname(String pname){
        productname=pname;
    }
    public  double getItemprice(){
        return itemprice;
    }
    public void setItemprice(double itprice){
        itemprice=itprice;
    }
    public int getProductid(){
        return productid;
    }
    public void setProductid(int pid){
        productid=pid;
    }
    public String getExpdate(){
        return expdate;
    }
    public void setExpdate(String expdate){
        this.expdate=expdate;
    }
    public int getCalories(){
        return calories;
    }
    public void setCalories(int cal){
        calories = cal;
    }
    public void setSku(String sku){
      this.Sku = sku;
    }
    public String getSku(){
        return  Sku;
    }
    public String getProductdesc(){
        return productdesc;
    }
    public void setProductdesc(String pdesc){
        productdesc = pdesc;
    }
    public int getRol(){
        return rol;
    }
    public void setRol(int reorderlevel){
        rol = reorderlevel;
    }






    
}
