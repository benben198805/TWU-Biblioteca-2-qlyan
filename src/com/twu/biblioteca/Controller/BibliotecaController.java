package com.twu.biblioteca.Controller;

import com.twu.biblioteca.Model.BookRecord;
import com.twu.biblioteca.Core.Core;
import com.twu.biblioteca.Model.MovieRecord;
import com.twu.biblioteca.Model.Option.Option;
import com.twu.biblioteca.Model.User;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BibliotecaController {
    private Scanner scanner;
    private ConsolePrinter consolePrinter;
    private User loginUser;
    private boolean stopSign;
    private Core core;

    public BibliotecaController(ConsolePrinter consolePrinter, Scanner scanner, Map<String,Option> menu, List<BookRecord> bookRecords, List<MovieRecord> movieRecoeds, List<User> userList) {
        this.consolePrinter=consolePrinter;
        this.scanner=scanner;

        this.stopSign=false;
        this.loginUser=null;
        this.core=new Core(bookRecords,movieRecoeds,userList,menu);
    }

    public void start(){
        showWelcomeWords();
        listMenu();

        while (!stopSign){
            getUserMenuInput(scanner.nextLine());
        }
    }


    public void listMenu(){
        consolePrinter.print("Please select a menu id.");
        consolePrinter.print(core.listMenu(loginUser));
    }


    public void getUserMenuInput(String userInput) {
        if (!core.validateMenuSelect(userInput)){
            showInvalidMessage();
            listMenu();
        }else {
            Option nowOption=core.runMenuOption(userInput);
            nowOption.run(this);
            listMenu();
        }
    }

    public void quit(){
        stopSign=true;
        showQuitWords();
    }

    public void listBooks(){
        consolePrinter.print(core.listbooks());
    }


    public String getUserIsbnInput(){
        consolePrinter.print("Please input isbn.");
        String userInput=scanner.nextLine();
        return userInput;
    }


    public void checkoutBook(){
        if(isLogined()){
            String userInput= getUserIsbnInput();
            if(!core.validateIsbnInput(userInput)){
                showInvalidMessage();
            }
            else{
                core.checkoutBook(userInput);
            }
        }
        else{
            login();
        }
    }

    public void returnBook(){
        if(isLogined()){
            String userInput= getUserIsbnInput();
            if(!core.validateIsbnInput(userInput)){
                showInvalidMessage();
            }
            else{
                core.returnBook(userInput);
            }
        }
        else{
            login();
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


    public boolean isLogined(){
        return loginUser!=null?true:false;
    }

    public void login(){
        consolePrinter.print("please input id");
        String id=scanner.nextLine();

        consolePrinter.print("please input password");
        String password=scanner.nextLine();

        loginIn(id,password);
    }

    public void loginIn(String id, String password) {
        if(core.validateUserIdInput(id)){
            User user=core.checkoutUser(id,password);
            if(user==null){
                consolePrinter.print("wrong id or password");
            }
            else{
                loginUser=user;
                consolePrinter.print("welcome "+user.getName());
            }
        }else{
            consolePrinter.print("wrong input");
        }
    }

    public void listMovies() {
        core.listMovieTitle();
        consolePrinter.print(core.listMovieDetail());
    }


    public void showSuccessfulCheckoutMovie(){
        consolePrinter.print("Thank you! Enjoy the movie");
    }

    public void showUnsuccessfulCheckoutMovie(){
        consolePrinter.print("That movie is not available");
    }

    public void showSuccessfulReturnMovie(){
        consolePrinter.print("Thank you for returning the movie");
    }

    public void showUnsuccessfulReturnMovie(){
        consolePrinter.print("That is not a valid movie to return");
    }


    public String getUserMovieIdInput(){
        consolePrinter.print("Please input movie id.");
        String userInput=scanner.nextLine();
        return userInput;
    }

    public void checkoutMovie(){
        if(isLogined()){
            Integer userInput= Integer.parseInt(getUserMovieIdInput());
            if(!core.validateMovieIdInput(userInput)){
                showInvalidMessage();
            }
            else{
                if(core.checkoutMovie(userInput))
                {
                    showSuccessfulCheckoutMovie();
                }else{
                    showUnsuccessfulCheckoutMovie();
                }
            }
        }
        else{
            login();
        }
    }

    public void returnMovie(){
        if(isLogined()){
            Integer userInput= Integer.parseInt(getUserMovieIdInput());
            if(!core.validateMovieIdInput(userInput)){
                showInvalidMessage();
            }
            else{
                if(core.returnMovie(userInput)){
                    showSuccessfulReturnMovie();
                }
                else{
                    showUnsuccessfulReturnMovie();
                }
            }
        }
        else{
            login();
        }
    }

    public void showMyInfo() {
        consolePrinter.print(loginUser.showInfo());
    }

    public void showCheckoutList(){
        consolePrinter.print(core.showCheckoutList());
    }
}
