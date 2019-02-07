package com.twu.library.main;

import com.twu.library.models.Book;
import com.twu.library.models.Library;
import com.twu.library.models.Menu;
import com.twu.library.models.WelcomeMessage;
import com.twu.library.enums.BookStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LibraryApp {

    public static void main(String[] args) throws IOException {

        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book("Dom Casmurro", "Machado de Assis", 1900, BookStatus.AVAILABLE);
        Book book2 = new Book("Senhora", "Jose de Alencar", 1900, BookStatus.AVAILABLE);
        Book book3 = new Book("Memorias Postumas de Bras Cubas", "Machado de Assis", 1900, BookStatus.UNAVAILABLE);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        Library library = new Library(bookList, System.out);
        WelcomeMessage welcomeMessage = new WelcomeMessage(System.out);
        welcomeMessage.printWelcomeMessage();
        Menu menu = new Menu(library);
        menu.showMenu();


    }
}
