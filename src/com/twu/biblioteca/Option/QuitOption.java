package com.twu.biblioteca.Option;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by ben on 16-6-12.
 */
public class QuitOption extends Option{
    public QuitOption(int id,String name) {
        super(id,name,OptionType.NORMAL);
    }

    @Override
    public void run(Biblioteca biblioteca) {
        biblioteca.quit();
    }
}
