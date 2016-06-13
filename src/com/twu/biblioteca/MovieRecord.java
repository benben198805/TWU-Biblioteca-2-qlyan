package com.twu.biblioteca;

public class MovieRecord {
    private Movie movie;
    private boolean checkoutStatus;

    public MovieRecord(Movie movie) {
        this.movie = movie;
        this.checkoutStatus=false;
    }

    public Movie getMovie() {
        return movie;
    }

    public boolean isCheckoutStatus() {
        return checkoutStatus;
    }

    public void setCheckoutStatus(boolean checkoutStatus) {
        this.checkoutStatus = checkoutStatus;
    }

    public void checkoutMovie(){
        checkoutStatus=true;
    }

    public void returnMovie(){
        checkoutStatus=false;
    }
}
