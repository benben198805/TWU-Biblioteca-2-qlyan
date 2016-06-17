package com.twu.biblioteca.Model.option;

import com.twu.biblioteca.Controller.BibliotecaController;

/**
 * Created by ben on 16-6-12.
 */
public class ReturnBookOption extends Option {
    public ReturnBookOption(int id, String name) {
        super(id, name,OptionType.NORMAL);
    }

    @Override
    public void run(BibliotecaController bibliotecaController) {
        bibliotecaController.returnBook();
    }
}
