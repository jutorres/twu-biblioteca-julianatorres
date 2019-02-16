package com.twu.library.modelsTest;

import com.twu.library.enums.ProductStatus;
import com.twu.library.models.Movie;
import com.twu.library.models.Product;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MovieTest {

    @Test
    public void testIfToStringFromBookClassIsWorking() {

        Product testMovie = new Movie("Schindler's List", 1993, "Steven Spielberg", "10", ProductStatus.AVAILABLE);

        String result = testMovie.toString();

        assertThat(result, equalTo("Schindler's List, 1993, Steven Spielberg, 10"));

    }

}
