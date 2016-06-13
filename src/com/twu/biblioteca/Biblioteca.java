package com.twu.biblioteca;

import com.twu.biblioteca.Option.Option;
import com.twu.biblioteca.Option.OptionType;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Biblioteca {
    private List<BookRecord> bookRecords;
    private List<MovieRecord> movieRecoeds;
    private Scanner scanner=new Scanner(System.in);
    private ConsolePrinter consolePrinter;
    private List<Option> menu;
    private List<User> userList;
    private User loginUser;
    private boolean stopSign;

    public Biblioteca(ConsolePrinter consolePrinter, List<Option> menu, List<BookRecord> bookRecords,List<MovieRecord> movieRecoeds,List<User> userList) {
        this.consolePrinter=consolePrinter;
        this.menu = menu;
        this.bookRecords = bookRecords;
        this.movieRecoeds=movieRecoeds;
        this.userList=userList;
        stopSign=false;
        loginUser=null;
    }

    public void start(){
        showWelcomeWords();
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
        if(loginUser==null){
            for(Option option :menu){
                if(option.getOptionType()== OptionType.NORMAL){
                    consolePrinter.print(option.getOptionString());
                }
            }
        }else if(loginUser.isLibrarian()){
            for(Option option :menu){
                if(option.getOptionType()== OptionType.NORMAL||option.getOptionType()==OptionType.LIBRARIAN){
                    consolePrinter.print(option.getOptionString());
                }
            }
        }else{
            for(Option option :menu){
                if(option.getOptionType()== OptionType.NORMAL||option.getOptionType()==OptionType.CUSTOMER){
                    consolePrinter.print(option.getOptionString());
                }
            }
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
        if(isLogined()){
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
        else{
            login();
        }
    }

    public void returnBook(){
        if(isLogined()){

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

    public void setStopSign(boolean stopSign) {
        this.stopSign = stopSign;
    }

    public boolean validateUserIdInput(String id){
        Pattern userIdPattern= Pattern.compile("\\d{3}-\\d{4}");
        Matcher userIdMatcher=userIdPattern.matcher(id);
        return userIdMatcher.matches();
    }

    public boolean isLogined(){
        if(getLoginUser()!=null){
            return true;
        }else{
            return false;
        }
    }

    public void login(){
        consolePrinter.print("please input id");
        String id=scanner.nextLine();

        consolePrinter.print("please input password");
        String password=scanner.nextLine();

        loginIn(id,password);
    }

    public void loginIn(String id, String password) {
        if(validateUserIdInput(id)){
            boolean isValidUser=false;
            for(User user:userList){
                if(user.getId().equals(id)&&user.getPassword().equals(password)){
                    setLoginUser(user);
                    consolePrinter.print("welcome "+user.getName());
                    isValidUser=true;
                }
            }
            if(!isValidUser){
                consolePrinter.print("wrong id or password");
            }
        }else{
            consolePrinter.print("wrong input");
        }
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    public User getLoginUser() {
        return loginUser;
    }

    public void listMovies() {
        listMovieTitle();
        for (MovieRecord movieRecord:movieRecoeds) {
            consolePrinter.print(movieRecord.getMovie().showMovie());
        }
    }

    public void listMovieTitle() {
        consolePrinter.print("id\tname\tyear\tdirector\tmovieRating");
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


    public boolean validateMovieIdInput(Integer userInput){
        for (MovieRecord movieRecord:movieRecoeds) {
            if(movieRecord.getMovie().getId()==userInput){
                return true;
            }
        }
        return false;
    }

    public String getUserMovieIdInput(){
        consolePrinter.print("Please input movie id.");
        String userInput=scanner.nextLine();
        return userInput;
    }

    public void checkoutMovie(){
        if(isLogined()){
            Integer userInput= Integer.parseInt(getUserMovieIdInput());
            if(!validateMovieIdInput(userInput)){
                showInvalidMessage();
                return;
            }

            for (MovieRecord movieBook:movieRecoeds) {
                if(movieBook.getMovie().getId()==userInput&&!movieBook.isCheckoutStatus()){
                    movieBook.setCheckoutStatus(true);
                    showSuccessfulCheckoutMovie();
                }
                else
                {
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
            if(!validateMovieIdInput(userInput)){
                showInvalidMessage();
                return;
            }


            for (MovieRecord movieRecord:movieRecoeds) {
                if(movieRecord.getMovie().getId()==userInput&&movieRecord.isCheckoutStatus()){
                    movieRecord.setCheckoutStatus(false);
                    showSuccessfulReturnMovie();
                }
                else
                {
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
        for (String bookName:loginUser.getBookCheckoutList()) {
            consolePrinter.print(bookName);
        }

        for (Integer movieId:loginUser.getMovieCheckoutList()) {
            consolePrinter.print(String.valueOf(movieId));
        }
    }
}
