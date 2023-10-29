package com.example.libreria_in_47_app.activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.libreria_in_47_app.DataBaseSQLiteHelper;
import com.example.libreria_in_47_app.R;
import com.example.libreria_in_47_app.models.BookClass;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class WishlistActivity extends AppCompatActivity implements WishlistAdapter.OnItemClickListener {

    DataBaseSQLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        // Instanciar un objeto de la clase DataBaseSQLiteHelper.
        dbHelper = new DataBaseSQLiteHelper(this);

        // Recuperar id de usuario logueado.
        long userId = dbHelper.getLoggedUserId(this);

        // Guardar la lista en una variable.
        List<BookClass> response = dbHelper.getBooksInWishlist(userId);

        // Configurar el RecyclerView y su adaptador
        RecyclerView recyclerViewW = findViewById(R.id.recyclerViewW);
        WishlistAdapter adapterW = new WishlistAdapter(this, response);
        adapterW.setOnItemClickListener(this); // Establecer el listener en WishlistActivity
        recyclerViewW.setAdapter(adapterW);
        recyclerViewW.setLayoutManager(new LinearLayoutManager(this));

        // Navegación.
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
            bottomNavigationView.setSelectedItemId(R.id.bottom_deseos);
            bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_deseos) {
                return true;
            } else if (item.getItemId() == R.id.bottom_inicio) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(R.anim.slide_out_left,R.anim.slide_in_right);
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
}