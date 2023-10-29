package com.example.libreria_in_47_app.activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.libreria_in_47_app.DataBaseSQLiteHelper;
import com.example.libreria_in_47_app.R;
import com.example.libreria_in_47_app.models.BookClass;
import com.example.libreria_in_47_app.models.UserClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements BookAdapter.OnItemClickListener, BookAdapter.OnRatingChangeListener {

    DataBaseSQLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciar un objeto de la clase DataBaseSQLiteHelper.
        dbHelper = new DataBaseSQLiteHelper(this);

        // Guardar la lista en una variable.
        List<BookClass> response = dbHelper.getAllBooks();

        // Configurar el RecyclerView y su adaptador
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        BookAdapter adapter = new BookAdapter(this, response);

        adapter.setOnItemClickListener(this); // Establecer el listener en MainActivity
        adapter.setOnRatingChangeListener(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Navegación.
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_inicio);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_inicio) {
                return true;
            } else if (item.getItemId() == R.id.bottom_deseos) {
                startActivity(new Intent(getApplicationContext(), WishlistActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                //finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_cotacto ) {
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

    @Override
    public void enviarLibro(BookClass book) {
        // Obtener el ID del libro.
        int bookId = book.getId();

        // Crear un Intent para abrir la actividad BookDetail.
        Intent intent = new Intent(this, BookDetail.class);

        // Pasar el ID del libro como extra en el Intent
        intent.putExtra("book_id", bookId);

        // Iniciar la actividad BookDetail
        startActivity(intent);
    }

    @Override
    public void onRatingChange(int bookId, float newRating) {
        dbHelper.rateBook(bookId, newRating);
    }
}