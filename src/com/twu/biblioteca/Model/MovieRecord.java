package com.twu.biblioteca.Model;

import com.twu.biblioteca.Model.Movie;

public class MovieRecord {
    private Movie movie;
    private boolean checkoutStatus;

    public MovieRecord(int id,String name, String year, String director, int movieRating) {
        String realMovieRating=validateMovieRatingInput(movieRating);
        this.movie = new Movie(id,name, year, director, realMovieRating);
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

    public String showMovie(){
        return String.format("%d\t%s\t%s\t%s\t%s", movie.getId(), movie.getName(), movie.getYear(), movie.getDirector(),movie.getMovieRating());
    }


    public String validateMovieRatingInput(int movieRating) {
        if(movieRating>=1&&movieRating<=10){
            return  String.valueOf(movieRating);
        }
        else
        {
            return  "unrated";
        }
    }


}
