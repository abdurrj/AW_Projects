package com.example.restcontroller;

public class Book {
    private int price;
    private String title;
    private String author;

    public Book(int price, String title, String author) {
        this.price = price;
        this.title = title;
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
