package com.twu.biblioteca.Model.Option;

import com.twu.biblioteca.Controller.BibliotecaController;

public class ReturnMovieOption extends Option {
    public ReturnMovieOption(int id, String name) {
        super(id, name,OptionType.NORMAL);
    }

    @Override
    public void run(BibliotecaController bibliotecaController) {
        bibliotecaController.returnMovie();
    }
}
