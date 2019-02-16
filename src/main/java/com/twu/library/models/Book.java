package com.twu.library.models;


import com.twu.library.enums.ProductStatus;

public class Book extends Product{

    private String author;

    public Book(String title, String author, int year, ProductStatus productStatus) {
        super.title = title;
        this.author = author;
        super.year = year;
        super.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + year ;
    }

}
