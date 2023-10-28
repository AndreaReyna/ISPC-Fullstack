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
import com.example.libreria_in_47_app.models.UserClass;
import android.content.SharedPreferences;

public class accountactivity extends AppCompatActivity {
    ImageView ivRegresar;
    Button btnCerrarSesion;
    Button button;
    TextView txtAcouNom;

    UserClass user;

    DataBaseSQLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountactivity);
        ivRegresar = findViewById(R.id.ivRegresar);
        txtAcouNom = findViewById(R.id.txtAcouNom);
        TextView TextView5 = findViewById(R.id.textView5);
        ivRegresar.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(accountactivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        btnCerrarSesion=findViewById(R.id.btnCerrarSesion);
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(accountactivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(accountactivity.this, EditUserActivity.class);
                startActivity(intent);
            }
        });

        user = new UserClass();
        long userId = dbHelper.getLoggedUserId(this);

        if (userId != -1) {
            user = dbHelper.getUserById(userId);
            // Actualizar las vistas con los detalles del usuario
            txtAcouNom.setText(user.getNombre());

        } else {
            // Manejar el caso en el que no se haya encontrado el ID del usuario
            Toast.makeText(this, "usuario no encontrado", Toast.LENGTH_SHORT).show();
        }

    }

}