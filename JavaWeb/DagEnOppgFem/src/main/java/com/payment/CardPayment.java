package com.payment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("CardPayment")
public class CardPayment implements Payment{


    public void pay(int amount){
        System.out.println("From Card: " + amount);
    }
}
