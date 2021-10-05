package com.payment;


import org.springframework.stereotype.Component;

@Component
public class VippsPayment implements Payment{

    public void pay(int amount){
        System.out.println("From Vipps: " + amount);
    }
}
