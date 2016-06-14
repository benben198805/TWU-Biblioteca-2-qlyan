package com.twu.biblioteca.Model.Option;

import com.twu.biblioteca.Controller.BibliotecaController;

public class ShowUserCheckoutInfo extends Option{
    public ShowUserCheckoutInfo(int id, String name) {
        super(id, name,OptionType.LIBRARIAN);
    }

    @Override
    public void run(BibliotecaController bibliotecaController) {
        bibliotecaController.showCheckoutList();
    }
}
