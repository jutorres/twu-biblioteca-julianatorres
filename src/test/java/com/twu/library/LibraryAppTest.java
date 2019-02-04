package com.twu.library;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LibraryAppTest {

    private Library library;
    @Mock
    private PrintStream printStream;
    private List<Book> bookList;

    @Before
    public void setup() {
        Book book1 = new Book("Dom Casmurro", "Machado de Assis", 1900);
        Book book2 = new Book("Senhora", "Jose de Alencar", 1900);
        Book book3 = new Book("Memorias Postumas de Bras Cubas", "Machado de Assis", 1900);
        bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        library = new Library(bookList, printStream);
    }

    @Test
    public void testIfTheWelcomeMessageIsCorrect() {

        library.welcomeMessage();

        verify(printStream).println("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!");

    }

//    @Test
//    public void testIfTheBookListIsShowing() {
//
//        library.getBookList();
//
//        verify(printStream).println("Dom Casmurro");
//        verify(printStream).println("Senhora");
//        verify(printStream).println("Memorias Postumas de Bras Cubas");

//    }

    @Test
    public void viewAuthorAndPublicationYearOnAllBooks() {

        library.getBookList();

        for (Book book : bookList) {
            verify(printStream).println(book);

        }

    }


}
