package com.twu.biblioteca;

import com.twu.biblioteca.Option.Option;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by ben on 16-6-12.
 */
public class BibliotecaTest {

    public Biblioteca biblioteca;
    public ConsolePrinter consolePrinter;
    public List<Option> options;
    public BookRecord bookRecord;
    public BookList bookList;

    @Before
    public void setUp() throws Exception {
        consolePrinter=mock(ConsolePrinter.class);
        options=new ArrayList<>();
        bookRecord=new BookRecord(new Book("ISBN0001","Book1","Author1","1991"));
        List<BookRecord> bookRecords=new ArrayList<>();
        bookList=new BookList(bookRecords);
        biblioteca=new Biblioteca(consolePrinter,options, bookList);
    }

    @Test
    public void showWelcomeWords() throws Exception {
        biblioteca.showWelcomeWords();

        verify(consolePrinter).print("welcome to biblioteca");
    }

    @Test
    public void showQuitWords() throws Exception {
        biblioteca.showQuitWords();

        verify(consolePrinter).print("good bye");
    }
    @Test
    public void showSuccessfulCheckout() throws Exception {
        biblioteca.showSuccessfulCheckout();

        verify(consolePrinter).print("Thank you! Enjoy the book");

    }

    @Test
    public void showUnsuccessfulCheckout() throws Exception {
        biblioteca.showUnsuccessfulCheckout();

        verify(consolePrinter).print("That book is not available");

    }

    @Test
    public void showSuccessfulReturn() throws Exception {
        biblioteca.showSuccessfulReturn();

        verify(consolePrinter).print("Thank you for returning the book");

    }

    @Test
    public void showUnsuccessfulReturn() throws Exception {
        biblioteca.showUnsuccessfulReturn();

        verify(consolePrinter).print("That is not a valid book to return");

    }

}