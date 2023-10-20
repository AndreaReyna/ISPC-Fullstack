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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountactivity);
        ivRegresar = findViewById(R.id.ivRegresar);
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

        long userId = getLoggedUserId(this);
        TextView TextView5 = findViewById(R.id.textView5);
        TextView nombreTextView = findViewById(R.id.txtAcouNom);
        TextView apellidoTextView = findViewById(R.id.txtAcouApe);
        TextView emailTextView = findViewById(R.id.txtAcouEmail);
        TextView passwordTextView = findViewById(R.id.txtAcouPass);

        // Verifica si se ha obtenido un ID válido antes de establecerlo en el TextView
        if (userId != -1) {
            // Convierte el ID en una cadena si es necesario
            String userIdStr = String.valueOf(userId);
            String nombre = String.valueOf(nombreTextView);
            //String apellido = getLoggedUserId(this, userId);
            //String email = getLoggedUserId(this, userId);
            //String password = getLoggedUserId(this, userId);

            // Establece el ID del usuario en el TextView
            TextView5.setText(userIdStr);
            nombreTextView.setText(nombre);
            //apellidoTextView.setText(apellido);
            //emailTextView.setText(email);
            //passwordTextView.setText(password);

        } else {
            // Maneja el caso en el que no se pudo obtener el ID del usuario
            TextView5.setText("No se pudo obtener el ID del usuario");
        }
    }

    public long getLoggedUserId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
        return sharedPreferences.getLong("userId", -1);  // Devuelve -1 si no se encuentra el ID del usuario
    }
}