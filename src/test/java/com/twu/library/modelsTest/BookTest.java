package com.twu.library.modelsTest;

import com.twu.library.enums.ProductStatus;
import com.twu.library.models.Book;
import com.twu.library.models.Product;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class BookTest {

    @Test
    public void testIfToStringFromBookClassIsWorking() {

        Product testBook = new Book("The Unbearable Lightness of Being", "Milan Kundera", 1984, ProductStatus.AVAILABLE);

        String result = testBook.toString();

        assertThat(result, equalTo("The Unbearable Lightness of Being, Milan Kundera, 1984"));

    }
}
