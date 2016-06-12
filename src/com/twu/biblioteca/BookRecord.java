package com.twu.biblioteca;

public class BookRecord {
    private Book book;
    private boolean checkoutStatus;

    public BookRecord(Book book) {
        this.book = book;
        this.checkoutStatus = false;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setCheckoutStatus(boolean checkoutStatus) {
        this.checkoutStatus = checkoutStatus;
    }

    public Book getBook() {
        return book;
    }

    public boolean isCheckoutStatus() {
        return checkoutStatus;
    }

    public void checkoutBook(){
        checkoutStatus=true;
    }

    public void returnBook(){
        checkoutStatus=false;
    }

}
