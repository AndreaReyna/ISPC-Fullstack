package com.example.libreria_in_47_app.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.example.libreria_in_47_app.R;
import android.view.View;
import android.widget.Button;

public class EditUserActivity extends AppCompatActivity {

    Button btnCancelarActUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        btnCancelarActUser = findViewById(R.id.btnCancelarActUser);
        btnCancelarActUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditUserActivity.this, accountactivity.class);
                startActivity(intent);
            }
        });

    }
}