package com.twu.library.models;

import com.twu.library.enums.BookStatus;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> bookList;
    private PrintStream printStream;

    public Library(List<Book> bookList, PrintStream printStream) {
        this.bookList = bookList;
        this.printStream = printStream;
    }

    public List<Book> getBookList(BookStatus bookStatus) {

        List<Book> filteredBookList = new ArrayList<>();

        for (Book book: bookList) {
            if (book.getBookStatus() == bookStatus) {
                filteredBookList.add(book);
            }
        }
        return filteredBookList;
    }

    public void printFilteredBookList(List<Book> bookListSelected) {

        for(Book book : bookListSelected) {
            printStream.println(book);
        }

    }

    public Book getAnSpecificBookFromListSelectedByCostumer(int index) {
        return bookList.get(index - 1);
    }

}