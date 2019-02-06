package com.twu.library;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    private Menu menu;
    @Mock
    private Library mockLibrary;
    @Mock
    private PrintStream mockPrintStream;



    @Test
    public void testIfWhenUserSelectTheFirstMenuOptionTheBookListAppears() throws IOException {

        menu = new Menu(System.out, new BufferedReader(new StringReader("1\n0")) , mockLibrary);

        menu.showMenu();

        verify(mockLibrary).getBookList();

    }

    @Test
    public void testIfTheMessageInvalidOptinAppearesWhenUserPutUnInvalidMenuNumber() throws IOException {

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("10\n0")) , mockLibrary);

        menu.showMenu();

        verify(mockPrintStream).println("Please, select a valid option!");
    }

    @Test
    public void testIfICouldUseLibrarySystemUntilChooseTheOptionQuit() throws IOException {

        menu = new Menu(mockPrintStream, new BufferedReader(new StringReader("0")) , mockLibrary);

        menu.showMenu();

        verify(mockPrintStream).println("Goodbye, You quit the library system");
    }

}
