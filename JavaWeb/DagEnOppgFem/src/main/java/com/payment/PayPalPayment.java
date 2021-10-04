package com.payment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("PayPalPayment")
public class PayPalPayment implements Payment{

    @Override
    public void pay(int amount){
        System.out.println("From PayPal: " + amount);
    }
}
