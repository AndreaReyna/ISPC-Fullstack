package com.example.libreria_in_47_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.libreria_in_47_app.R;

public class ContactActivity extends AppCompatActivity {

    ImageView ivRegresar;
    private TextView AboutusTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Button contactsendbutton = findViewById(R.id.contactsendbutton);
        contactsendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Mensaje enviado", Toast.LENGTH_LONG).show();
            }
        });

        AboutusTextView = findViewById(R.id.AboutusTextView);
        AboutusTextView.setOnClickListener(v -> {
            Intent intent = new Intent(ContactActivity.this, AboutUsActivity.class);
            startActivity(intent);
        });

        ivRegresar = findViewById(R.id.ivRegresar);
        ivRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ContactActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}