package com.twu.biblioteca;

import java.util.Date;

/**
 * Created by ben on 16-6-12.
 */
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String showBook(){
        return String.format("%s\t%s\t%s\t%s", getIsbn(), getName(), getAuthor(), getYear());
    }
}
