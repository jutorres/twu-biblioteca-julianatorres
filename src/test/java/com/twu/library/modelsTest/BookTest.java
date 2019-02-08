package com.twu.library.modelsTest;

import com.twu.library.enums.BookStatus;
import com.twu.library.models.Book;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class BookTest {

    @Test
    public void testIfToStringFromBookClassIsWorking() {

        Book testBook = new Book("The Unbearable Lightness of Being", "Milan Kundera", 1984, BookStatus.AVAILABLE);

        String result = testBook.toString();

        assertThat(result, equalTo("The Unbearable Lightness of Being, Milan Kundera, 1984"));

    }
}
