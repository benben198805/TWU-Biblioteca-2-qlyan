package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 16-6-12.
 */
public class BookList {
    private List<BookRecord> bookList=new ArrayList<BookRecord>();

    public BookList(List<BookRecord> bookList) {
        this.bookList = bookList;
    }

    public List<BookRecord> getBookList() {
        return bookList;
    }
}
