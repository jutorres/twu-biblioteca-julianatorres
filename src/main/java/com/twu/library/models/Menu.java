package com.twu.library.models;

import com.twu.library.enums.ProductStatus;

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
                    "\n[4] List of movies" +
                    "\n[5] Checkout movie" +
                    "\n[9] Quit");

            menuItem = bufferedReader.readLine();

            if(menuItem == null) {
                menuItem = "-1";
            }

            switch (menuItem) {

                case "1":
                    library.printFilteredBookList(library.getBookList(ProductStatus.AVAILABLE));
                    break;

                case "2":
                    bookCheckoutOperation();
                    break;

                case "3":
                    bookReturnOperation();
                    break;

                case "4":
                    library.printFilteredMovieList(library.getMovieList(ProductStatus.AVAILABLE));
                    break;

                case "5":
                    movieCheckoutOperation();
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

        library.printFilteredBookList(library.getBookList(ProductStatus.AVAILABLE));

        int userOption = Integer.parseInt(bufferedReader.readLine());

        if(library.getAnSpecificBookFromListSelectedByCostumer(userOption).getProductStatus() == ProductStatus.UNAVAILABLE) {

            printStream.println("Sorry, that book is not available!\n");

        } else {

            library.getAnSpecificBookFromListSelectedByCostumer(userOption).setProductStatus(ProductStatus.UNAVAILABLE);

            printStream.println("Thank you! Enjoy the book!\n");

        }

    }

    public void movieCheckoutOperation() throws IOException {

        printStream.println("Please, select a movie to checkout: ");

        library.printFilteredMovieList(library.getMovieList(ProductStatus.AVAILABLE));

        int userOption = Integer.parseInt(bufferedReader.readLine());

        if(library.getAnSpecificMovieFromListSelectedByCostumer(userOption).getProductStatus() == ProductStatus.UNAVAILABLE) {

            printStream.println("Sorry, that movie is not available!\n");

        } else {

            library.getAnSpecificMovieFromListSelectedByCostumer(userOption).setProductStatus(ProductStatus.UNAVAILABLE);

            printStream.println("Thank you! Enjoy the movie!\n");

        }

    }

    private void bookReturnOperation() throws IOException {

        printStream.println("Please, select a book to return: ");

        library.printFilteredBookList(library.getBookList(ProductStatus.UNAVAILABLE));

        int userOption = Integer.parseInt(bufferedReader.readLine());

        if(library.getAnSpecificBookFromListSelectedByCostumer(userOption).getProductStatus() == ProductStatus.AVAILABLE) {

            printStream.println("That is not a valid book to return!\n");

        } else {

            library.getAnSpecificBookFromListSelectedByCostumer(userOption).setProductStatus(ProductStatus.AVAILABLE);

            printStream.println("Thank you for returning the book!\n");

        }

    }
}
