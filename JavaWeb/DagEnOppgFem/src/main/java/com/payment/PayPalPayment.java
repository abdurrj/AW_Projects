package com.payment;

import org.springframework.stereotype.Component;

@Component
public class PayPalPayment implements Payment{

    @Override
    public void pay(int amount){
        System.out.println("From PayPal: " + amount);
    }
}
