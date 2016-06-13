package com.twu.biblioteca.Option;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by ben on 16-6-13.
 */
public class ShowMyInfoOption extends Option{

    public ShowMyInfoOption(int id, String name) {
        super(id, name,OptionType.CUSTOMER);
    }

    @Override
    public void run(Biblioteca biblioteca) {
        biblioteca.showMyInfo();

    }
}
