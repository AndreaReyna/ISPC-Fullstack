package com.example.libreria_in_47_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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
                + "`direccion_id_direccion` INTEGER NOT NULL, "
                + "`fecha_creacion` DATE NOT NULL, "
                + "`fecha_modificacion` DATE, "
                + "FOREIGN KEY (`direccion_id_direccion`) REFERENCES `direccion` (`id_direccion`));";
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
                + "`isbn` INTEGER NOT NULL, "
                + "`titulo` TEXT NOT NULL, "
                + "`subtitulo` TEXT, "
                + "`descripcion` TEXT, "
                + "`comentarios` TEXT, "
                + "`precio` REAL NOT NULL, "
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

        // Crea la tabla "libro_has_detalles_orden"
        String createTableLibroDetallesOrden = "CREATE TABLE IF NOT EXISTS `libro_has_detalles_orden` ("
                + "`libro_id_libro` INTEGER NOT NULL, "
                + "`detalles_orden_id_orden` INTEGER NOT NULL, "
                + "PRIMARY KEY (`libro_id_libro`, `detalles_orden_id_orden`), "
                + "FOREIGN KEY (`libro_id_libro`) REFERENCES `libro` (`id_libro`));";
        db.execSQL(createTableLibroDetallesOrden);

        // Crea la tabla "elementos_wishlist"
        String createTableElementosWishlist = "CREATE TABLE IF NOT EXISTS `elementos_wishlist` ("
                + "`id_elementos_wishlist` INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "`wishlist_id_wishlist` INTEGER NOT NULL, "
                + "`libro_id_libro` INTEGER NOT NULL, "
                + "`cantidad` INTEGER, "
                + "FOREIGN KEY (`wishlist_id_wishlist`) REFERENCES `wishlist` (`id_wishlist`), "
                + "FOREIGN KEY (`libro_id_libro`) REFERENCES `libro` (`id_libro`));";
        db.execSQL(createTableElementosWishlist);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        // Método para gestionar actualizaciones de la base de datos
    }
}

