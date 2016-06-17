package com.twu.biblioteca;

import com.twu.biblioteca.Model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    public User user;
    public String bookIsbn;
    public Integer movieId;

    @Before
    public void setUp() throws Exception {
        user=new User("100-1000","password","Jack","Chengdu","12345678901",true);
        bookIsbn="sibn1000";
        movieId=1;

    }

    @Test
    public void shouldHaveRecordInUserBookCheckooutListWhenUserCheckoutBook() throws Exception {
        user.checkoutBook(bookIsbn);

        assertEquals(user.getBookCheckoutList().contains(bookIsbn),true);
    }

    @Test
    public void shouldReturnDelelteRecordWhenUserReturnBook() throws Exception {
        user.returnBook(bookIsbn);

        assertEquals(user.getBookCheckoutList().contains(bookIsbn),false);
    }


    @Test
    public void shouldHaveRecordInUserMovieCheckooutListWhenUserCheckoutMovie() throws Exception {
        user.checkoutMovie(movieId);

        assertEquals(user.getMovieCheckoutList().contains(movieId),true);
    }

    @Test
    public void shouldReturnDelRecordWhenUserReturnMovie() throws Exception {
        user.returnMovie(movieId);

        assertEquals(user.getMovieCheckoutList().contains(movieId),false);
    }

    @Test
    public void shouldReturnUserInfoWhenShowUserInfo() throws Exception {
        assertEquals(user.showInfo(),"100-1000\tJack\tChengdu\t12345678901");
    }

    @Test
    public void shouldReturnEmptyInfoWhenShowCheckoutBookAndMovieHaveNoBookAndMovie() throws Exception {
        String result=user.showCheckoutBookAndMovie();

        assertEquals(result,"User Name:Jack\nBook:\nMovie:\n");
    }


    @Test
    public void shouldReturnBookInfoWhenShowCheckoutBookAndMovieOnlyHaveBook() throws Exception {
        user.checkoutBook("123");
        String result=user.showCheckoutBookAndMovie();

        assertEquals(result,"User Name:Jack\nBook:\n123\nMovie:\n");
    }

    @Test
    public void shouldReturnMovieInfoWhenShowCheckoutBookAndMovieOnlyHaveMovie() throws Exception {
        user.checkoutMovie(123);
        String result=user.showCheckoutBookAndMovie();

        assertEquals(result,"User Name:Jack\nBook:\nMovie:\n123\n");
    }
}