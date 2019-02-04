package com.twu.library;

public class LibraryApp {

    public static void main(String[] args) {

        Library library = new Library();
        System.out.println(library.welcomeMessage());
        System.out.println(library.getBookList());

    }
}
