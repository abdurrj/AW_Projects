package com.shop.dagenoppgfemv2;

public class CardPay implements Payment {

    public void pay(int amount){
        System.out.println("Betalt med kort: " + amount);
    }
}
