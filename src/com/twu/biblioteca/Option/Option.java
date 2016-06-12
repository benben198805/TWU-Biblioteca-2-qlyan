package com.twu.biblioteca.Option;

import com.twu.biblioteca.Biblioteca;

/**
 * Created by ben on 16-6-12.
 */
public abstract class Option {
    private int id;
    private String name;

    public Option(int id, String name) {
        this.id = id;
        this.name = name;
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


    public abstract void run(Biblioteca biblioteca);
}
