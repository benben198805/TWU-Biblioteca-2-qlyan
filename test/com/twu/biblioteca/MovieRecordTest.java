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
    public void should_return_true_when_call_checkoutMovie() throws Exception {
        movieRecord.checkoutMovie();
        assertEquals(movieRecord.isCheckoutStatus(),true);
    }

    @Test
    public void should_return_false_when_call_checkoutMovie_then_returnMovie() throws Exception {
        movieRecord.checkoutMovie();
        movieRecord.returnMovie();
        assertEquals(movieRecord.isCheckoutStatus(),false);
    }

    @Test
    public void should_return_right_format_when_call_showMovie() throws Exception {
        assertEquals(movieRecord.showMovie(),"1\tmovie1\t2000\tdirector1\t1");
    }


    @Test
    public void should_return_1_when_given_rating_1() throws Exception {
        String result=movieRecord.validateMovieRatingInput(1);

        assertEquals(result,"1");
    }


    @Test
    public void should_return_5_when_given_rating_5() throws Exception {
        String result=movieRecord.validateMovieRatingInput(5);

        assertEquals(result,"5");
    }

    @Test
    public void should_return_10_when_given_rating_10() throws Exception {
        String result=movieRecord.validateMovieRatingInput(10);

        assertEquals(result,"10");
    }

    @Test
    public void should_return_unrated_when_given_rating_out_of_1_10() throws Exception {
        String result=movieRecord.validateMovieRatingInput(0);

        assertEquals(result,"unrated");
    }

}