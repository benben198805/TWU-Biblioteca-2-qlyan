package com.twu.biblioteca;

public class Movie {
    private int id;
    private String name;
    private String year;
    private String director;
    private String movieRating;

    public Movie(int id,String name, String year, String director, int movieRating) {
        this.id=id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating=validateMovieRatingInput(movieRating);
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

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getMovieRating() {
        return movieRating;
    }

    public int getId() {
        return id;
    }

    public String showMovie(){
        return String.format("%d\t%s\t%s\t%s\t%s", getId(), getName(), getYear(), getDirector(),getMovieRating());
    }

}
