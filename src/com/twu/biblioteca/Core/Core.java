package com.twu.biblioteca.Core;

import com.twu.biblioteca.Model.BookRecord;
import com.twu.biblioteca.Model.MovieRecord;
import com.twu.biblioteca.Model.option.Option;
import com.twu.biblioteca.Model.option.OptionType;
import com.twu.biblioteca.Model.User;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Core {
    private List<BookRecord> bookRecords;
    private List<MovieRecord> movieRecoeds;
    private List<User> userList;
    private Map<String,Option> menu;

    public Core(List<BookRecord> bookRecords, List<MovieRecord> movieRecoeds, List<User> userList, Map<String,Option> menu) {
        this.bookRecords = bookRecords;
        this.movieRecoeds = movieRecoeds;
        this.userList = userList;
        this.menu=menu;
    }


    public String listMenu(User loginUser){
        String menuListString="";
        if(loginUser==null){
            for(String key:menu.keySet()) {
                Option option = menu.get(key);
                if(option.getOptionType()== OptionType.NORMAL){
                    menuListString+=option.getOptionString()+"\n";
                }
            }
        }else if(loginUser.isLibrarian()){
            for(String key:menu.keySet()) {
                Option option = menu.get(key);
                if(option.getOptionType()== OptionType.NORMAL||option.getOptionType()==OptionType.LIBRARIAN){
                    menuListString+=option.getOptionString()+"\n";
                }
            }
        }else{
            for(String key:menu.keySet()) {
                Option option = menu.get(key);
                if(option.getOptionType()== OptionType.NORMAL||option.getOptionType()==OptionType.CUSTOMER){
                    menuListString+=option.getOptionString()+"\n";
                }
            }
        }
        return menuListString;
    }

    public boolean validateMenuSelect(String menuId){
        if(menu.containsKey(menuId)){
            return true;
        }else
        {
            return false;
        }
    }


    public Option runMenuOption(String menuId) {
        return menu.get(menuId);
    }


    public String listbooks(){
        return listBookTitle()+listBookDetail();
    }

    public String listBookTitle(){
        return "isbn\tname\tauthor\tyear\n";
    }

    public String listBookDetail(){
        String bookListString="";
        for (BookRecord bookRecord:bookRecords) {
            bookListString+=bookRecord.isCheckoutStatus()?"":bookRecord.showBook()+"\n";
        }
        return bookListString;
    }

    public boolean validateIsbnInput(String userInput){
        for (BookRecord bookRecord:bookRecords) {
            if(bookRecord.getBook().getIsbn().equals(userInput)){
                return true;
            }
        }
        return false;
    }


    public boolean checkoutBook(String userInput) {
        for (BookRecord bookRecord:bookRecords) {
            if(bookRecord.getBook().getIsbn().equals(userInput)&&!bookRecord.isCheckoutStatus()){
                bookRecord.setCheckoutStatus(true);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String userInput) {
        for (BookRecord bookRecord:bookRecords) {
            if(bookRecord.getBook().getIsbn().equals(userInput)&&bookRecord.isCheckoutStatus()){
                bookRecord.setCheckoutStatus(false);
                return true;
            }
        }
        return false;
    }


    public boolean validateUserIdInput(String id){
        Pattern userIdPattern= Pattern.compile("\\d{3}-\\d{4}");
        Matcher userIdMatcher=userIdPattern.matcher(id);
        return userIdMatcher.matches();
    }


    public User checkoutUser(String id, String password) {
        for(User user:userList){
            if(user.getId().equals(id)&&user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }





    public String listMovieTitle() {
        return "id\tname\tyear\tdirector\tmovieRating";
    }


    public String listMovieDetail() {
        String movieListString="";
        for (MovieRecord movieRecord:movieRecoeds) {
            movieListString+=movieRecord.isCheckoutStatus()?"":movieRecord.showMovie()+"\n";
        }
        return movieListString;
    }

    public boolean validateMovieIdInput(Integer userInput) {
        for (MovieRecord movieRecord:movieRecoeds) {
            if(movieRecord.getMovie().getId()==userInput){
                return true;
            }
        }
        return false;
    }

    public boolean checkoutMovie(Integer userInput) {
        for (MovieRecord movieBook:movieRecoeds) {
            if(movieBook.getMovie().getId()==userInput&&!movieBook.isCheckoutStatus()){
                movieBook.setCheckoutStatus(true);
                return true;
            }
        }
        return false;
    }

    public boolean returnMovie(Integer userInput) {
        for (MovieRecord movieRecord:movieRecoeds) {
            if(movieRecord.getMovie().getId()==userInput&&movieRecord.isCheckoutStatus()){
                movieRecord.setCheckoutStatus(false);
                return true;
            }
        }
        return false;
    }

    public String showCheckoutList() {
        String result="";
        for(User user:userList){
            result+=user.showCheckoutBookAndMovie();
        }
        return result;
    }
}
