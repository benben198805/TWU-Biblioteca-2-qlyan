package com.twu.biblioteca;

import com.twu.biblioteca.Model.MovieRecord;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieRecordTest {
    private MovieRecord movieRecord;
    @Before
    public void setUp() throws Exception {
        movieRecord=new MovieRecord(1,"movie1","2000","director1",1);
    }

    @Test
    public void shouldReturnTrueWhenCheckoutMovie() throws Exception {
        movieRecord.checkoutMovie();
        
        assertEquals(movieRecord.isCheckoutStatus(),true);
    }

    @Test
    public void shouldReturnFalseWhenCheckoutMovieThenReturnMovie() throws Exception {
        movieRecord.checkoutMovie();
        movieRecord.returnMovie();

        assertEquals(movieRecord.isCheckoutStatus(),false);
    }

    @Test
    public void shouldReturnRightFormatWhenShowMovie() throws Exception {
        assertEquals(movieRecord.showMovie(),"1\tmovie1\t2000\tdirector1\t1");
    }


    @Test
    public void shouldReturnOneWhenGivenRatingOne() throws Exception {
        String result=movieRecord.validateMovieRatingInput(1);

        assertEquals(result,"1");
    }


    @Test
    public void shouldReturnFiveWhenGivenRatingFive() throws Exception {
        String result=movieRecord.validateMovieRatingInput(5);

        assertEquals(result,"5");
    }

    @Test
    public void shouldReturnTenWheGivenRatingTen() throws Exception {
        String result=movieRecord.validateMovieRatingInput(10);

        assertEquals(result,"10");
    }

    @Test
    public void shouldReturnUnratedWhenGivenRatingOutOfOneToTen() throws Exception {
        String result=movieRecord.validateMovieRatingInput(0);

        assertEquals(result,"unrated");
    }

}