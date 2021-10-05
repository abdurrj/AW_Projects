package com.shop.dagenoppgfemv2;

public class VippsPay implements Payment{

    public void pay(int amount){
        System.out.println("Betalt med Vipps: " + amount);
    }
}
