package com.twu.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    private List<String> bookList = new ArrayList<>();

    public String welcomeMessage() {
        return "Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!";
    }

    public List<String> getBookList() {
        bookList = Arrays.asList("Dom Casmurro", "Senhora", "Memorias Postumas de Bras Cubas");
        return bookList;
    }

}