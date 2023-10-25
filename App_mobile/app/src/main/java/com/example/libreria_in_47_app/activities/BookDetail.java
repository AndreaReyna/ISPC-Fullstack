package com.example.libreria_in_47_app.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.libreria_in_47_app.DataBaseSQLiteHelper;
import com.example.libreria_in_47_app.R;
import com.example.libreria_in_47_app.models.BookClass;

import java.util.List;

public class BookDetail extends AppCompatActivity {
    ImageView ivRegresar;
    TextView textTitle;
    TextView textDescription;
    Button btnBookAddWish;

    DataBaseSQLiteHelper dbHelper;
    BookClass book;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        dbHelper = new DataBaseSQLiteHelper(this);

        textTitle = findViewById(R.id.textTitle);
        textDescription = findViewById(R.id.textDescription);
        btnBookAddWish = findViewById(R.id.bookAddWish);

        ivRegresar = findViewById(R.id.ivRegresar);
        ivRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookDetail.this, MainActivity.class);
                startActivity(i);
            }
        });

        // Recuperar el ID del libro de la Intent
        int bookId = getIntent().getIntExtra("book_id", -1); // -1 es un valor predeterminado en caso de que no se encuentre el ID

        if (bookId != -1) {
            book = dbHelper.getBookById(bookId);

            // Actualizar las vistas con los detalles del libro
            textTitle.setText(book.getTitle());
            textDescription.setText(book.getDescription());


            // Agregar book a wishlist.
            btnBookAddWish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //
                }
            });
        } else {
            // Manejar el caso en el que no se haya encontrado el ID del libro
            Toast.makeText(this, "Libro no encontrado", Toast.LENGTH_SHORT).show();
        }
    }
}
