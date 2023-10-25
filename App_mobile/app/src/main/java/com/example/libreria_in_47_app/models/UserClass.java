package com.example.libreria_in_47_app.models;

import com.example.libreria_in_47_app.interfaces.IUser;

public class UserClass implements IUser {

    public static String COLUMN_ID = "id_usuario";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_APELLIDO = "apellido";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_TIPO_USUARIO = "tipo_usuario";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_DNI = "dni";
    public static final String COLUMN_FECHA_NAC = "fecha_nac";
    public static final String COLUMN_TELEFONO = "telefono";
    public static final String COLUMN_FECHA_CREACION = "fecha_creacion";
    public static final String COLUMN_FECHA_MODIFICACION = "fecha_modificacion";

    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public UserClass(int id_usuario, String nombre, String apellido, String email, String telefono) {
        this.id = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() { return nombre; }

    public String getApellido() { return apellido; }

    public String getEmail() { return email; }

    public String getTelefono() { return telefono; }

}
