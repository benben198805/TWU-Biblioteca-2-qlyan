package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    public Book book;

    @Before
    public void setUp() throws Exception {
        book=new Book("ISBN0001","Book1","Author1","1991");
    }

    @Test
    public void should_return_right_format_when_call_showBook() throws Exception {
        assertEquals(book.showBook(),"ISBN0001\tBook1\tAuthor1\t1991");
    }


}