package com.twu.library;

import java.io.PrintStream;
import java.util.List;

public class Library {

    private List<Book> bookList;
    private PrintStream printStream;

    public Library(List<Book> bookList, PrintStream printStream) {
        this.bookList = bookList;
        this.printStream = printStream;
    }

    public void getAvailableBookList() {

        for (Book book: bookList) {
            if (book.getBookStatus() == BookStatus.AVAILABLE) {
                printStream.println(book);
            }
        }
    }

    public void getUnAvailableBookList() {

        for (Book book: bookList) {
            if (book.getBookStatus() == BookStatus.UNAVAILABLE) {
                printStream.println(book);
            }
        }
    }


    public Book getAnSpecificBookFromListSelectedByCostumer(int index) {
        return bookList.get(index - 1);
    }

}