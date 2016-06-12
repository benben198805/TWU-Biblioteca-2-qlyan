package com.twu.biblioteca.Option;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by ben on 16-6-12.
 */
public class ListBookOption extends Option {
    public ListBookOption(int id, String name) {
        super(id, name);
    }

    @Override
    public void run(Biblioteca biblioteca) {
        biblioteca.listBooks();
    }
}
