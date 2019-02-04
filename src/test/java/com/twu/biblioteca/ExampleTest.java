package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExampleTest {

    private Biblioteca biblioteca;

    @Before
    public void setup() {
        biblioteca = new Biblioteca();
    }

    @Test
    public void testIfTheWelcomeMessageIsCorrect() {

        String expected = biblioteca.welcomeMessage();

        assertThat("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!", is(expected));
    }

    @Test
    public void testIfTheBookListIsShowing() {

        List<String> actual = Arrays.asList("Dom Casmurro", "Senhora", "Memorias Postumas de Bras Cubas");
        List<String> expected = biblioteca.getBookList();

        assertThat(actual, is(expected));
    }

}
