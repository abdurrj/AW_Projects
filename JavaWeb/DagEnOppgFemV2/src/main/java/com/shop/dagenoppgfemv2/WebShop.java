package com.shop.dagenoppgfemv2;

public class WebShop {
    private Payment payment;

    public WebShop(Payment payment){
        this.payment = payment;
    }

    public void checkout(int amount){
        payment.pay(amount);
    }
}
