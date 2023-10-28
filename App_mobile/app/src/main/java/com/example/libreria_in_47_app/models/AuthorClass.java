package com.example.libreria_in_47_app.models;

import com.example.libreria_in_47_app.interfaces.IAuthor;

public class AuthorClass implements IAuthor {
    public static final String COLUMN_ID = "id_autor";
    public static final String COLUMN_FIRST_NAME = "nombre";
    public static final String COLUMN_LAST_NAME = "apellido";

    private int id;
    private String firstName;
    private String lastName;

    public AuthorClass(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}