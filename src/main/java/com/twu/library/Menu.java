package com.twu.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {


    public void showMenu(PrintStream printStream, BufferedReader bufferedReader, Library library) throws IOException {
        printStream.println("Please, select a menu option: " +
                "\n[1] List of books");

        String userOption = bufferedReader.readLine();

        switch (userOption) {

            case "1":
                library.getBookList();
                break;

            default:
                printStream.println("Please, select a valid option!");
        }

    }
}
