package com.twu.biblioteca.Model.option;

import com.twu.biblioteca.Controller.BibliotecaController;

/**
 * Created by ben on 16-6-13.
 */
public class ShowMyInfoOption extends Option{

    public ShowMyInfoOption(int id, String name) {
        super(id, name,OptionType.CUSTOMER);
    }

    @Override
    public void run(BibliotecaController bibliotecaController) {
        bibliotecaController.showMyInfo();

    }
}
