package com.example.libreria_in_47_app.models;

import com.example.libreria_in_47_app.interfaces.IUser;

public class UserClass implements IUser {
    public static String COLUMN_ID = "id_usuario";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_APELLIDO = "apellido";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_TELEFONO = "telefono";

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public UserClass(int id_usuario, String nombre, String apellido, String email, String telefono) {
        this.id_usuario= id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

}
