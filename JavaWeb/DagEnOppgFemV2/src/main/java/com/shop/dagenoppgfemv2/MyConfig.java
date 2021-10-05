package com.shop.dagenoppgfemv2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public CardPay payment(){
        return new CardPay();
    }

    @Bean
    public VippsPay vippsPay(){
        return new VippsPay();
    }

    @Bean PayPalPay payPalPay(){
        return new PayPalPay();
    }
}
