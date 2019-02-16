package com.twu.library.models;

import com.twu.library.enums.ProductStatus;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> bookList;
    private List<Movie> movieList;
    private PrintStream printStream;

    public Library(List<Book> bookList, List<Movie> movieList, PrintStream printStream) {
        this.bookList = bookList;
        this.movieList = movieList;
        this.printStream = printStream;
    }

    public List<Book> getBookList(ProductStatus productStatus) {

        List<Book> filteredBookList = new ArrayList<>();

        for (Book book: bookList) {
            if (book.getProductStatus() == productStatus) {
                filteredBookList.add(book);
            }
        }
        return filteredBookList;
    }

    public List<Movie> getMovieList(ProductStatus productStatus) {

        List<Movie> filteredMovieList = new ArrayList<>();

        for (Movie movie: movieList) {
            if (movie.getProductStatus() == productStatus) {
                filteredMovieList.add(movie);
            }
        }
        return filteredMovieList;
    }


    public void printFilteredBookList(List<Book> bookListSelected) {

        for(Book book : bookListSelected) {
            printStream.println(book);
        }

    }

    public void printFilteredMovieList(List<Movie> movieListSelected) {

        for(Movie movie : movieListSelected) {
            printStream.println(movie);
        }

    }

    public Book getAnSpecificBookFromListSelectedByCostumer(int index) {
        return bookList.get(index - 1);
    }

    public Movie getAnSpecificMovieFromListSelectedByCostumer(int index) {
        return movieList.get(index - 1);
    }

}