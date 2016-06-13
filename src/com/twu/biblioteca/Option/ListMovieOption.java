package com.twu.biblioteca.Option;

import com.twu.biblioteca.Biblioteca;

public class ListMovieOption extends  Option {
    public ListMovieOption(int id, String name) {
        super(id, name,OptionType.NORMAL);
    }

    @Override
    public void run(Biblioteca biblioteca) {
        biblioteca.listMovies();
    }
}
