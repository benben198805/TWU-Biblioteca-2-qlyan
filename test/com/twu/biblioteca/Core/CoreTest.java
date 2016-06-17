package com.twu.biblioteca.Core;

import com.twu.biblioteca.Model.BookRecord;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.option.*;
import com.twu.biblioteca.Model.MovieRecord;
import com.twu.biblioteca.Model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CoreTest {
    public Core core;
    public User userOne;
    public User userTwo;
    public Option listBookOption;
    public Option checkoutBookOption;

    @Before
    public void setUp() throws Exception {
        Map<String,Option> menu = new HashMap<>();

        listBookOption=new ListBookOption(1,"List");
        checkoutBookOption=new ListBookOption(2, "Checkout");
        menu.put("1",listBookOption);
        menu.put("2",checkoutBookOption);
        menu.put("3",new ShowMyInfoOption(3, "ShowMyInfo"));
        menu.put("4",new ShowUserCheckoutInfo(4, "ShowUserCheckoutInfo"));

        List<BookRecord> bookRecords=new ArrayList<>();
        bookRecords.add(new BookRecord(new Book("ISBN0001","Book1","Author1","1991")));
        bookRecords.add(new BookRecord(new Book("ISBN0002","Book2","Author2","2000")));

        List<MovieRecord> movieRecords=new ArrayList<>();
        movieRecords.add(new MovieRecord(1,"movie1","2000","director1",1));
        movieRecords.add(new MovieRecord(2,"movie2","2002","director2",2));


        List<User> userList = new ArrayList<>();
        userOne = new User("100-1000", "password", "jack", "chengdu", "12345678909", false);
        userTwo = new User("100-1001", "password", "ben", "chengdu", "09876543112", true);
        userList.add(userOne);
        userList.add(userTwo);

        core=new Core(bookRecords,movieRecords,userList,menu);
    }


    @Test
    public void shouldOutputMenuListWhenListMenuGivenNull() throws Exception {
        String result=core.listMenu(null);
        assertEquals(result,"1\tList\n2\tCheckout\n");
    }

    @Test
    public void shouldOutputMenuListWhenListMenuGivenCustomer() throws Exception {
        String result=core.listMenu(userOne);

        assertEquals(result,"1\tList\n2\tCheckout\n3\tShowMyInfo\n");
    }

    @Test
    public void shouldOutputMenuListWhenListMenuGivenLibrarian() throws Exception {
        String result=core.listMenu(userTwo);

        assertEquals(result,"1\tList\n2\tCheckout\n4\tShowUserCheckoutInfo\n");
    }


    @Test
    public void shouldReturnTrueWhenCallValidateMenuIdGivenOne() throws Exception {
        boolean result= core.validateMenuSelect("1");

        assertEquals(result,true);
    }


    @Test
    public void shouldReturnFalseWhenCallValidateMenuIdGivenNoExistMenuId() throws Exception {
        boolean result= core.validateMenuSelect("-1");

        assertEquals(result,false);
    }

    @Test
    public void shouldRunListBookWhenRunMenuOptionGivenOne() throws Exception {
        Option option = core.runMenuOption("2");

        assertEquals(option, checkoutBookOption);
    }


    @Test
    public void shouldOutputBookTitle() throws Exception {
        String result=core.listBookTitle();

        assertEquals(result,"isbn\tname\tauthor\tyear\n");
    }



    @Test
    public void shouldOutputBookListWhenCallListBookDetail() throws Exception {
        String result=core.listBookDetail();

        assertEquals(result,"ISBN0001\tBook1\tAuthor1\t1991\nISBN0002\tBook2\tAuthor2\t2000\n");
    }



    @Test
    public void shouldReturnTrueWhenCallValidateIsbnInputGivenISBN0001() throws Exception {
        boolean result= core.validateIsbnInput("ISBN0001");

        assertEquals(result,true);
    }

    @Test
    public void shouldReturnFalseWhenCallValidateIsbnInputGivenISBN0000() throws Exception {
        boolean result= core.validateIsbnInput("ISBN0000");

        assertEquals(result,false);
    }


    @Test
    public void shouldReturnFalseWhenCallValidateIsbnInputGivenAAAAAAA() throws Exception {
        boolean result= core.validateIsbnInput("AAAAAAA");

        assertEquals(result,false);
    }


    @Test
    public void shouldReturnFalseWhenCheckoutBookGivenISBN0001() throws Exception {
        boolean result= core.checkoutBook("ISBN0001");

        assertEquals(result,true);
    }


    @Test
    public void shouldReturnFalseWhenCheckoutBookGivenISBN0000() throws Exception {
        boolean result= core.checkoutBook("ISBN0000");

        assertEquals(result,false);
    }


    @Test
    public void shouldReturnFalseWhenCheckoutBookGivenISBN0001Again() throws Exception {
        core.checkoutBook("ISBN0001");
        boolean resultSecond= core.checkoutBook("ISBN0001");

        assertEquals(resultSecond,false);
    }




    @Test
    public void shouldReturnFalseWhenReturnBookGivenISBN0001() throws Exception {
        boolean result= core.returnBook("ISBN0001");

        assertEquals(result,false);
    }


    @Test
    public void shouldReturnFalseWhenReturnBookGivenISBN0001BeforCheckoutISBN0001() throws Exception {
        core.checkoutBook("ISBN0001");
        boolean resultSecord= core.returnBook("ISBN0001");

        assertEquals(resultSecord,true);
    }



    @Test
    public void shouldReturnTrueWhenValidateUserIdInputGivenRightFormat(){
        String rightId="111-1111";

        assertEquals(core.validateUserIdInput(rightId),true);
    }

    @Test
    public void shouldReturnFalseWhenValidateUserIdInputGivenWrongFormat(){
        String wrongId="111-11111";

        assertEquals(core.validateUserIdInput(wrongId),false);
    }



    @Test
    public void shouldReturnUserWhenCheckoutUserGivenExistUser() throws Exception {
        User user= core.checkoutUser("100-1000","password");

        assertEquals(user,userOne);
    }


    @Test
    public void shouldReturnNullWhenCheckoutUserGievnWrongPassword() throws Exception {
        User user= core.checkoutUser("100-1000","password123");

        assertEquals(user,null);
    }


    @Test
    public void shouldReturnNullWhenCheckoutUserGievnWrongUserId() throws Exception {
        User user= core.checkoutUser("100-1000123","password");

        assertEquals(user,null);
    }




    @Test
    public void shouldOutputMovieTitle() throws Exception {
        String result=core.listMovieTitle();

        assertEquals(result,"id\tname\tyear\tdirector\tmovieRating");
    }

    @Test
    public void shouldOutputMovieListWhenCallListMovieDetail() throws Exception {
        String result=core.listMovieDetail();

        assertEquals(result,"1\tmovie1\t2000\tdirector1\t1\n2\tmovie2\t2002\tdirector2\t2\n");
    }

    @Test
    public void shouldOutputMovieListWhenCallListMovieDetailWithCheckoutOne() throws Exception {
        core.checkoutMovie(1);
        String result=core.listMovieDetail();

        assertEquals(result,"2\tmovie2\t2002\tdirector2\t2\n");
    }



    @Test
    public void shouldReturnTrueWhenCallValidateMovieIdInputGivenOne() throws Exception {
        boolean result= core.validateMovieIdInput(1);

        assertEquals(result,true);
    }

    @Test
    public void shouldReturnFalseWhenCallValidateMovieIdInputGivenZero() throws Exception {
        boolean result= core.validateMovieIdInput(0);

        assertEquals(result,false);
    }


    @Test
    public void shouldReturnFalseWhenCheckoutMovieGivenOne() throws Exception {
        boolean result= core.checkoutMovie(1);

        assertEquals(result,true);
    }


    @Test
    public void shouldReturnFalseWhenCheckoutMovieGivenZero() throws Exception {
        boolean result= core.checkoutMovie(0);

        assertEquals(result,false);
    }


    @Test
    public void shouldReturnFalseWhenCheckoutMovieGivenOneAgain() throws Exception {
        core.checkoutMovie(1);
        boolean resultSecond= core.checkoutMovie(1);

        assertEquals(resultSecond,false);
    }




    @Test
    public void shouldReturnFalseWhenReturnMovieGivenOne() throws Exception {
        boolean result= core.returnMovie(1);

        assertEquals(result,false);
    }


    @Test
    public void shouldReturnFalseWhenReturnMovieGivenOneBeforeCheckoutOne() throws Exception {
        core.checkoutMovie(1);
        boolean resultSecord= core.returnMovie(1);

        assertEquals(resultSecord,true);
    }


    @Test
    public void shouldReturnEmptyWhenShowCheckoutList() throws Exception {
        String result= core.showCheckoutList();

        assertEquals(result,"User Name:jack\n" +
                "Book:\n" +
                "Movie:\n" +
                "User Name:ben\n" +
                "Book:\n" +
                "Movie:\n");
    }



}