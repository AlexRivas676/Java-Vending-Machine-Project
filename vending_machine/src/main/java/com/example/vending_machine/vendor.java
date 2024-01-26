package com.example.vending_machine;

public class vendor {
    private String vendorname;
    private String vendoraddress;
    public vendor(){
        vendorname = "Vendor";
        vendoraddress = "1111 vendor drive";

    }
    public String getVendorname(){
        return vendorname;
    }
    public void setVendorname(String vname){
        vendorname = vname;

    }
    public String getVendoraddress(){
       return vendoraddress;
    }
    public void setVendoraddress(String vaddress){
        vendoraddress = vaddress;
    }
}
