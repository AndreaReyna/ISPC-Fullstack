package com.example.libreria_in_47_app;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.example.libreria_in_47_app.models.BookClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DataBaseSQLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciar un objeto de la clase DataBaseSQLiteHelper.
        dbHelper = new DataBaseSQLiteHelper(this);

        // Guardar la lista en una variable.
        List<BookClass> response = dbHelper.getAllBooks();

        // Interar la lista para tomar la data de cada libro y mostrarlo en consola.
        for (BookClass book : response) {
            System.out.println("ID: " + book.getId());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Título: " + book.getTitulo());
            System.out.println("Subtítulo: " + book.getSubtitulo());
            System.out.println("Descripción: " + book.getDescripcion());
            System.out.println("Comentarios: " + book.getComentarios());
            System.out.println("Autor ID: " + book.getAutorId());
            System.out.println("Idioma ID: " + book.getIdiomaId());
            System.out.println("Formato ID: " + book.getFormatoId());
            System.out.println("Editorial ID: " + book.getEditorialId());
            System.out.println("Categoría ID: " + book.getCategoriaId());
        }

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