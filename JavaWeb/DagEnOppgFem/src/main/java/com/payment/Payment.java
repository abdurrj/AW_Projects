package com.payment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


public interface Payment {

    void pay(int amount);
}
