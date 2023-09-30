package com.example.libreria_in_47_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {


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







    }
}