package com.twu.library.models;

import com.twu.library.enums.BookStatus;

public class Book {

    private String title;
    private String author;
    private int year;
    private BookStatus bookStatus;

    public Book(String title, String author, int year, BookStatus bookStatus) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.bookStatus = bookStatus;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + year;
    }

}
