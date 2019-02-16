package com.twu.library.main;

import com.twu.library.models.*;
import com.twu.library.enums.ProductStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LibraryApp {

    public static void main(String[] args) throws IOException {

        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book("Dom Casmurro", "Machado de Assis", 1900, ProductStatus.AVAILABLE);
        Book book2 = new Book("Senhora", "Jose de Alencar", 1900, ProductStatus.AVAILABLE);
        Book book3 = new Book("Memorias Postumas de Bras Cubas", "Machado de Assis", 1900, ProductStatus.UNAVAILABLE);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        List<Movie> movieList = new ArrayList<>();
        Movie movie1 = new Movie("Schindler's List", 1993, "Steven Spielberg", "10", ProductStatus.AVAILABLE);
        Movie movie2 = new Movie("Requiem for a Dream", 2000, "Darren Aronofsky", "10", ProductStatus.AVAILABLE);
        Movie movie3 = new Movie("Unfaithful", 2002, "Adrian Lyne", "10", ProductStatus.UNAVAILABLE);
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);


        Library library = new Library(bookList, movieList, System.out);
        WelcomeMessage welcomeMessage = new WelcomeMessage(System.out);
        welcomeMessage.printWelcomeMessage();
        Menu menu = new Menu(library);
        menu.showMenu();


    }
}
