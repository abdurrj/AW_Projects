package com.shop.dagenoppgfemv2;

public class PayPalPay implements Payment{

    public void pay(int amount){
        System.out.println("Betalt med PayPal: " + amount);
    }
}
