package com.twu.biblioteca.Option;

import com.twu.biblioteca.Biblioteca;

public class ShowUserCheckoutInfo extends Option{
    public ShowUserCheckoutInfo(int id, String name) {
        super(id, name,OptionType.LIBRARIAN);
    }

    @Override
    public void run(Biblioteca biblioteca) {
        biblioteca.showCheckoutList();
    }
}
