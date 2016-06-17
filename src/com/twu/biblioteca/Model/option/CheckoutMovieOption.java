package com.twu.biblioteca.Model.option;

import com.twu.biblioteca.Controller.BibliotecaController;

/**
 * Created by ben on 16-6-13.
 */
public class CheckoutMovieOption extends Option{
    public CheckoutMovieOption(int id, String name) {
        super(id, name,OptionType.NORMAL);
    }

    @Override
    public void run(BibliotecaController bibliotecaController) {
        bibliotecaController.checkoutMovie();
    }
}
