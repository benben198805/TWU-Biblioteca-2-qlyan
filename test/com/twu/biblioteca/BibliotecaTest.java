package com.twu.biblioteca;

import com.twu.biblioteca.Option.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BibliotecaTest {

    public Biblioteca biblioteca;
    public ConsolePrinter consolePrinter;
    public List<Option> options;
    public List<BookRecord> bookRecords;
    public List<User> userList;
    public User userOne;
    public User userTwo;

    @Before
    public void setUp() throws Exception {
        consolePrinter=mock(ConsolePrinter.class);

        List<Option> menu=new ArrayList<>();
        menu.add(new ListBookOption(1,"List"));
        menu.add(new CheckoutBookOption(2, "Checkout"));
        menu.add(new ReturnBookOption(3, "Return"));
        menu.add(new QuitOption(4, "Quit"));

        List<BookRecord> bookRecords=new ArrayList<>();
        bookRecords.add(new BookRecord(new Book("ISBN0001","Book1","Author1","1991")));
        bookRecords.add(new BookRecord(new Book("ISBN0002","Book2","Author2","2000")));


        Movie movie1=new Movie(1,"movie1","2000","director1",1);
        Movie movie2=new Movie(2,"movie2","2002","director2",2);

        List<MovieRecord> movieRecords=new ArrayList<>();
        movieRecords.add(new MovieRecord(movie1));
        movieRecords.add(new MovieRecord(movie2));


        userOne=new User("100-1000","password","jack","chengdu","12345678909",false);
        userTwo=new User("100-1001","password","ben","chengdu","09876543112",true);
        userList=new ArrayList<>();
        userList.add(userOne);
        userList.add(userTwo);

        biblioteca=new Biblioteca(consolePrinter,menu, bookRecords,movieRecords,userList);
    }

    @Test
    public void should_output_welcome_word() throws Exception {
        biblioteca.showWelcomeWords();

        verify(consolePrinter).print("welcome to biblioteca");
    }

    @Test
    public void should_output_quit_word() throws Exception {
        biblioteca.showQuitWords();

        verify(consolePrinter).print("good bye");
    }
    @Test
    public void should_output_successful_checkout() throws Exception {

        biblioteca.showSuccessfulCheckout();

        verify(consolePrinter).print("Thank you! Enjoy the book");
    }

    @Test
    public void should_output_unsuccessful_checkout() throws Exception {
        biblioteca.showUnsuccessfulCheckout();

        verify(consolePrinter).print("That book is not available");

    }

    @Test
    public void should_output_successful_return() throws Exception {
        biblioteca.showSuccessfulReturn();

        verify(consolePrinter).print("Thank you for returning the book");

    }

    @Test
    public void should_output_unsuccessful_return() throws Exception {
        biblioteca.showUnsuccessfulReturn();

        verify(consolePrinter).print("That is not a valid book to return");
    }


    @Test
    public void should_output_invalid_message() throws Exception {
        biblioteca.showInvalidMessage();

        verify(consolePrinter).print("Select a valid option!");

    }


    @Test
    public void should_output_book_title() throws Exception {
        biblioteca.listTitle();

        verify(consolePrinter).print("isbn\tname\tauthor\tyear");

    }

    @Test
    public void should_set_stopSign_true_when_call_quit() throws Exception {
        biblioteca.quit();

        assertEquals(biblioteca.isStopSign(),true);
    }

    @Test
    public void should_return_true_when_call_validateIsbnInput_given_ISBN0001() throws Exception {
        boolean result=biblioteca.validateIsbnInput("ISBN0001");
        assertEquals(result,true);
    }

    @Test
    public void should_return_false_when_call_validateIsbnInput_given_ISBN0000() throws Exception {
        boolean result=biblioteca.validateIsbnInput("ISBN0000");
        assertEquals(result,false);
    }


    @Test
    public void should_return_false_when_call_validateIsbnInput_given_AAAAAAA() throws Exception {
        boolean result=biblioteca.validateIsbnInput("AAAAAAA");
        assertEquals(result,false);
    }


    @Test
    public void should_return_true_when_call_validateMenuId_given_1() throws Exception {
        boolean result=biblioteca.validateMenuId(1);
        assertEquals(result,true);
    }


    @Test
    public void should_return_false_when_call_validateMenuId_given_9() throws Exception {
        boolean result=biblioteca.validateMenuId(9);
        assertEquals(result,false);

    }


    @Test
    public void should_return_false_when_call_validateMenuId_given_negtive() throws Exception {
        boolean result=biblioteca.validateMenuId(-1);
        assertEquals(result,false);
    }


    @Test
    public void should_output_book_list_when_call_listbook() throws Exception {
        biblioteca.listBooks();

        verify(consolePrinter,times(1)).print("isbn\tname\tauthor\tyear");
        verify(consolePrinter,times(1)).print("ISBN0001\tBook1\tAuthor1\t1991");
        verify(consolePrinter,times(1)).print("ISBN0002\tBook2\tAuthor2\t2000");
    }


    @Test
    public void should_output_menu_list_when_call_listmenu() throws Exception {
        biblioteca.listMenu();

        verify(consolePrinter,times(1)).print("1\tList");
        verify(consolePrinter,times(1)).print("2\tCheckout");
        verify(consolePrinter,times(1)).print("3\tReturn");
        verify(consolePrinter,times(1)).print("4\tQuit");
    }


    @Test
    public void should_return_true_when_given_right_format(){
        String rightId="111-1111";
        assertEquals(biblioteca.validateUserIdInput(rightId),true);
    }


    @Test
    public void should_return_false_when_given_wrong_format(){
        String wrongId="111-11111";
        assertEquals(biblioteca.validateUserIdInput(wrongId),false);
    }

    @Test
    public void should_return_hello_word_when_user_login_in(){
        biblioteca.loginIn("100-1001","password");

        verify(consolePrinter,times(1)).print("welcome ben");
        assertEquals(biblioteca.getLoginUser().getId(),"100-1001");
    }

    @Test
    public void should_return_alert_word_when_user_login_in_with_wrong_format_input(){
        biblioteca.loginIn("100-1001ww","password");

        verify(consolePrinter,times(1)).print("wrong input");
    }


    @Test
    public void should_return_wrong_word_when_user_login_in_with_invalid_id(){
        biblioteca.loginIn("100-1003","password");

        verify(consolePrinter,times(1)).print("wrong id or password");
    }


    @Test
    public void should_return_wrong_word_when_user_login_in_with_invalid_password(){
        biblioteca.loginIn("100-1001","password123");

        verify(consolePrinter,times(1)).print("wrong id or password");
    }

    @Test
    public void should_return_true_when_have_a_login_user() throws Exception {
        biblioteca.loginIn("100-1001","password");
        boolean result=biblioteca.isLogined();
        assertEquals(result,true);

    }


    @Test
    public void should_return_false_when_have_no_login_user() throws Exception {
        boolean result=biblioteca.isLogined();
        assertEquals(result,false);

    }

    @Test
    public void should_output_movie_title() throws Exception {
        biblioteca.listMovieTitle();

        verify(consolePrinter).print("id\tname\tyear\tdirector\tmovieRating");

    }

    @Test
    public void should_output_movie_list_when_call_listmovie() throws Exception {
        biblioteca.listMovies();

        verify(consolePrinter,times(1)).print("id\tname\tyear\tdirector\tmovieRating");
        verify(consolePrinter,times(1)).print("1\tmovie1\t2000\tdirector1\t1");
        verify(consolePrinter,times(1)).print("2\tmovie2\t2002\tdirector2\t2");
    }


    @Test
    public void should_output_successful_checkout_movie() throws Exception {

        biblioteca.showSuccessfulCheckoutMovie();

        verify(consolePrinter).print("Thank you! Enjoy the movie");
    }

    @Test
    public void should_output_unsuccessful_checkout_movie() throws Exception {
        biblioteca.showUnsuccessfulCheckoutMovie();

        verify(consolePrinter).print("That movie is not available");

    }

    @Test
    public void should_output_successful_return_movie() throws Exception {
        biblioteca.showSuccessfulReturnMovie();

        verify(consolePrinter).print("Thank you for returning the movie");

    }

    @Test
    public void should_output_unsuccessful_return_movie() throws Exception {
        biblioteca.showUnsuccessfulReturnMovie();

        verify(consolePrinter).print("That is not a valid movie to return");
    }


}