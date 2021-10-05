package com.shop.dagenoppgfemv2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(MyConfig.class);
        ctx.refresh();

        System.out.println("\n\n\n______________________________");

        WebShop wsCard = new WebShop(ctx.getBean(CardPay.class));
        wsCard.checkout(200);
        System.out.println();
        WebShop wsVipps = new WebShop(ctx.getBean(VippsPay.class));
        wsVipps.checkout(200);
        System.out.println();
        WebShop wsPayPal = new WebShop(ctx.getBean(PayPalPay.class));
        wsPayPal.checkout(200);


    }

}
