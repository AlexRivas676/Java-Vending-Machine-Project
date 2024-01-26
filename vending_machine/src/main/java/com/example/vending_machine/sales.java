package com.example.vending_machine;

public class sales extends Inventory  implements sale  {
private double salestotal;
private int creditcardnum;
private int ccv;
private int cardpin;

public sales(){
    salestotal = 0;
    creditcardnum=12345678;
     ccv = 111;
     cardpin =1111; 
}
public double getSalestotal(){
    return salestotal;
}
public void setSalestotal(){
    salestotal = total * salestax;

}
public int getCreditcardnum(){
    return creditcardnum;
}
public void setCreditcardnum(int ccnum){
    creditcardnum = ccnum;
}
public int getCcv() {
     return creditcardnum;
    }public void setCcv(int ccv) {
        this.ccv = ccv;
    }
    public int getCardpin(){
    return cardpin;
    }
    public void setCardpin(int pin){
    cardpin=pin;
    }
}
