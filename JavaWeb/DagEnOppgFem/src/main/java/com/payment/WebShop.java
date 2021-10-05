package com.payment;

public class WebShop{
    Payment pm;

    public WebShop(Payment pm) {
        this.pm = pm;
    }


    public void checkout(int amount){
        pm.pay(amount);
    }
}
