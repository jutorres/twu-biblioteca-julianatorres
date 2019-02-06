package com.twu.library;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    private Menu menu;
    @Mock
    private Library library;
    @Mock
    private PrintStream mockPrintStream;

    @Before
    public void setup() {
        menu = new Menu();
    }

    @Test
    public void testIfWhenUserSelectTheFirstMenuOptionTheBookListAppears() throws IOException {

        menu.showMenu(mockPrintStream, new BufferedReader(new StringReader("1")), library);

        verify(library).getBookList();
    }

    @Test
    public void testIfTheMessageInvalidOptinAppearesWhenUserPutUnInvalidMenuNumber() throws IOException {

        menu.showMenu(mockPrintStream, new BufferedReader(new StringReader("9")), library);

        verify(mockPrintStream).println("Please, select a valid option!");
    }

}
