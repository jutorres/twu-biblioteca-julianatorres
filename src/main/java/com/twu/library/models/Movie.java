package com.twu.library.models;


import com.twu.library.enums.ProductStatus;

public class Movie extends Product{

    private String director;
    private String movieRating;

    public Movie(String title, int year, String director, String movieRating, ProductStatus productStatus) {
        super.title = title;
        super.year = year;
        this.director = director;
        this.movieRating = movieRating;
        super.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return  title + ", " + year + ", " + director + ", " + movieRating;
    }
}
