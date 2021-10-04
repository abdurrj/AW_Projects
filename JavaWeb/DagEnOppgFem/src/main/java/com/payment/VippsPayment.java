package com.payment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("VippsPayment")
public class VippsPayment implements Payment{

    public void pay(int amount){
        System.out.println("From Vipps: " + amount);
    }
}
