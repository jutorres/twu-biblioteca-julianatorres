package com.twu.library;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<String> bookList = new ArrayList<>();
    private PrintStream printStream;

    public Library(List<String> bookList, PrintStream printStream) {
        this.bookList = bookList;
        this.printStream = printStream;
    }

    public void welcomeMessage() {
        printStream.println("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!");
    }

    public void getBookList() {

        for (String book: bookList) {
            printStream.println(book);
        }
    }

}