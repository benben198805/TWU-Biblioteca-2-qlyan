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

        List<Option> menu=new ArrayList<>();
        menu.add(new ListBookOption(1,"List"));
        menu.add(new CheckoutBookOption(2, "Checkout"));
        menu.add(new ReturnBookOption(3, "Return"));
        menu.add(new QuitOption(4, "Quit"));

        Biblioteca biblioteca=new Biblioteca(consolePrinter,menu,bookRecords);

        biblioteca.start();
    }
}
