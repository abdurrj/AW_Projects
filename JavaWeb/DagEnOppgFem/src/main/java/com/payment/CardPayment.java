package com.payment;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class CardPayment implements Payment{

    public CardPayment  cardPayment(){
        return new CardPayment();
    }

    public void pay(int amount){
        System.out.println("From Card: " + amount);
    }
}
