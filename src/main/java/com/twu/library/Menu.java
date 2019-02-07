package com.twu.library;

import java.io.*;

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
                    "\n[2] Checkout book" +
                    "\n[3] Return a book" +
                    "\n[9] Quit");

            menuItem = bufferedReader.readLine();

            if(menuItem == null) {
                menuItem = "-1";
            }

            switch (menuItem) {

                case "1":
                    library.getAvailableBookList();
                    break;

                case "2":
                    bookCheckoutOperation();
                    break;

                case "3":
                    bookReturnOperation();
                    break;

                case "9":
                    printStream.println("Goodbye, You quit the library system");
                    break;

                default:
                    printStream.println("Please, select a valid option!\n");
            }
        } while(!menuItem.equals("9"));

    }

    public void bookCheckoutOperation() throws IOException {

        printStream.println("Please, select a book to checkout: ");

        library.getAvailableBookList();

        int userOption = Integer.parseInt(bufferedReader.readLine());

        if(library.getAnSpecificBookFromListSelectedByCostumer(userOption).getBookStatus() == BookStatus.UNAVAILABLE) {

            printStream.println("Sorry, that book is not available!\n");

        } else {

            library.getAnSpecificBookFromListSelectedByCostumer(userOption).setBookStatus(BookStatus.UNAVAILABLE);

            printStream.println("Thank you! Enjoy the book!\n");

        }

    }

    private void bookReturnOperation() throws IOException {

        printStream.println("Please, select a book to return: ");

        library.getUnAvailableBookList();

        int userOption = Integer.parseInt(bufferedReader.readLine());

        if(library.getAnSpecificBookFromListSelectedByCostumer(userOption).getBookStatus() == BookStatus.AVAILABLE) {

            printStream.println("That is not a valid book to return!\n");

        } else {

            library.getAnSpecificBookFromListSelectedByCostumer(userOption).setBookStatus(BookStatus.AVAILABLE);

            printStream.println("Thank you for returning the book!\n");

        }

    }
}
