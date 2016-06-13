package com.twu.biblioteca;

import com.twu.biblioteca.Option.*;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        ConsolePrinter consolePrinter=new ConsolePrinter();

        Book book1=new Book("ISBN0001","Book1","Author1","1991");
        Book book2=new Book("ISBN0002","Book2","Author2","2000");

        List<BookRecord> bookRecords=new ArrayList<>();
        bookRecords.add(new BookRecord(book1));
        bookRecords.add(new BookRecord(book2));

        List<MovieRecord> movieRecords=new ArrayList<>();
        movieRecords.add(new MovieRecord(new Movie(1,"movie1","2000","director1",1)));
        movieRecords.add(new MovieRecord(new Movie(2,"movie2","2002","director2",2)));

        List<User> userList=new ArrayList<>();
        userList.add(new User("100-1000","password","jack","chengdu","12345678909",false));
        userList.add(new User("100-1001","password","ben","chengdu","09876543112",true));

        List<Option> menu=new ArrayList<>();
        menu.add(new ListBookOption(1,"ListBook"));
        menu.add(new CheckoutBookOption(2, "CheckoutBook"));
        menu.add(new ReturnBookOption(3, "ReturnBook"));
        menu.add(new ListMovieOption(4, "ListMovie"));
        menu.add(new CheckoutMovieOption(5, "CheckoutMovie"));
        menu.add(new ReturnMovieOption(6, "ReturnMovie"));
        menu.add(new QuitOption(7, "Quit"));
        menu.add(new ShowMyInfoOption(8, "ShowMyInfoOption"));
        menu.add(new ShowUserCheckoutInfo(9, "ShowUserCheckoutInfo"));

        Biblioteca biblioteca=new Biblioteca(consolePrinter,menu,bookRecords,movieRecords,userList);

        biblioteca.start();
    }
}
