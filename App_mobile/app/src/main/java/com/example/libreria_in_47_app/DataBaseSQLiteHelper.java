package com.example.libreria_in_47_app;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.text.Format;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.database.Cursor;

import com.example.libreria_in_47_app.models.AuthorClass;
import com.example.libreria_in_47_app.models.BookClass;

import com.example.libreria_in_47_app.models.UserClass;

import com.example.libreria_in_47_app.models.CategoryClass;
import com.example.libreria_in_47_app.models.EditorialClass;
import com.example.libreria_in_47_app.models.FormatClass;
import com.example.libreria_in_47_app.models.LanguageClass;



public class DataBaseSQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "proyecto_db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseSQLiteHelper(Context contexto) {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crea la tabla "provincia"
        String createTableProvincia = "CREATE TABLE IF NOT EXISTS `provincia` ("
                + "`id_provincia` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`nombre` TEXT NOT NULL);";
        db.execSQL(createTableProvincia);

        // Crea la tabla "localidad"
        String createTableLocalidad = "CREATE TABLE IF NOT EXISTS `localidad` ("
                + "`id_localidad` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`nombre` TEXT NOT NULL, "
                + "`codigo_postal` TEXT NOT NULL);";
        db.execSQL(createTableLocalidad);

        // Crea la tabla "direccion"
        String createTableDireccion = "CREATE TABLE IF NOT EXISTS `direccion` ("
                + "`id_direccion` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`calle_nro` TEXT NOT NULL, "
                + "`provincia_id_provincia` INTEGER NOT NULL, "
                + "`localidad_id_localidad` INTEGER NOT NULL, "
                + "FOREIGN KEY (`provincia_id_provincia`) REFERENCES `provincia` (`id_provincia`), "
                + "FOREIGN KEY (`localidad_id_localidad`) REFERENCES `localidad` (`id_localidad`));";
        db.execSQL(createTableDireccion);

        // Crea la tabla "cliente"
        String createTableCliente = "CREATE TABLE IF NOT EXISTS `cliente` ("
                + "`id_usuario` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`nombre` TEXT NOT NULL, "
                + "`apellido` TEXT NOT NULL, "
                + "`password` TEXT NOT NULL, "
                + "`tipo_usuario` INTEGER NOT NULL, "
                + "`email` TEXT NOT NULL, "
                + "`dni` TEXT, "
                + "`fecha_nac` DATE, "
                + "`telefono` TEXT, "
                + "`fecha_creacion` DATE NOT NULL, "
                + "`fecha_modificacion` DATE);";
        db.execSQL(createTableCliente);

        // Crea la tabla "autor"
        String createTableAutor = "CREATE TABLE IF NOT EXISTS `autor` ("
                + "`id_autor` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`nombre` TEXT NOT NULL, "
                + "`apellido` TEXT NOT NULL);";
        db.execSQL(createTableAutor);

        // Crea la tabla "idioma"
        String createTableIdioma = "CREATE TABLE IF NOT EXISTS `idioma` ("
                + "`id_idioma` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`nombre` TEXT);";
        db.execSQL(createTableIdioma);

        // Crea la tabla "formato"
        String createTableFormato = "CREATE TABLE IF NOT EXISTS `formato` ("
                + "`id_formato` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`tipo` TEXT NOT NULL);";
        db.execSQL(createTableFormato);

        // Crea la tabla "editorial"
        String createTableEditorial = "CREATE TABLE IF NOT EXISTS `editorial` ("
                + "`id_editorial` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`nombre` TEXT NOT NULL);";
        db.execSQL(createTableEditorial);

        // Crea la tabla "categoria"
        String createTableCategoria = "CREATE TABLE IF NOT EXISTS `categoria` ("
                + "`id_categoria` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`tipo` TEXT NOT NULL);";
        db.execSQL(createTableCategoria);

        // Crea la tabla "libro"
        String createTableLibro = "CREATE TABLE IF NOT EXISTS `libro` ("
                + "`id_libro` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`isbn` TEXT NOT NULL, "
                + "`titulo` TEXT NOT NULL, "
                + "`subtitulo` TEXT, "
                + "`descripcion` TEXT, "
                + "`comentarios` TEXT, "
                + "`autor_id_autor` INTEGER NOT NULL, "
                + "`idioma_id_idioma` INTEGER NOT NULL, "
                + "`formato_id_formato` INTEGER NOT NULL, "
                + "`editorial_id_editorial` INTEGER NOT NULL, "
                + "`categoria_id_categoria` INTEGER NOT NULL, "
                + "`calificacion_promedio` REAL DEFAULT 0, "
                + "`numero_calificaciones` INTEGER DEFAULT 0, "
                + "FOREIGN KEY (`autor_id_autor`) REFERENCES `autor` (`id_autor`), "
                + "FOREIGN KEY (`idioma_id_idioma`) REFERENCES `idioma` (`id_idioma`), "
                + "FOREIGN KEY (`formato_id_formato`) REFERENCES `formato` (`id_formato`), "
                + "FOREIGN KEY (`editorial_id_editorial`) REFERENCES `editorial` (`id_editorial`), "
                + "FOREIGN KEY (`categoria_id_categoria`) REFERENCES `categoria` (`id_categoria`)"
                + ");";
        db.execSQL(createTableLibro);

        // Crea la tabla "wishlist"
        String createTableWishlist = "CREATE TABLE IF NOT EXISTS `wishlist` ("
                + "`id_wishlist` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`fecha_creacion` TEXT, "
                + "`cliente_id_usuario` INTEGER NOT NULL, "
                + "`fecha_modificacion` DATE, "
                + "FOREIGN KEY (`cliente_id_usuario`) REFERENCES `cliente` (`id_usuario`));";
        db.execSQL(createTableWishlist);

        // Crea la tabla "elementos_wishlist"
        String createTableElementosWishlist = "CREATE TABLE IF NOT EXISTS `elementos_wishlist` ("
                + "`id_elementos_wishlist` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`wishlist_id_wishlist` INTEGER NOT NULL, "
                + "`libro_id_libro` INTEGER NOT NULL, "
                + "`cantidad` INTEGER, "
                + "FOREIGN KEY (`wishlist_id_wishlist`) REFERENCES `wishlist` (`id_wishlist`), "
                + "FOREIGN KEY (`libro_id_libro`) REFERENCES `libro` (`id_libro`));";
        db.execSQL(createTableElementosWishlist);

        String createTableCalificaciones = "CREATE TABLE IF NOT EXISTS `calificaciones` ("
                + "`id_calificacion` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`libro_id` INTEGER NOT NULL, "
                + "`usuario_id` INTEGER NOT NULL, "
                + "`puntuacion` INTEGER NOT NULL, "
                + "FOREIGN KEY (`libro_id`) REFERENCES `libro` (`id_libro`));";
        db.execSQL(createTableCalificaciones);

        // Inserta autores
        db.execSQL("INSERT INTO autor (nombre, apellido) VALUES ('Gabriel', 'Martínez');");
        db.execSQL("INSERT INTO autor (nombre, apellido) VALUES ('Amelia', 'Valdez');");
        db.execSQL("INSERT INTO autor (nombre, apellido) VALUES ('Enrique', 'Soto');");

        // Inserta idiomas
        db.execSQL("INSERT INTO idioma (nombre) VALUES ('Español');");
        db.execSQL("INSERT INTO idioma (nombre) VALUES ('Inglés');");
        db.execSQL("INSERT INTO idioma (nombre) VALUES ('Francés');");

        // Inserta formatos
        db.execSQL("INSERT INTO formato (tipo) VALUES ('Digital');");
        db.execSQL("INSERT INTO formato (tipo) VALUES ('Impreso');");
        db.execSQL("INSERT INTO formato (tipo) VALUES ('Audiolibro');");

        // Inserta editoriales
        db.execSQL("INSERT INTO editorial (nombre) VALUES ('Ediciones del Bosque');");
        db.execSQL("INSERT INTO editorial (nombre) VALUES ('Línea Clásica Editores');");
        db.execSQL("INSERT INTO editorial (nombre) VALUES ('Páginas Doradas');");

        // Inserta categorías
        db.execSQL("INSERT INTO categoria (tipo) VALUES ('Novela');");
        db.execSQL("INSERT INTO categoria (tipo) VALUES ('Historia');");
        db.execSQL("INSERT INTO categoria (tipo) VALUES ('Ciencia Ficción');");

        //Insertar usuarios
        db.execSQL("INSERT INTO cliente (nombre, apellido, password, tipo_usuario, email, dni, fecha_nac, telefono, fecha_creacion, fecha_modificacion) VALUES ('Juan', 'Pérez', 'passJuan123', 1, 'juan@mail.com', '30123456', '1980-12-01', '5551234', CURRENT_DATE, CURRENT_DATE);");
        db.execSQL("INSERT INTO cliente (nombre, apellido, password, tipo_usuario, email, dni, fecha_nac, telefono, fecha_creacion, fecha_modificacion) VALUES ('Ana', 'García', 'passAna456', 1, 'ana@mail.com', '40123457', '1985-05-15', '5555678', CURRENT_DATE, CURRENT_DATE);");
        db.execSQL("INSERT INTO cliente (nombre, apellido, password, tipo_usuario, email, dni, fecha_nac, telefono, fecha_creacion, fecha_modificacion) VALUES ('Luis', 'Rodriguez', 'passLuis789', 1, 'luis@mail.com', '50123458', '1990-09-21', '5559101', CURRENT_DATE, CURRENT_DATE);");

        // Calificaciones
        db.execSQL("INSERT INTO calificaciones (libro_id, usuario_id, puntuacion) VALUES (1, 1, 5);");
        db.execSQL("INSERT INTO calificaciones (libro_id, usuario_id, puntuacion) VALUES (1, 2, 4);");
        db.execSQL("INSERT INTO calificaciones (libro_id, usuario_id, puntuacion) VALUES (1, 3, 5);");
        db.execSQL("INSERT INTO calificaciones (libro_id, usuario_id, puntuacion) VALUES (2, 1, 4);");
        db.execSQL("INSERT INTO calificaciones (libro_id, usuario_id, puntuacion) VALUES (2, 3, 4);");
        db.execSQL("INSERT INTO calificaciones (libro_id, usuario_id, puntuacion) VALUES (3, 2, 5);");
        db.execSQL("INSERT INTO calificaciones (libro_id, usuario_id, puntuacion) VALUES (3, 3, 4);");

        // Inserta libros
        db.execSQL("INSERT INTO libro (isbn, titulo, subtitulo, descripcion, comentarios, autor_id_autor, idioma_id_idioma, formato_id_formato, editorial_id_editorial, categoria_id_categoria, calificacion_promedio, numero_calificaciones) VALUES ('9781234567890', 'El Monje Negro', 'Subtítulo del libro', 'Apasionante novela que narra la historia de un enigmático personaje que opera en las sombras,', 'Comentarios sobre el libro de este autor', 1, 2, 3, 1, 1, 4.5, 3);");
        db.execSQL("INSERT INTO libro (isbn, titulo, subtitulo, descripcion, comentarios, autor_id_autor, idioma_id_idioma, formato_id_formato, editorial_id_editorial, categoria_id_categoria, calificacion_promedio, numero_calificaciones) VALUES ('9782345678901', 'Mañanas asombrosas', 'Subtítulo del libro', 'Conmovedora obra literaria que nos sumerge en la rutina diaria de un personaje principal cuya vida cambia con maravillas que descubre cada mañana', 'Comentarios sobre el libro de este autor', 2, 1, 3, 2, 2, 4.0, 2);");
        db.execSQL("INSERT INTO libro (isbn, titulo, subtitulo, descripcion, comentarios, autor_id_autor, idioma_id_idioma, formato_id_formato, editorial_id_editorial, categoria_id_categoria, calificacion_promedio, numero_calificaciones) VALUES ('9783456789012', 'Madrugadas de sol', 'Subtítulo del libro', 'Novela que transporta al lector a un mundo de esperanza y renovación', 'Comentarios sobre el libro de este autor', 3, 2, 3, 3, 3, 4.7, 2);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        // Método para gestionar actualizaciones de la base de datos
    }

    // Registro
    public void createUser(Context context, String nombre, String apellido, String password, String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("apellido", apellido);
        values.put("password", password);
        values.put("email", email);
        values.put("tipo_usuario", 2);
        values.put("fecha_creacion", getCurrentDate());

        long userId = db.insert("cliente", null, values);

        if (userId == -1) {
            Toast.makeText(context, "Error en el registro", Toast.LENGTH_SHORT).show();
        } else {
            // Creamos wishlist para el usuario registrado
            ContentValues wishlistValues = new ContentValues();
            wishlistValues.put("cliente_id_usuario", userId);
            wishlistValues.put("fecha_creacion", getCurrentDate());
            long wishlistId = db.insert("wishlist", null, wishlistValues);
            if (wishlistId == -1) {
                Toast.makeText(context, "Error creando wishlist", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Registro exitoso!", Toast.LENGTH_SHORT).show();
            }
        }

        db.close();
    }

    // Eliminar usuario

    public void deleteUser(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = { String.valueOf(id) };
        db.execSQL("DELETE FROM cliente WHERE id_usuario=?", args);
    }

    // Verifica si el email existe
    public boolean isEmailRegistered(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM cliente WHERE email = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email});
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }

    // Login
    public boolean validateUserCredentials(Context context, String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM cliente WHERE email = ? AND password = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, password});
        if (cursor.getCount() <= 0) {
            cursor.close();
            return false;
        }
        cursor.moveToFirst();

        int columnIndex = cursor.getColumnIndex("id_usuario");
        if(columnIndex != -1) {
            long userId = cursor.getLong(columnIndex);
            // Guardar el ID del usuario en Preferencias Compartidas para dsp poder obtenerlo
            SharedPreferences sharedPreferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putLong("userId", userId);
            editor.apply();
        } else {
            Toast.makeText(context, "Internal error.", Toast.LENGTH_SHORT).show();
        }

        cursor.close();
        return true;
    }

    //Obtener usuario logeado
    public long getLoggedUserId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        return sharedPreferences.getLong("userId", -1);  // Devuelve -1 si no se encuentra el ID del usuario
    }

    // Obtener la wishlist
    public long getWishlist(long userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT id_wishlist FROM wishlist WHERE cliente_id_usuario = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(userId)});
        long wishlistId = -1;
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("id_wishlist");
            if(columnIndex != -1) {
                wishlistId = cursor.getLong(columnIndex);
            }
        }
        cursor.close();
        return wishlistId;
    }

    // Agregar libro a la wishlist
    public boolean addToWishlist(long wishlistId, long libroId) {
        SQLiteDatabase db = this.getReadableDatabase();
        // tal vez agregar una validacion para saber si el libro ya existe en la wishlist?
        ContentValues contentValues = new ContentValues();
        contentValues.put("wishlist_id_wishlist", wishlistId);
        contentValues.put("libro_id_libro", libroId); // libroId lo tengo q traer con un intent
        long result = db.insert("elementos_wishlist", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean delFromWishlist(long wishlistId, long libroId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = { String.valueOf(wishlistId), String.valueOf(libroId) };
        db.execSQL("DELETE FROM elementos_wishlist WHERE wishlist_id_wishlist=? AND libro_id_libro=?", args);
        //
        return true;
    }

    // Metodo para saber si el libro ya esta en la lista
    public List<Integer> getBookIdsInWishlist(long clienteId) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Integer> booksInWishlist = new ArrayList<>();
        // Consulta SQL para obtener los libros en la wishlist del cliente
        String consulta = "SELECT libro_id_libro FROM elementos_wishlist WHERE wishlist_id_wishlist IN (SELECT id_wishlist FROM wishlist WHERE cliente_id_usuario = ?)";
        Cursor cursor = db.rawQuery(consulta, new String[]{String.valueOf(clienteId)});

        int columnIndex = cursor.getColumnIndex("libro_id_libro");

        while (cursor.moveToNext()) {
            if (columnIndex != -1) {
                int libroId = cursor.getInt(columnIndex);
                booksInWishlist.add(libroId);
            }
        }

        cursor.close();
        return booksInWishlist;
    }

    // Método para traer todos los libros de la wishlist del usuario logueado.
    public List<BookClass> getBooksInWishlist(long usuarioId){

        List<BookClass> books = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT libro_id_libro FROM elementos_wishlist WHERE wishlist_id_wishlist IN (SELECT id_wishlist FROM wishlist WHERE cliente_id_usuario = ?)";

        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(usuarioId)});

        int columnIndex = cursor.getColumnIndex("libro_id_libro");

        while (cursor.moveToNext()) {
            if (columnIndex != -1) {
                int libroId = cursor.getInt(columnIndex);
                BookClass book = getBookById(libroId);
                books.add(book);
            }
        }
        cursor.close();
        return books;
    }

    // Metodo auxiliar para obtener la fecha actual.
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    // Obtener todos los libros de la DB.
    public List<BookClass> getAllBooks() {

        List<BookClass> books = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM libro";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range")
                int id = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_ID));
                @SuppressLint("Range")
                String isbn = cursor.getString(cursor.getColumnIndex(BookClass.COLUMN_ISBN));
                @SuppressLint("Range")
                String title = cursor.getString(cursor.getColumnIndex(BookClass.COLUMN_TITULO));
                @SuppressLint("Range")
                String subtitle = cursor.getString(cursor.getColumnIndex(BookClass.COLUMN_SUBTITULO));
                @SuppressLint("Range")
                String description = cursor.getString(cursor.getColumnIndex(BookClass.COLUMN_DESCRIPCION));
                @SuppressLint("Range")
                String comments = cursor.getString(cursor.getColumnIndex(BookClass.COLUMN_COMENTARIOS));
                @SuppressLint("Range")
                int authorId = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_AUTOR_ID));
                @SuppressLint("Range")
                int languageId = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_IDIOMA_ID));
                @SuppressLint("Range")
                int formatId = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_FORMATO_ID));
                @SuppressLint("Range")
                int editorialId = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_EDITORIAL_ID));
                @SuppressLint("Range")
                int categoryId = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_CATEGORIA_ID));
                @SuppressLint("Range")
                float score = cursor.getFloat(cursor.getColumnIndex(BookClass.COLUMN_CALIFICACION_PROMEDIO));
                @SuppressLint("Range")
                int numberScores = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_NUMERO_CALIFICACIONES));

                BookClass book = new BookClass(id, isbn, title, subtitle, description, comments, authorId, languageId, formatId, editorialId, categoryId, score, numberScores);

                books.add(book);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return books;
    }

    public BookClass getBookById (int idLibro) {
        //metodo para retornar objeto libro por id
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM libro WHERE id_libro = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(idLibro)});

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            @SuppressLint("Range")
            int id = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_ID));
            @SuppressLint("Range")
            String isbn = cursor.getString(cursor.getColumnIndex(BookClass.COLUMN_ISBN));
            @SuppressLint("Range")
            String title = cursor.getString(cursor.getColumnIndex(BookClass.COLUMN_TITULO));
            @SuppressLint("Range")
            String subtitle = cursor.getString(cursor.getColumnIndex(BookClass.COLUMN_SUBTITULO));
            @SuppressLint("Range")
            String description = cursor.getString(cursor.getColumnIndex(BookClass.COLUMN_DESCRIPCION));
            @SuppressLint("Range")
            String comments = cursor.getString(cursor.getColumnIndex(BookClass.COLUMN_COMENTARIOS));
            @SuppressLint("Range")
            int authorId = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_AUTOR_ID));
            @SuppressLint("Range")
            int languageId = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_IDIOMA_ID));
            @SuppressLint("Range")
            int formatId = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_FORMATO_ID));
            @SuppressLint("Range")
            int editorialId = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_EDITORIAL_ID));
            @SuppressLint("Range")
            int categoryId = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_CATEGORIA_ID));
            @SuppressLint("Range")
            float score = cursor.getFloat(cursor.getColumnIndex(BookClass.COLUMN_CALIFICACION_PROMEDIO));
            @SuppressLint("Range")
            int numberScores = cursor.getInt(cursor.getColumnIndex(BookClass.COLUMN_NUMERO_CALIFICACIONES));

            BookClass book = new BookClass(id, isbn, title, subtitle, description, comments, authorId, languageId, formatId, editorialId, categoryId, score, numberScores);
            cursor.close();
            return book;
        } else {
            cursor.close();
            return null;
        }
    }

    //Método para retornar objeto User
    public UserClass getUserById (long userId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM cliente WHERE id_usuario = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(userId)});

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            @SuppressLint("Range")
            int id_usuario = cursor.getInt(cursor.getColumnIndex(UserClass.COLUMN_ID));
            @SuppressLint("Range")
            String nombre = cursor.getString(cursor.getColumnIndex(UserClass.COLUMN_NOMBRE));
            @SuppressLint("Range")
            String apellido = cursor.getString(cursor.getColumnIndex(UserClass.COLUMN_APELLIDO));
            @SuppressLint("Range")
            String password = cursor.getString(cursor.getColumnIndex(UserClass.COLUMN_PASSWORD));
            @SuppressLint("Range")
            String tipo_usuario = cursor.getString(cursor.getColumnIndex(UserClass.COLUMN_TIPO_USUARIO));
            @SuppressLint("Range")
            String email = cursor.getString(cursor.getColumnIndex(UserClass.COLUMN_EMAIL));
            @SuppressLint("Range")
            String dni = cursor.getString(cursor.getColumnIndex(UserClass.COLUMN_DNI));
            @SuppressLint("Range")
            String fecha_nac = cursor.getString(cursor.getColumnIndex(UserClass.COLUMN_FECHA_NAC));
            @SuppressLint("Range")
            String telefono = cursor.getString(cursor.getColumnIndex(UserClass.COLUMN_TELEFONO));
            @SuppressLint("Range")
            String fecha_creacion = cursor.getString(cursor.getColumnIndex(UserClass.COLUMN_FECHA_CREACION));
            @SuppressLint("Range")
            String fecha_modificacion = cursor.getString(cursor.getColumnIndex(UserClass.COLUMN_FECHA_MODIFICACION));

            UserClass user = new UserClass ( id_usuario, nombre, apellido, password, tipo_usuario, email, dni, fecha_nac, telefono, fecha_creacion, fecha_modificacion);
            cursor.close();
            return user;
        } else {
            cursor.close();
            return null;
        }
    }

    //Actualizar calificación del libro.
    public void rateBook(int bookId, float userRating) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT calificacion_promedio, numero_calificaciones FROM libro WHERE id_libro = ?", new String[]{String.valueOf(bookId)});

        if (cursor.moveToFirst()) {
            int ratingIndex = cursor.getColumnIndex("calificacion_promedio");
            int numberRatingsIndex = cursor.getColumnIndex("numero_calificaciones");

            if (ratingIndex != -1 && numberRatingsIndex != -1) {
                double currentRating = cursor.getDouble(ratingIndex);
                int numberRatings = cursor.getInt(numberRatingsIndex);

                // Nueva calificación promedio
                double newRating = ((currentRating * numberRatings) + userRating) / (numberRatings + 1);
                int newNumberRatings = numberRatings + 1;

                ContentValues values = new ContentValues();
                values.put("calificacion_promedio", newRating);
                values.put("numero_calificaciones", newNumberRatings);

                db.update("libro", values, "id_libro = ?", new String[]{String.valueOf(bookId)});
            } else {
                Log.e("rateBook", "error saving score in database");
            }
        }

        cursor.close();
    }

    // Obtener todas las editoriales de la db
    public List<EditorialClass> getAllPublishers() {
        List<EditorialClass> publishers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM editorial";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range")
                int id = cursor.getInt(cursor.getColumnIndex(EditorialClass.COLUMN_ID));
                @SuppressLint("Range")
                String name = cursor.getString(cursor.getColumnIndex(EditorialClass.COLUMN_NAME));

                EditorialClass publisher = new EditorialClass(id, name);

                publishers.add(publisher);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return publishers;
    }

    public EditorialClass getPublisherById (int idEditorial) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM editorial WHERE id_editorial = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(idEditorial)});

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            @SuppressLint("Range")
            int id_editorial = cursor.getInt(cursor.getColumnIndex(EditorialClass.COLUMN_ID));
            @SuppressLint("Range")
            String nombre = cursor.getString(cursor.getColumnIndex(EditorialClass.COLUMN_NAME));

            EditorialClass publisher = new EditorialClass(id_editorial, nombre);
            cursor.close();
            return publisher;
        } else {
            cursor.close();
            return null;
        }
    }

    // Obtener todos los formatos

    public List<FormatClass> getAllFormats() {
        List<FormatClass> formats = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM formato";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range")
                int id = cursor.getInt(cursor.getColumnIndex(FormatClass.COLUMN_ID));
                @SuppressLint("Range")
                String tipo = cursor.getString(cursor.getColumnIndex(FormatClass.COLUMN_TYPE));

                FormatClass format = new FormatClass(id, tipo);

                formats.add(format);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return formats;
    }

    public FormatClass getFormatById (int idFormat) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM formato WHERE id_formato = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(idFormat)});

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            @SuppressLint("Range")
            int id_formato = cursor.getInt(cursor.getColumnIndex(FormatClass.COLUMN_ID));
            @SuppressLint("Range")
            String tipo = cursor.getString(cursor.getColumnIndex(FormatClass.COLUMN_TYPE));

            FormatClass format = new FormatClass(id_formato, tipo);
            cursor.close();
            return format;
        } else {
            cursor.close();
            return null;
        }
    }

    // Obtener todos los idiomas
    public List<LanguageClass> getAllLanguages() {
        List<LanguageClass> languages = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM idioma";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range")
                int id = cursor.getInt(cursor.getColumnIndex(LanguageClass.COLUMN_ID));
                @SuppressLint("Range")
                String nombre = cursor.getString(cursor.getColumnIndex(LanguageClass.COLUMN_NAME));

                LanguageClass language = new LanguageClass(id, nombre);

                languages.add(language);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return languages;
    }

    public LanguageClass getLanguageById (int idLanguage) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM idioma WHERE id_idioma = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(idLanguage)});

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            @SuppressLint("Range")
            int id_idioma = cursor.getInt(cursor.getColumnIndex(LanguageClass.COLUMN_ID));
            @SuppressLint("Range")
            String nombre = cursor.getString(cursor.getColumnIndex(LanguageClass.COLUMN_NAME));

            LanguageClass language = new LanguageClass(id_idioma, nombre);
            cursor.close();
            return language;
        } else {
            cursor.close();
            return null;
        }
    }

    // Obtener todas las categorias
    public List<CategoryClass> getAllCategories() {
        List<CategoryClass> categories = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM categoria";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range")
                int id = cursor.getInt(cursor.getColumnIndex(CategoryClass.COLUMN_ID));
                @SuppressLint("Range")
                String tipo = cursor.getString(cursor.getColumnIndex(CategoryClass.COLUMN_TYPE));

                CategoryClass category = new CategoryClass(id, tipo);

                categories.add(category);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return categories;
    }

    public CategoryClass getCategoryById (int idCategory) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM categoria WHERE id_categoria = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(idCategory)});

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            @SuppressLint("Range")
            int id_categoria = cursor.getInt(cursor.getColumnIndex(CategoryClass.COLUMN_ID));
            @SuppressLint("Range")
            String tipo = cursor.getString(cursor.getColumnIndex(CategoryClass.COLUMN_TYPE));

            CategoryClass category = new CategoryClass(id_categoria, tipo);
            cursor.close();
            return category;
        } else {
            cursor.close();
            return null;
        }
    }

    // Obtener todos los autores
    public List<AuthorClass> getAllAuthors() {
        List<AuthorClass> authors = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM autor";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range")
                int id = cursor.getInt(cursor.getColumnIndex(AuthorClass.COLUMN_ID));
                @SuppressLint("Range")
                String firstname = cursor.getString(cursor.getColumnIndex(AuthorClass.COLUMN_FIRST_NAME));
                @SuppressLint("Range")
                String lastname = cursor.getString(cursor.getColumnIndex(AuthorClass.COLUMN_LAST_NAME));

                AuthorClass author = new AuthorClass(id, firstname, lastname);

                authors.add(author);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return authors;
    }

    public AuthorClass getAuthorById (int idAuthor) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM autor WHERE id_autor = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(idAuthor)});

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            @SuppressLint("Range")
            int id = cursor.getInt(cursor.getColumnIndex(AuthorClass.COLUMN_ID));
            @SuppressLint("Range")
            String firstname = cursor.getString(cursor.getColumnIndex(AuthorClass.COLUMN_FIRST_NAME));
            @SuppressLint("Range")
            String lastname = cursor.getString(cursor.getColumnIndex(AuthorClass.COLUMN_LAST_NAME));

            AuthorClass author = new AuthorClass(id, firstname, lastname);
            cursor.close();
            return author;
        } else {
            cursor.close();
            return null;
        }
    }


}

