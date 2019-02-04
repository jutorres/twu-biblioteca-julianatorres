package com.twu.library;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryAppTest {

    private Library library;

    @Before
    public void setup() {
        library = new Library();
    }

    @Test
    public void testIfTheWelcomeMessageIsCorrect() {

        String expected = library.welcomeMessage();

        assertThat("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!", is(expected));
    }

    @Test
    public void testIfTheBookListIsShowing() {

        List<String> actual = Arrays.asList("Dom Casmurro", "Senhora", "Memorias Postumas de Bras Cubas");
        List<String> expected = library.getBookList();

        assertThat(actual, is(expected));
    }


}
