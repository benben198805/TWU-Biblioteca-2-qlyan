package com.twu.biblioteca.Option;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by ben on 16-6-12.
 */
public class CheckoutBookOption extends Option {
    public CheckoutBookOption(int id, String name) {
        super(id, name,OptionType.NORMAL);
    }

    @Override
    public void run(Biblioteca biblioteca) {
        biblioteca.checkoutBook();
    }
}

