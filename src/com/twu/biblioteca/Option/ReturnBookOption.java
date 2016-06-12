package com.twu.biblioteca.Option;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by ben on 16-6-12.
 */
public class ReturnBookOption extends Option {
    public ReturnBookOption(int id, String name) {
        super(id, name);
    }

    @Override
    public void run(Biblioteca biblioteca) {
        biblioteca.returnBook();
    }
}
