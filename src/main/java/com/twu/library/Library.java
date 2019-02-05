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

    public void getBookList() {

        for (Book book: bookList) {
            printStream.println(book);
        }
    }

}