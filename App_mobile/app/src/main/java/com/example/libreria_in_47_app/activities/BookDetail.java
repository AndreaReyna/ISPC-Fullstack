package com.example.libreria_in_47_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.libreria_in_47_app.R;

public class BookDetail extends AppCompatActivity {
    ImageView ivRegresar;
    private DataBaseSQLiteHelper dbHelper;

    private Button bookAddWish;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        dbHelper = new DataBaseSQLiteHelper(this);

        bookAddWish = (Button)findViewById(R.id.bookAddWish); //boton para agregar libro a lista

        ivRegresar = findViewById(R.id.ivRegresar);
        ivRegresar.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(BookDetail.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}