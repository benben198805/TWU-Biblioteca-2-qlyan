package com.twu.biblioteca.Option;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by ben on 16-6-13.
 */
public class CheckoutMovieOption extends Option{
    public CheckoutMovieOption(int id, String name) {
        super(id, name,OptionType.NORMAL);
    }

    @Override
    public void run(Biblioteca biblioteca) {
        biblioteca.checkoutMovie();
    }
}
