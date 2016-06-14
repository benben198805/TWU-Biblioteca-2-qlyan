package com.twu.biblioteca.Model.Option;

import com.twu.biblioteca.Controller.BibliotecaController;

/**
 * Created by ben on 16-6-12.
 */
public class ListBookOption extends Option {
    public ListBookOption(int id, String name) {
        super(id, name,OptionType.NORMAL);
    }

    @Override
    public void run(BibliotecaController bibliotecaController) {
        bibliotecaController.listBooks();
    }
}
