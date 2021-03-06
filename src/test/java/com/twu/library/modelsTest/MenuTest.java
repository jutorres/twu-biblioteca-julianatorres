package com.twu.library.modelsTest;

import com.twu.library.models.*;
import com.twu.library.enums.ProductStatus;
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

        menu = new Menu(System.out, new BufferedReader(new StringReader("1\n9")) , mockLibrary);

        menu.showMenu();

        verify(mockLibrary).getBookList(ProductStatus.AVAILABLE);

    }

    @Test
    public void testIfTheMessageInvalidOptinAppearesWhenUserPutUnInvalidMenuNumber() throws IOException {

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("10\n9")) , mockLibrary);

        menu.showMenu();

        verify(mockPrintStream).println("Please, select a valid option!\n");
    }

    @Test
    public void testIfCostumerCouldUseLibrarySystemUntilChooseTheOptionQuit() throws IOException {

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("9")) , mockLibrary);

        menu.showMenu();

        verify(mockPrintStream).println("Goodbye, You quit the library system");
    }

    @Test
    public void testBookCheckoutOperation() throws IOException {

        int index = 1;

        Book book = new Book("Dom Casmurro", "Machado de Assis", 1900, ProductStatus.AVAILABLE);

        when(mockLibrary.getAnSpecificBookFromListSelectedByCostumer(index)).thenReturn(book);

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("2\n1\n9")) , mockLibrary);

        menu.showMenu();

        verify(mockLibrary, times(2)).getAnSpecificBookFromListSelectedByCostumer(index);

        assertThat(book.getProductStatus(), is(ProductStatus.UNAVAILABLE));

        verify(mockPrintStream).println("Thank you! Enjoy the book!\n");

    }

    @Test
    public void testBookCheckoutOperationWithAnUnavailableBook() throws IOException {

        int index = 1;

        Book book = new Book("Dom Casmurro", "Machado de Assis", 1900, ProductStatus.UNAVAILABLE);

        when(mockLibrary.getAnSpecificBookFromListSelectedByCostumer(index)).thenReturn(book);

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("2\n1\n9")) , mockLibrary);

        menu.showMenu();

        verify(mockLibrary).getAnSpecificBookFromListSelectedByCostumer(index);

        verify(mockPrintStream).println("Sorry, that book is not available!\n");

    }

    @Test
    public void testMovieCheckoutOperation() throws IOException {

        int index = 1;

        Movie movie = new Movie("Schindler's List", 1993, "Steven Spielberg", "10", ProductStatus.AVAILABLE);

        when(mockLibrary.getAnSpecificMovieFromListSelectedByCostumer(index)).thenReturn(movie);

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("5\n1\n9")) , mockLibrary);

        menu.showMenu();

        verify(mockLibrary, times(2)).getAnSpecificMovieFromListSelectedByCostumer(index);

        assertThat(movie.getProductStatus(), is(ProductStatus.UNAVAILABLE));

        verify(mockPrintStream).println("Thank you! Enjoy the movie!\n");

    }

    @Test
    public void testMovieCheckoutOperationWithAnUnavailableBook() throws IOException {

        int index = 1;

        Movie movie = new Movie("Unfaithful", 2002, "Adrian Lyne", "10", ProductStatus.UNAVAILABLE);

        when(mockLibrary.getAnSpecificMovieFromListSelectedByCostumer(index)).thenReturn(movie);

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("5\n1\n9")) , mockLibrary);

        menu.showMenu();

        verify(mockLibrary).getAnSpecificMovieFromListSelectedByCostumer(index);

        verify(mockPrintStream).println("Sorry, that movie is not available!\n");

    }

    @Test
    public void testBookReturnOperation() throws IOException {

        int index = 1;

        Book book = new Book("Dom Casmurro", "Machado de Assis", 1900, ProductStatus.UNAVAILABLE);

        when(mockLibrary.getAnSpecificBookFromListSelectedByCostumer(index)).thenReturn(book);

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("3\n1\n9")) , mockLibrary);

        menu.showMenu();

        verify(mockLibrary, times(2)).getAnSpecificBookFromListSelectedByCostumer(index);

        assertThat(book.getProductStatus(), is(ProductStatus.AVAILABLE));

        verify(mockPrintStream).println("Thank you for returning the book!\n");
    }

    @Test
    public void testBookReturnOperationWithAnAvailableBook() throws IOException {

        int index = 1;

        Book book = new Book("Dom Casmurro", "Machado de Assis", 1900, ProductStatus.AVAILABLE);

        when(mockLibrary.getAnSpecificBookFromListSelectedByCostumer(index)).thenReturn(book);

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("3\n1\n9")) , mockLibrary);

        menu.showMenu();

        verify(mockLibrary).getAnSpecificBookFromListSelectedByCostumer(index);

        verify(mockPrintStream).println("That is not a valid book to return!\n");

    }

}
