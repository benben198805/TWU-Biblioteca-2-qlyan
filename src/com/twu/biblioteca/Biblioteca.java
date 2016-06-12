package com.twu.biblioteca;

import com.twu.biblioteca.Option.Option;

import java.util.List;
import java.util.Scanner;

/**
 * Created by ben on 16-6-12.
 */
public class Biblioteca {
    private BookList bookList;
    private Scanner scanner=new Scanner(System.in);
    private ConsolePrinter consolePrinter;
    private List<Option> options;

    public Biblioteca(ConsolePrinter consolePrinter, List<Option> options, BookList bookList) {
        this.consolePrinter=consolePrinter;
        this.options = options;
        this.bookList = bookList;
    }

    public void showWelcomeWords(){
        consolePrinter.print("welcome to biblioteca");
    }

    public void showQuitWords(){
        consolePrinter.print("good bye");
    }

    public void showSuccessfulCheckout(){
        consolePrinter.print("Thank you! Enjoy the book");
    }

    public void showUnsuccessfulCheckout(){
        consolePrinter.print("That book is not available");
    }


    public void showSuccessfulReturn(){
        consolePrinter.print("Thank you for returning the book");
    }

    public void showUnsuccessfulReturn(){
        consolePrinter.print("That is not a valid book to return");
    }

}
