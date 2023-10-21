package com.example.libreria_in_47_app;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.database.Cursor;

import com.example.libreria_in_47_app.models.BookClass;


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
                + "FOREIGN KEY (`autor_id_autor`) REFERENCES `autor` (`id_autor`), "
                + "FOREIGN KEY (`idioma_id_idioma`) REFERENCES `idioma` (`id_idioma`), "
                + "FOREIGN KEY (`formato_id_formato`) REFERENCES `formato` (`id_formato`), "
                + "FOREIGN KEY (`editorial_id_editorial`) REFERENCES `editorial` (`id_editorial`), "
                + "FOREIGN KEY (`categoria_id_categoria`) REFERENCES `categoria` (`id_categoria`));";
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

        // Inserta libros
        db.execSQL("INSERT INTO libro (isbn, titulo, subtitulo, descripcion, comentarios, autor_id_autor, idioma_id_idioma, formato_id_formato, editorial_id_editorial, categoria_id_categoria) VALUES ('9781234567890', 'Título del libro de Gabriel Martínez', 'Subtítulo del libro', 'Descripción del libro escrito por Gabriel Martínez', 'Comentarios sobre el libro de este autor', 1, 2, 3, 4, 5);");
        db.execSQL("INSERT INTO libro (isbn, titulo, subtitulo, descripcion, comentarios, autor_id_autor, idioma_id_idioma, formato_id_formato, editorial_id_editorial, categoria_id_categoria) VALUES ('9782345678901', 'Título del libro de Amelia Valdez', 'Subtítulo del libro', 'Descripción del libro escrito por Amelia Valdez', 'Comentarios sobre el libro de este autor', 2, 1, 3, 5, 4);");
        db.execSQL("INSERT INTO libro (isbn, titulo, subtitulo, descripcion, comentarios, autor_id_autor, idioma_id_idioma, formato_id_formato, editorial_id_editorial, categoria_id_categoria) VALUES ('9783456789012', 'Título del libro de Enrique Soto', 'Subtítulo del libro', 'Descripción del libro escrito por Enrique Soto', 'Comentarios sobre el libro de este autor', 3, 2, 3, 2, 5);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        // Método para gestionar actualizaciones de la base de datos
    }

    // Registro
    public void createUser(Context context, String nombre, String apellido, String password, String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Verificamos si el email ya existe
        if (isEmailRegistered(email)) {
            Toast.makeText(context, "Error, el correo electrónico ya está registrado", Toast.LENGTH_SHORT).show();
            return;
        }

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
    public boolean addToWishlist(Context context, int wishlistId, int libroId) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("wishlist_id_wishlist", getWishlist(getLoggedUserId()));
        contentValues.put("libro_id_libro", libroId); // libroId lo tengo q traer con un intent
        long result = db.insert("elementos_wishlist", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Metodo auxiliar para obtener la fecha actual
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    // Obtener todos los libros de la DB

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

                BookClass book = new BookClass(id, isbn, title, subtitle, description, comments, authorId, languageId, formatId, editorialId, categoryId);

                books.add(book);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return books;
    }

}

