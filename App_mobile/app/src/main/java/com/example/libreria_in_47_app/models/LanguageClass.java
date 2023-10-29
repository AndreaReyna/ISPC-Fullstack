package com.example.libreria_in_47_app.models;

import com.example.libreria_in_47_app.interfaces.ILanguage;

public class LanguageClass implements ILanguage {
    public static final String COLUMN_ID = "id_idioma";
    public static final String COLUMN_NAME = "nombre";

    private int id;
    private String name;

    public LanguageClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}