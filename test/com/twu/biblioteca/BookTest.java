package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ben on 16-6-12.
 */
public class BookTest {
    public Book book;

    @Before
    public void setUp() throws Exception {
        book=new Book("ISBN0001","Book1","Author1","1991");

    }

    @Test
    public void showBook() throws Exception {
        assertEquals(book.showBook(),"ISBN0001\tBook1\tAuthor1\t1991");
    }

}