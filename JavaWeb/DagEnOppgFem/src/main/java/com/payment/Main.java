package com.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration("")
@ComponentScan(basePackages = {"com.payment"})
public class Main {

    @Autowired
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.payment");
        context.refresh();
        Payment pm = context.getBean(CardPayment.class);

        WebShop ws = new WebShop(pm);
        ws.checkout(200);

    }


}
