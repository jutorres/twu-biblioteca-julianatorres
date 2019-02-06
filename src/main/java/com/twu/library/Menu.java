package com.twu.library;

import java.io.*;
import java.util.Scanner;

public class Menu {

    private final PrintStream printStream;
    private BufferedReader bufferedReader;
    private final Library library;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, Library library) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.library = library;
    }

    public Menu(Library library) {
        this(System.out, new BufferedReader(new InputStreamReader(System.in)), library);
    }

    public void showMenu() throws IOException {

        String menuItem;

        do {
            printStream.println("Please, select a menu option: " +
                    "\n[1] List of books" +
                    "\n[0] Quit");

            menuItem = bufferedReader.readLine();

            if(menuItem == null) {
                menuItem = "-1";
            }

            switch (menuItem) {

                case "1":
                    library.getBookList();
                    break;

                case "0":
                    printStream.println("Goodbye, You quit the library system");
                    break;

                default:
                    printStream.println("Please, select a valid option!");
            }
        } while(!menuItem.equals("0"));

    }
}
