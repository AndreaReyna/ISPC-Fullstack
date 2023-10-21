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
        btnBookAddWish.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       boolean isAdded = dbHelper.addToWishlist(1); // pasarle como arg el ID del libro
                        if (isAdded = true) {
                            Toast.makeText(BookDetail.this, "Libro agregado", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(BookDetail.this, "Error al agregar Libro", Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );

    }
}