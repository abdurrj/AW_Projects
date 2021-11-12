package com.example.checkpoint_9;

import java.util.Map;

public class Exchange {

    private Map<String, Double> rates;
    private String base;
    private String date;

    public Map<String, Double> getRates() {
        return rates;
    }


    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
