package com.example.libreria_in_47_app;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Abrimos la base de datos en modo escritura
        DataBaseSQLiteHelper prdbh =
                new DataBaseSQLiteHelper(this);
        SQLiteDatabase db = prdbh.getWritableDatabase();
//Si hemos abierto correctamente la base de datos
        if(db != null)
        {
//Insertamos 1 libro de ejemplo
            db.execSQL("INSERT INTO libro (isbn, titulo, subtitulo, descripcion, comentarios, precio, autor_id_autor, idioma_id_idioma, formato_id_formato, editorial_id_editorial, categoria_id_categoria) VALUES (1234567890, 'Título del libro', 'Subtítulo del libro', 'Descripción del libro', 'Comentarios del libro', 29.99, 1, 2, 3, 4, 5);");
        }
//Cerramos la base de datos
        db.close();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_inicio);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_inicio) {
                return true;
            } else if (item.getItemId() == R.id.bottom_deseos) {
                startActivity(new Intent(getApplicationContext(), BookDetail.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                //finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_compartir) {
                startActivity(new Intent(getApplicationContext(), ContactActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                //finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_perfil) {
                startActivity(new Intent(getApplicationContext(), accountactivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                //finish();
                return true;
            }
            return false;
        });
    }
}