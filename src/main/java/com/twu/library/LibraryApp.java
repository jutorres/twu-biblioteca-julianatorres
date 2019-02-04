package com.twu.library;

import java.util.Arrays;
import java.util.List;

public class LibraryApp {

    public static void main(String[] args) {

        List<String> bookList = Arrays.asList("Dom Casmurro", "Senhora", "Memorias Postumas de Bras Cubas");
        Library library = new Library(bookList, System.out);
        library.welcomeMessage();
        library.getBookList();

    }
}
