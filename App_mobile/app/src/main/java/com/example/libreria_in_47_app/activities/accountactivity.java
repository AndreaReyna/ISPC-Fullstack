package com.example.libreria_in_47_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.libreria_in_47_app.DataBaseSQLiteHelper;
import com.example.libreria_in_47_app.R;
import com.example.libreria_in_47_app.models.UserClass;

public class accountactivity extends AppCompatActivity {
    ImageView ivRegresar;
    Button btnCerrarSesion;
    Button button, buttonDelete;
    TextView txtAcouNom, txtAcouApe, txtAcouEmail, txtAcouTelefono, txtAcouTitulo;

    UserClass user;

    DataBaseSQLiteHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountactivity);
        dbHelper = new DataBaseSQLiteHelper(this);
        ivRegresar = findViewById(R.id.ivRegresar);
        txtAcouNom = findViewById(R.id.txtAcouNom);
        txtAcouApe = findViewById(R.id.txtAcouApe);
        txtAcouEmail = findViewById(R.id.txtAcouEmail);
        txtAcouTelefono = findViewById(R.id.txtAcouTelefono);
        txtAcouTitulo = findViewById(R.id.txtAcouTitulo);

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

        button = findViewById(R.id.buttonDelete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dbHelper.deleteUser(user.getIdUser());
                Intent intent = new Intent(accountactivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        long userId = dbHelper.getLoggedUserId(this);
        user = dbHelper.getUserById(userId);

        txtAcouNom.setText(user.getNombre());
        txtAcouApe.setText(user.getApellido());
        txtAcouEmail.setText(user.getEmail());
        txtAcouTelefono.setText(user.getTelefono());
        txtAcouTitulo.setText("Hola " + user.getNombre());

    }
}