package com.twu.biblioteca.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String password;
    private String name;
    private String address;
    private String phone;
    private boolean isLibrarian;
    private List<String> bookCheckoutList;
    private List<Integer> movieCheckoutList;


    public User(String id, String password, String name, String address, String phone,boolean isLibrarian) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isLibrarian = isLibrarian;
        this.bookCheckoutList=new ArrayList();
        this.movieCheckoutList=new ArrayList();
    }

    public boolean isLibrarian() {
        return isLibrarian;
    }

    public List<String> getBookCheckoutList() {
        return bookCheckoutList;
    }

    public List<Integer> getMovieCheckoutList() {
        return movieCheckoutList;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void checkoutBook(String bookIsbn) {
        bookCheckoutList.add(bookIsbn);
    }

    public void returnBook(String bookIsbn) {
        bookCheckoutList.remove(bookIsbn);
    }

    public void checkoutMovie(Integer movieId) {
        movieCheckoutList.add(movieId);
    }

    public void returnMovie(Integer movieId) {
        movieCheckoutList.remove(movieId);
    }

    public String getName() {
        return name;
    }

    public String showInfo(){
        return String.format("%s\t%s\t%s\t%s", getId(), getName(), getAddress(), getPhone());
    }

    public String showCheckoutBookAndMovie(){
        String result="User Name:"+getName()+"\n";
        result+="Book:\n";
        for (String bookName:bookCheckoutList) {
            result+=bookName+"\n";
        }
        result+="Movie:\n";
        for (Integer movieId:movieCheckoutList) {
            result+=String.valueOf(movieId)+"\n";
        }
        return result;
    }
}
