package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ben on 16-6-12.
 */
public class BookRecordTest {
    private BookRecord bookRecord;
    @Before
    public void setUp() throws Exception {
        bookRecord=new BookRecord(new Book("ISBN0001","Book1","Author1","1991"));
    }

    @Test
    public void should_return_true_when_call_checkoutBook() throws Exception {
        bookRecord.checkoutBook();
        assertEquals(bookRecord.isCheckoutStatus(),true);
    }

    @Test
    public void should_return_false_when_call_checkoutBook_then_returnBook() throws Exception {
        bookRecord.checkoutBook();
        bookRecord.returnBook();
        assertEquals(bookRecord.isCheckoutStatus(),false);
    }

}