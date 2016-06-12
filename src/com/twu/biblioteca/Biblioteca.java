package com.twu.biblioteca;

import com.twu.biblioteca.Option.Option;

import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<BookRecord> bookRecords;
    private Scanner scanner=new Scanner(System.in);
    private ConsolePrinter consolePrinter;
    private List<Option> menu;
    private boolean stopSign;

    public Biblioteca(ConsolePrinter consolePrinter, List<Option> menu, List<BookRecord> bookRecords) {
        this.consolePrinter=consolePrinter;
        this.menu = menu;
        this.bookRecords = bookRecords;
        stopSign=false;
    }

    public void start(){
        showWelcomeWords();
        listBooks();
        listMenu();

        while (!stopSign){
            getUserMenuInput(scanner.nextLine());
        }
    }

    public void listTitle(){
        consolePrinter.print("isbn\tname\tauthor\tyear");
    }


    public void listBooks(){
        listTitle();
        for (BookRecord bookRecord:bookRecords) {
            consolePrinter.print(bookRecord.getBook().showBook());
        }
    }

    public void getUserMenuInput(String userInput) {
        if (!validateMenuId(Integer.parseInt(userInput))){
            showInvalidMessage();
            return;
        }
        for(Option option :menu){
            if(option.getId()==Integer.parseInt(userInput)){
                option.run(this);
                listMenu();
            }
        }
    }



    public void listMenu(){
        consolePrinter.print("Please select a menu id.");
        for(Option option :menu){
            consolePrinter.print(option.getOptionString());
        }
    }
    public boolean validateMenuId(int menuId){
        for(Option option :menu){
            if(option.getId()==menuId){
                return true;
            }
        }
        return false;
    }


    public void quit(){
        stopSign=true;
        showQuitWords();
    }


    public boolean validateIsbnInput(String userInput){
        for (BookRecord bookRecord:bookRecords) {
            if(bookRecord.getBook().getIsbn().equals(userInput)){
                return true;
            }
        }
        return false;
    }

    public String getUserIsbnInput(){
        consolePrinter.print("Please input isbn.");
        String userInput=scanner.nextLine();
        return userInput;
    }

    public void checkoutBook(){
        String userInput= getUserIsbnInput();
        if(!validateIsbnInput(userInput)){
            showInvalidMessage();
            return;
        }

        for (BookRecord bookRecord:bookRecords) {
            if(bookRecord.getBook().getIsbn().equals(userInput)&&!bookRecord.isCheckoutStatus()){
                bookRecord.setCheckoutStatus(true);
                showSuccessfulCheckout();
            }
            else
            {
                showUnsuccessfulCheckout();
            }
        }
    }

    public void returnBook(){
        String userInput= getUserIsbnInput();
        if(!validateIsbnInput(userInput)){
            showInvalidMessage();
            return;
        }


        for (BookRecord bookRecord:bookRecords) {
            if(bookRecord.getBook().getIsbn().equals(userInput)&&bookRecord.isCheckoutStatus()){
                bookRecord.setCheckoutStatus(false);
                showSuccessfulReturn();
            }
            else
            {
                showUnsuccessfulReturn();
            }
        }
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

    public void showInvalidMessage(){
        consolePrinter.print("Select a valid option!");
    }

    public boolean isStopSign() {
        return stopSign;
    }

    public void setStopSign(boolean stopSign) {
        this.stopSign = stopSign;
    }
}
