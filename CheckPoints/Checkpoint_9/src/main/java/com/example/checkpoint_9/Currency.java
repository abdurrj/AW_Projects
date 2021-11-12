package com.example.checkpoint_9;

public class Currency {

    private double converted;
    private String currency;
    private int amount;

    public Currency(double converted, String currency, int amount) {
        this.converted = converted;
        this.currency = currency;
        this.amount = amount;
    }

    public double getConverted() {
        return converted;
    }

    public void setConverted(double converted) {
        this.converted = converted;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
