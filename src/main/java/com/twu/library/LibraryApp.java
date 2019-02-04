package com.twu.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryApp {

    public static void main(String[] args) {

        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book("Dom Casmurro", "Machado de Assis", 1900);
        Book book2 = new Book("Senhora", "Jose de Alencar", 1900);
        Book book3 = new Book("Memorias Postumas de Bras Cubas", "Machado de Assis", 1900);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        Library library = new Library(bookList, System.out);
        library.welcomeMessage();
        library.getBookList();

    }
}
