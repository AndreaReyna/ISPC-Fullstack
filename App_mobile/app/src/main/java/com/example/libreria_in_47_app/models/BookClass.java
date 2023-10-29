package com.example.libreria_in_47_app.models;

import com.example.libreria_in_47_app.interfaces.IBook;

public class BookClass implements IBook {
    public static String COLUMN_ID = "id_libro";
    public static final String COLUMN_ISBN = "isbn";
    public static final String COLUMN_TITULO = "titulo";
    public static final String COLUMN_SUBTITULO = "subtitulo";
    public static final String COLUMN_DESCRIPCION = "descripcion";
    public static final String COLUMN_COMENTARIOS = "comentarios";
    public static final String COLUMN_AUTOR_ID = "autor_id_autor";
    public static final String COLUMN_IDIOMA_ID = "idioma_id_idioma";
    public static final String COLUMN_FORMATO_ID = "formato_id_formato";
    public static final String COLUMN_EDITORIAL_ID = "editorial_id_editorial";
    public static final String COLUMN_CATEGORIA_ID = "categoria_id_categoria";
    public static final String COLUMN_CALIFICACION_PROMEDIO = "calificacion_promedio";
    public static final String COLUMN_NUMERO_CALIFICACIONES = "numero_calificaciones";



    private int id;
    private String isbn;
    private String title;
    private String subtitle;
    private String description;
    private String comments;
    private int authorId;
    private int languageId;
    private int formatId;
    private int editorialId;
    private int categoryId;

    private float score;
    private int numberScores;

    public BookClass(int id, String isbn, String title, String subtitle, String description, String comments, int authorId, int languageId, int formatId, int editorialId, int categoryId, float score, int numberScores) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.comments = comments;
        this.authorId = authorId;
        this.languageId = languageId;
        this.formatId = formatId;
        this.editorialId = editorialId;
        this.categoryId = categoryId;
        this.score = score;
        this.numberScores = numberScores;
    }

    public BookClass(int idUsuario, String nombre, String apellido, String password, String tipoUsuario, String email, String dni, String fechaNac, String telefono, String fechaCreacion, String fechaModificacion) {
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }

    public String getComments() {
        return comments;
    }

    public int getAuthorId() {
        return authorId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public int getFormatId() {
        return formatId;
    }

    public int getEditorialId() {
        return editorialId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public float getScore() {
        return score;
    }

    public int getNumberScores() {
        return numberScores;
    }

}
