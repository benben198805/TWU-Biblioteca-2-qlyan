package com.twu.biblioteca;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.BookRecord;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void should_return_right_format_when_call_showBook() throws Exception {
        assertEquals(bookRecord.showBook(),"ISBN0001\tBook1\tAuthor1\t1991");
    }
}