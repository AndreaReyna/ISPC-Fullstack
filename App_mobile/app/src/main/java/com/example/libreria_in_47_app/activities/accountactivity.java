package com.example.libreria_in_47_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.libreria_in_47_app.R;

public class accountactivity extends AppCompatActivity {
    ImageView ivRegresar;
    Button btnCerrarSesion;
    Button button;
<<<<<<< HEAD

=======
>>>>>>> 4cf2faffde0c675c14ba3ae3d757fccd8a14cfd7
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountactivity);
        ivRegresar = findViewById(R.id.ivRegresar);
        ivRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(accountactivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(accountactivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
<<<<<<< HEAD

=======
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(accountactivity.this, EditUserActivity.class);
                startActivity(intent);
            }
        });
>>>>>>> 4cf2faffde0c675c14ba3ae3d757fccd8a14cfd7
    }
}