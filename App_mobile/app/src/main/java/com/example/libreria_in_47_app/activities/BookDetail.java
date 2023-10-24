package com.example.libreria_in_47_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.libreria_in_47_app.DataBaseSQLiteHelper;
import com.example.libreria_in_47_app.R;
import com.example.libreria_in_47_app.models.BookClass;

import java.util.List;

public class BookDetail extends AppCompatActivity {
    ImageView ivRegresar;
    DataBaseSQLiteHelper dbHelper;

    private Button btnBookAddWish;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        dbHelper = new DataBaseSQLiteHelper(this);

        btnBookAddWish = (Button)findViewById(R.id.bookAddWish); //boton para agregar libro a lista
        AddBook();

        ivRegresar = findViewById(R.id.ivRegresar);
        ivRegresar.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(BookDetail.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void AddBook() {
        long userId = dbHelper.getLoggedUserId(this);
        long wishlistId = dbHelper.getWishlist(userId);
        long libroId = 1; //esto se borra es para prueba.

        BookClass libroElegido = dbHelper.getBookById(1); // pasarle el ID del libro
        List<Integer> librosEnWishlist = dbHelper.getBooksInWishlist(userId);

        btnBookAddWish.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (!librosEnWishlist.contains(libroElegido.getId())) {
                            // El libro no está en la wishlist, así que podemos agregarlo
                            boolean isAdded = dbHelper.addToWishlist(wishlistId, libroElegido.getId()); // pasarle como arg el ID del libro
                            if (isAdded) {
                                Toast.makeText(BookDetail.this, "Libro agregado", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(BookDetail.this, "Error al agregar Libro", Toast.LENGTH_LONG).show();
                            }

                        } else {
                            // El libro ya está en la wishlist
                            Toast.makeText(BookDetail.this, "El libro ya se encuentra en tu lista", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                }

    };