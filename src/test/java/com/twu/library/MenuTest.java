package com.twu.library;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MenuTest {

    @Mock
    private Library library;
    @Mock
    private Menu menu;

    @Before
    public void setup() {
        menu = new Menu();
    }

    @Test
    public void testIfWhenUserSelectTheFirstMenuOptionTheBookListAppears() throws IOException {

        library = mock(Library.class);

        menu.showMenu(System.out, new BufferedReader(new StringReader("1")), library);

        verify(library).getBookList();
    }
}
