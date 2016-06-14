package com.twu.biblioteca.Model.Option;

import com.twu.biblioteca.Controller.BibliotecaController;

/**
 * Created by ben on 16-6-12.
 */
public abstract class Option {
    private int id;
    private String name;
    private OptionType optionType;

    public Option(int id, String name,OptionType optionType) {
        this.id = id;
        this.name = name;
        this.optionType=optionType;
    }

    public OptionType getOptionType() {
        return optionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOptionString(){
        return String.format("%s\t%s", getId(), getName());
    }


    public abstract void run(BibliotecaController bibliotecaController);
}
