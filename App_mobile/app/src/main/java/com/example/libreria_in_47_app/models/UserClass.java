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

    private String password;

    private String tipo_usuario;

    private String email;

    private String dni;

    private String fecha_nac;
    private String telefono;

    private String fecha_creacion;
    private String fecha_modificacion;


    public UserClass(int id_usuario, String nombre, String apellido, String password, String tipo_usuario, String email, String dni, String fecha_nac, String telefono, String fecha_creacion, String fecha_modificacion) {
        this.id = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
        this.email = email;
        this.dni = dni;
        this.fecha_nac = fecha_nac;
        this.telefono = telefono;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
    }

    public int getIdUser() { return id; }

    public String getNombre() { return nombre; }

    public String getApellido() { return apellido; }

    public String getPassword() { return password; }

    public String getTipo_usuario() { return tipo_usuario; }

    public String getEmail() { return email; }

    public String getDni() { return dni; }

    public String getFecha_nac() { return fecha_nac; }

    public String getTelefono() { return telefono; }

    public String getFecha_creacion() { return fecha_creacion; }

    public String getFecha_modificacion() { return fecha_modificacion; }

}
