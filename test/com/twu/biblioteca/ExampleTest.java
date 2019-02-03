package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class ExampleTest {

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setup() {
        bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void test() {

        String actual = bibliotecaApp.welcomeMessage();

        assertThat();
    }
}
