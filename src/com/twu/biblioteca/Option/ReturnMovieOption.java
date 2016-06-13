package com.twu.biblioteca.Option;

import com.twu.biblioteca.Biblioteca;

public class ReturnMovieOption extends Option {
    public ReturnMovieOption(int id, String name) {
        super(id, name,OptionType.NORMAL);
    }

    @Override
    public void run(Biblioteca biblioteca) {
        biblioteca.returnMovie();
    }
}
