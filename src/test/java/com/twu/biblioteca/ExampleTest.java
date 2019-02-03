package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExampleTest {

    private Biblioteca biblioteca;

    @Before
    public void setup() {
        biblioteca = new Biblioteca();
    }

    @Test
    public void test() {

        String actual = biblioteca.welcomeMessage();

        assertThat("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!", is(actual));
    }
}
