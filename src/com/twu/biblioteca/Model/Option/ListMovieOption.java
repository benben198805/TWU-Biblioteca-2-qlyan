package com.twu.biblioteca.Model.Option;

import com.twu.biblioteca.Controller.BibliotecaController;

public class ListMovieOption extends  Option {
    public ListMovieOption(int id, String name) {
        super(id, name,OptionType.NORMAL);
    }

    @Override
    public void run(BibliotecaController bibliotecaController) {
        bibliotecaController.listMovies();
    }
}
