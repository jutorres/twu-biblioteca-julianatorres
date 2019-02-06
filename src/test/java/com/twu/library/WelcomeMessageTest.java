package com.twu.library;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WelcomeMessageTest {

    @Mock
    private PrintStream mockPrintStream;
    private WelcomeMessage welcomeMessage;

    @Before
    public void setup() {
        welcomeMessage = new WelcomeMessage(mockPrintStream);
    }

    @Test
    public void testIfTheWelcomeMessageIsCorrect() {

        welcomeMessage.printWelcomeMessage();

        verify(mockPrintStream).println("Welcome to Biblioteca! Your one-stop-shop for great book titles in Bangalore!");

    }
}
