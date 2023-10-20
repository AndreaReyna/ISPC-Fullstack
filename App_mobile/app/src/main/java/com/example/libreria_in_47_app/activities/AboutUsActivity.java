package com.example.libreria_in_47_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.libreria_in_47_app.R;

<<<<<<<< HEAD:App_mobile/app/src/main/java/com/example/libreria_in_47_app/activities/AboutUsActivity.java
<<<<<<<< HEAD:App_mobile/app/src/main/java/com/example/libreria_in_47_app/activities/AboutUsActivity.java
import com.example.libreria_in_47_app.R;

public class AboutUsActivity extends AppCompatActivity {

========
========
>>>>>>>> 8b78748 (acivities folder created, project restructuring):App_mobile/app/src/main/java/com/example/libreria_in_47_app/activities/BookDetail.java
public class BookDetail extends AppCompatActivity {
>>>>>>>> 8b78748 (acivities folder created, project restructuring):App_mobile/app/src/main/java/com/example/libreria_in_47_app/activities/BookDetail.java
    ImageView ivRegresar;
    private DataBaseSQLiteHelper dbHelper;

    private Button bookAddWish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        dbHelper = new DataBaseSQLiteHelper(this);

        bookAddWish = (Button)findViewById(R.id.bookAddWish); //boton para agregar libro a lista
        ivRegresar = findViewById(R.id.ivRegresar);
        ivRegresar.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(AboutUsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}