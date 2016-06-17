package com.twu.biblioteca.Model;

import java.util.Date;

public class Book {
    private String isbn;
    private String name;
    private String author;
    private String year;

    public Book(String isbn, String name, String author, String year) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }


    public String getAuthor() {
        return author;
    }


    public String getYear() {
        return year;
    }


}
