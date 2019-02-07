package com.twu.library;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {

    private Library library;
    @Mock
    private PrintStream mockPrintStream;
    private List<Book> bookList;

    @Before
    public void setup() {
        Book book1 = new Book("Dom Casmurro", "Machado de Assis", 1900, BookStatus.AVAILABLE);
        Book book2 = new Book("Senhora", "Jose de Alencar", 1900, BookStatus.AVAILABLE);
        Book book3 = new Book("Memorias Postumas de Bras Cubas", "Machado de Assis", 1900, BookStatus.UNAVAILABLE);

        bookList = new ArrayList<>();

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        library = new Library(bookList, mockPrintStream);
    }

    @Test
    public void testIfOnlyAvailableBooksAppearsInList() {

        library.getAvailableBookList();

        verify(mockPrintStream).println(bookList.get(0));
        verify(mockPrintStream, times(0)).println(bookList.get(2));

    }

    @Test
    public void testIfReturnAnSpecificBookFromListSelectedByCostumer() {

        Book selectedBook = bookList.get(0);

        assertThat(selectedBook, equalTo(library.getAnSpecificBookFromListSelectedByCostumer(1)));

    }


}
