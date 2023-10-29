package com.example.libreria_in_47_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.libreria_in_47_app.DataBaseSQLiteHelper;
import com.example.libreria_in_47_app.R;
import com.example.libreria_in_47_app.models.UserClass;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EditUserActivity extends AppCompatActivity {

    Button btnCancelarActUser;
    Button btnActualizaUser;
    EditText txtEditNom, txtEditApe, txtEditEmail, txtEditDni, txtEditFecha_nac;
    UserClass user;
    DataBaseSQLiteHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        dbHelper = new DataBaseSQLiteHelper(this);
        txtEditNom = findViewById(R.id.txtEditNom);
        txtEditApe = findViewById(R.id.txtEditApe);
        txtEditEmail = findViewById(R.id.txtEditEmail);
        txtEditDni = findViewById(R.id.txtEditDni);
        txtEditFecha_nac = findViewById(R.id.txtEditFecha_nac);
        btnActualizaUser = findViewById(R.id.btnActualizaUser);
        btnCancelarActUser = findViewById(R.id.btnCancelarActUser);
        btnCancelarActUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditUserActivity.this, accountactivity.class);
                startActivity(intent);
            }
        });

        btnActualizaUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditUserActivity.this, "Datos actualizados", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditUserActivity.this, accountactivity.class);
                startActivity(intent);
            }
        });
        long userId = dbHelper.getLoggedUserId(this);
        user = dbHelper.getUserById(userId);

        txtEditNom.setText(user.getNombre());
        txtEditApe.setText(user.getApellido());
        txtEditEmail.setText(user.getEmail());
        txtEditDni.setText(user.getDni());
        txtEditFecha_nac.setText(user.getFecha_nac());

    }
}