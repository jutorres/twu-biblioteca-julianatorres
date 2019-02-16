package com.twu.library.modelsTest;

import com.twu.library.models.Book;
import com.twu.library.models.Library;
import com.twu.library.enums.ProductStatus;
import com.twu.library.models.Movie;
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
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {

    private Library library;
    @Mock
    private PrintStream mockPrintStream;
    private List<Book> bookList;
    private List<Movie> movieList;

    @Before
    public void setup() {
        Book book1 = new Book("Dom Casmurro", "Machado de Assis", 1900, ProductStatus.AVAILABLE);
        Book book2 = new Book("Senhora", "Jose de Alencar", 1900, ProductStatus.AVAILABLE);
        Book book3 = new Book("Memorias Postumas de Bras Cubas", "Machado de Assis", 1900, ProductStatus.UNAVAILABLE);
        bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        Movie movie1 = new Movie("Schindler's List", 1993, "Steven Spielberg", "10", ProductStatus.AVAILABLE);
        Movie movie2 = new Movie("Requiem for a Dream", 2000, "Darren Aronofsky", "10", ProductStatus.AVAILABLE);
        Movie movie3 = new Movie("Unfaithful", 2002, "Adrian Lyne", "10", ProductStatus.UNAVAILABLE);
        movieList = new ArrayList<>();
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);


        library = new Library(bookList, movieList, mockPrintStream);
    }

    @Test
    public void testIfOnlyAvailableBooksAppearsInList() {

        int listSize = library.getBookList(ProductStatus.AVAILABLE).size();

        assertEquals(listSize, 2);

    }

    @Test
    public void testIfIsPrintingTheAvailableListBook() {

        library.printFilteredBookList(library.getBookList(ProductStatus.AVAILABLE));

        verify(mockPrintStream).println(bookList.get(0));
        verify(mockPrintStream, times(0)).println(bookList.get(2));

    }

    @Test
    public void testIfIsPrintingTheUnavailableListBook() {

        library.printFilteredBookList(library.getBookList(ProductStatus.UNAVAILABLE));

        verify(mockPrintStream).println(bookList.get(2));
        verify(mockPrintStream, times(0)).println(bookList.get(0));
        verify(mockPrintStream, times(0)).println(bookList.get(1));

    }

    @Test
    public void testIfReturnAnSpecificBookFromListSelectedByCostumer() {

        Book selectedBook = bookList.get(0);

        assertThat(selectedBook, equalTo(library.getAnSpecificBookFromListSelectedByCostumer(1)));

    }

    @Test
    public void testIfOnlyAvailableMoviesAppearsInList() {

        int listSize = library.getMovieList(ProductStatus.AVAILABLE).size();

        assertEquals(listSize, 2);

    }

    @Test
    public void testIfIsPrintingTheAvailableListMovie() {

        library.printFilteredMovieList(library.getMovieList(ProductStatus.AVAILABLE));

        verify(mockPrintStream).println(movieList.get(0));
        verify(mockPrintStream, times(0)).println(movieList.get(2));

    }

    @Test
    public void testIfIsPrintingTheUnavailableListMovie() {

        library.printFilteredMovieList(library.getMovieList(ProductStatus.UNAVAILABLE));

        verify(mockPrintStream).println(movieList.get(2));
        verify(mockPrintStream, times(0)).println(movieList.get(0));
        verify(mockPrintStream, times(0)).println(movieList.get(1));

    }

    @Test
    public void testIfReturnAnSpecificMovieFromListSelectedByCostumer() {

        Movie selectedMovie = movieList.get(0);

        assertThat(selectedMovie, equalTo(library.getAnSpecificMovieFromListSelectedByCostumer(1)));

    }


}
