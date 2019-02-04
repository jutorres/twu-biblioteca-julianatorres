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
    private List<String> bookList;

    @Before
    public void setup() {
        bookList = new ArrayList<>();
        bookList.add("Dom Casmurro");
        bookList.add("Senhora");
        bookList.add("Memorias Postumas de Bras Cubas");
        library = new Library(bookList, printStream);
    }

    @Test
    public void testIfTheWelcomeMessageIsCorrect() {

        library.welcomeMessage();

        verify(printStream).println("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!");

    }

    @Test
    public void testIfTheBookListIsShowing() {

        library.getBookList();

        verify(printStream).println("Dom Casmurro");
        verify(printStream).println("Senhora");
        verify(printStream).println("Memorias Postumas de Bras Cubas");

    }


}
