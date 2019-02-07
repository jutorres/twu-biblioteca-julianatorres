package com.twu.library;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    private Menu menu;
    @Mock
    private Library mockLibrary;
    @Mock
    private PrintStream mockPrintStream;

    @Test
    public void testIfWhenUserSelectTheFirstMenuOptionTheBookListAppears() throws IOException {

        menu = new Menu(System.out, new BufferedReader(new StringReader("1\n0")) , mockLibrary);

        menu.showMenu();

        verify(mockLibrary).getBookList();

    }

    @Test
    public void testIfTheMessageInvalidOptinAppearesWhenUserPutUnInvalidMenuNumber() throws IOException {

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("10\n0")) , mockLibrary);

        menu.showMenu();

        verify(mockPrintStream).println("Please, select a valid option!");
    }

    @Test
    public void testIfCostumerCouldUseLibrarySystemUntilChooseTheOptionQuit() throws IOException {

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("0")) , mockLibrary);

        menu.showMenu();

        verify(mockPrintStream).println("Goodbye, You quit the library system");
    }

    @Test
    public void testBookCheckoutOperation() throws IOException {

        int index = 1;

        Book book = new Book("Dom Casmurro", "Machado de Assis", 1900, BookStatus.AVAILABLE);

        when(mockLibrary.getAnSpecificBookFromListSelectedByCostumer(index)).thenReturn(book);

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("2\n1\n0")) , mockLibrary);

        menu.showMenu();

        verify(mockLibrary, times(2)).getAnSpecificBookFromListSelectedByCostumer(index);

        assertThat(book.getBookStatus(), is(BookStatus.UNAVAILABLE));

        verify(mockPrintStream).println("Thank you! Enjoy the book!");

    }

    @Test
    public void testBookCheckoutOperationWithAnUnavailableBook() throws IOException {

        int index = 1;

        Book book = new Book("Dom Casmurro", "Machado de Assis", 1900, BookStatus.UNAVAILABLE);

        when(mockLibrary.getAnSpecificBookFromListSelectedByCostumer(index)).thenReturn(book);

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("2\n1\n0")) , mockLibrary);

        menu.showMenu();

        verify(mockLibrary).getAnSpecificBookFromListSelectedByCostumer(index);

        verify(mockPrintStream).println("Sorry, that book is not available!");

    }

}
