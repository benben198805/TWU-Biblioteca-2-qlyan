package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieRecordTest {
    private MovieRecord MovieRecord;
    @Before
    public void setUp() throws Exception {
        MovieRecord=new MovieRecord(new Movie(1,"movie1","2000","director1",1));
    }

    @Test
    public void should_return_true_when_call_checkoutMovie() throws Exception {
        MovieRecord.checkoutMovie();
        assertEquals(MovieRecord.isCheckoutStatus(),true);
    }

    @Test
    public void should_return_false_when_call_checkoutMovie_then_returnMovie() throws Exception {
        MovieRecord.checkoutMovie();
        MovieRecord.returnMovie();
        assertEquals(MovieRecord.isCheckoutStatus(),false);
    }

}