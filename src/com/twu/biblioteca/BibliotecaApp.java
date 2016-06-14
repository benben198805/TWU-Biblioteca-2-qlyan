package com.twu.biblioteca;

import com.twu.biblioteca.Controller.BibliotecaController;
import com.twu.biblioteca.Controller.ConsolePrinter;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.BookRecord;
import com.twu.biblioteca.Model.MovieRecord;
import com.twu.biblioteca.Model.Option.*;
import com.twu.biblioteca.Model.User;

import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        ConsolePrinter consolePrinter=new ConsolePrinter();
        Scanner scanner=new Scanner(System.in);

        List<BookRecord> bookRecords=new ArrayList<>();
        bookRecords.add(new BookRecord(new Book("ISBN0001","Book1","Author1","1991")));
        bookRecords.add(new BookRecord(new Book("ISBN0002","Book2","Author2","2000")));

        List<MovieRecord> movieRecords=new ArrayList<>();
        movieRecords.add(new MovieRecord(1,"movie1","2000","director1",1));
        movieRecords.add(new MovieRecord(2,"movie2","2002","director2",2));

        List<User> userList=new ArrayList<>();
        userList.add(new User("100-1000","password","jack","chengdu","12345678909",false));
        userList.add(new User("100-1001","password","ben","chengdu","09876543112",true));


        Map<String,Option> menu=new HashMap<String,Option>();
        menu.put("1",new ListBookOption(1,"ListBook"));
        menu.put("2",new CheckoutBookOption(2, "CheckoutBook"));
        menu.put("3",new ReturnBookOption(3, "ReturnBook"));
        menu.put("4",new ListMovieOption(4, "ListMovie"));
        menu.put("5",new CheckoutMovieOption(5, "CheckoutMovie"));
        menu.put("6",new ReturnMovieOption(6, "ReturnMovie"));
        menu.put("7",new QuitOption(7, "Quit"));
        menu.put("8",new ShowMyInfoOption(8, "ShowMyInfo"));
        menu.put("9",new ShowUserCheckoutInfo(9, "ShowUserCheckoutInfo"));



        BibliotecaController bibliotecaController =new BibliotecaController(consolePrinter,scanner,menu,bookRecords,movieRecords,userList);

        bibliotecaController.start();
    }
}
