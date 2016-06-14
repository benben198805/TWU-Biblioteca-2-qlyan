package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.BookRecord;
import com.twu.biblioteca.Core.Core;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Option.*;
import com.twu.biblioteca.Model.MovieRecord;
import com.twu.biblioteca.Model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaControllerTest {
    public Core core;
    public BibliotecaController bibliotecaController;
    public ConsolePrinter consolePrinter;
    public List<Option> options;
    public List<BookRecord> bookRecords;
    public List<User> userList;
    public User userOne;
    public User userTwo;

    @Before
    public void setUp() throws Exception {
        consolePrinter=mock(ConsolePrinter.class);
        Scanner scanner=new Scanner(System.in);

        List<Option> menu=new ArrayList<>();
        menu.add(new ListBookOption(1,"List"));
        menu.add(new CheckoutBookOption(2, "Checkout"));
        menu.add(new ReturnBookOption(3, "Return"));
        menu.add(new QuitOption(4, "Quit"));

        List<BookRecord> bookRecords=new ArrayList<>();
        bookRecords.add(new BookRecord(new Book("ISBN0001","Book1","Author1","1991")));
        bookRecords.add(new BookRecord(new Book("ISBN0002","Book2","Author2","2000")));

        List<MovieRecord> movieRecords=new ArrayList<>();
        movieRecords.add(new MovieRecord(1,"movie1","2000","director1",1));
        movieRecords.add(new MovieRecord(2,"movie2","2002","director2",2));


        userOne=new User("100-1000","password","jack","chengdu","12345678909",false);
        userTwo=new User("100-1001","password","ben","chengdu","09876543112",true);
        userList=new ArrayList<>();
        userList.add(userOne);
        userList.add(userTwo);

        core=mock(Core.class);

        bibliotecaController =new BibliotecaController(consolePrinter,scanner,menu, bookRecords,movieRecords,userList);
    }



//    @Test
//    public void should_trigger_welcome_and_listMenu_once() throws Exception {
//        bibliotecaController.start();
//
//        InOrder inOrder= inOrder(core);
//        inOrder.verify(core).listMenu(null);
//    }


    @Test
    public void should_output_welcome_word() throws Exception {
        bibliotecaController.showWelcomeWords();
        verify(consolePrinter).print("welcome to biblioteca");
    }

    @Test
    public void should_output_quit_word() throws Exception {
        bibliotecaController.showQuitWords();
        verify(consolePrinter).print("good bye");
    }
    @Test
    public void should_output_successful_checkout() throws Exception {
        bibliotecaController.showSuccessfulCheckout();
        verify(consolePrinter).print("Thank you! Enjoy the book");
    }

    @Test
    public void should_output_unsuccessful_checkout() throws Exception {
        bibliotecaController.showUnsuccessfulCheckout();
        verify(consolePrinter).print("That book is not available");

    }

    @Test
    public void should_output_successful_return() throws Exception {
        bibliotecaController.showSuccessfulReturn();
        verify(consolePrinter).print("Thank you for returning the book");

    }

    @Test
    public void should_output_unsuccessful_return() throws Exception {
        bibliotecaController.showUnsuccessfulReturn();
        verify(consolePrinter).print("That is not a valid book to return");
    }


    @Test
    public void should_output_invalid_message() throws Exception {
        bibliotecaController.showInvalidMessage();
        verify(consolePrinter).print("Select a valid option!");

    }



    @Test
    public void should_set_stopSign_true_when_call_quit() throws Exception {
        bibliotecaController.quit();
        assertEquals(bibliotecaController.isStopSign(),true);
    }

    @Test
    public void should_set_stopSign_true_when_listBooks() throws Exception {
        bibliotecaController.listBooks();
        verify(consolePrinter).print("isbn\tname\tauthor\tyear\nISBN0001\tBook1\tAuthor1\t1991\n" +
                "ISBN0002\tBook2\tAuthor2\t2000\n");
    }



    @Test
    public void should_return_true_when_have_a_login_user() throws Exception {
        bibliotecaController.loginIn("100-1001","password");
        boolean result= bibliotecaController.isLogined();
        assertEquals(result,true);
    }


    @Test
    public void should_return_false_when_have_no_login_user() throws Exception {
        boolean result= bibliotecaController.isLogined();
        assertEquals(result,false);
    }


    @Test
    public void should_output_successful_checkout_movie() throws Exception {

        bibliotecaController.showSuccessfulCheckoutMovie();

        verify(consolePrinter).print("Thank you! Enjoy the movie");
    }

    @Test
    public void should_output_unsuccessful_checkout_movie() throws Exception {
        bibliotecaController.showUnsuccessfulCheckoutMovie();

        verify(consolePrinter).print("That movie is not available");

    }

    @Test
    public void should_output_successful_return_movie() throws Exception {
        bibliotecaController.showSuccessfulReturnMovie();

        verify(consolePrinter).print("Thank you for returning the movie");

    }

    @Test
    public void should_output_unsuccessful_return_movie() throws Exception {
        bibliotecaController.showUnsuccessfulReturnMovie();

        verify(consolePrinter).print("That is not a valid movie to return");
    }
}