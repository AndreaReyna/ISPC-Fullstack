package com.example.libreria_in_47_app.models;

import com.example.libreria_in_47_app.interfaces.IFormat;

public class FormatClass implements IFormat {
    public static final String COLUMN_ID = "id_formato";
    public static final String COLUMN_TYPE = "tipo";

    private int id;
    private String type;

    public FormatClass(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}