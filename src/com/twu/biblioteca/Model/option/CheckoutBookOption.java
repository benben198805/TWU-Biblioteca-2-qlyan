package com.twu.biblioteca.Model.option;

import com.twu.biblioteca.Controller.BibliotecaController;

/**
 * Created by ben on 16-6-12.
 */
public class CheckoutBookOption extends Option {
    public CheckoutBookOption(int id, String name) {
        super(id, name,OptionType.NORMAL);
    }

    @Override
    public void run(BibliotecaController bibliotecaController) {
        bibliotecaController.checkoutBook();
    }
}

