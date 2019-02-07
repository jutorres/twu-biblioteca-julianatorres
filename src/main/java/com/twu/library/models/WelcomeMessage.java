package com.twu.library.models;

import java.io.PrintStream;

public class WelcomeMessage {

    private PrintStream printStream;

    public WelcomeMessage(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printWelcomeMessage() {
        printStream.println("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!\n");
    }
}
