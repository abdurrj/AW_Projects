package com.payment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class CardPayment implements Payment{
    CardPayment cardPayment;


    public void pay(int amount){
        System.out.println("From Card: " + amount);
    }
}
