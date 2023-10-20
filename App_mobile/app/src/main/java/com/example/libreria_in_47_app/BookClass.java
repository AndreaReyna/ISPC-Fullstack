package com.example.libreria_in_47_app;

public class BookClass {
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

    private int id;
    private String isbn;
    private String titulo;
    private String subtitulo;
    private String descripcion;
    private String comentarios;
    private int autorId;
    private long idiomaId;
    private long formatoId;
    private long editorialId;
    private long categoriaId;

    public BookClass(int id, String isbn, String titulo, String subtitulo, String descripcion, String comentarios, int autorId, int idiomaId, int formatoId, int editorialId, int categoriaId) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.descripcion = descripcion;
        this.comentarios = comentarios;
        this.autorId = autorId;
        this.idiomaId = idiomaId;
        this.formatoId = formatoId;
        this.editorialId = editorialId;
        this.categoriaId = categoriaId;
    }

    public long getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public long getAutorId() {
        return autorId;
    }

    public long getIdiomaId() {
        return idiomaId;
    }

    public long getFormatoId() {
        return formatoId;
    }

    public long getEditorialId() {
        return editorialId;
    }

    public long getCategoriaId() {
        return categoriaId;
    }
}
