package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MovieTest {
    public Movie movie;

    @Before
    public void setUp() throws Exception {
        movie=new Movie(1,"movie1","2000","director1",1);
    }

    @Test
    public void should_return_1_when_given_rating_1() throws Exception {
        String result=movie.validateMovieRatingInput(1);

        assertEquals(result,"1");
    }


    @Test
    public void should_return_5_when_given_rating_5() throws Exception {
        String result=movie.validateMovieRatingInput(5);

        assertEquals(result,"5");
    }

    @Test
    public void should_return_10_when_given_rating_10() throws Exception {
        String result=movie.validateMovieRatingInput(10);

        assertEquals(result,"10");
    }

    @Test
    public void should_return_unrated_when_given_rating_out_of_1_10() throws Exception {
        String result=movie.validateMovieRatingInput(0);

        assertEquals(result,"unrated");
    }
}