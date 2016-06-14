package com.twu.biblioteca.Model;

public class Movie {
    private int id;
    private String name;
    private String year;
    private String director;
    private String movieRating;

    public Movie(int id,String name, String year, String director, String movieRating) {
        this.id=id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating=movieRating;
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

}
