package com.example.libreria_in_47_app.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.libreria_in_47_app.DataBaseSQLiteHelper;
import com.example.libreria_in_47_app.R;

public class RegisterActivity extends AppCompatActivity {

    DataBaseSQLiteHelper dbHelper;

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText repeatPasswordEditText;
    private TextView alreadyRegisteredTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DataBaseSQLiteHelper(this);

        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        repeatPasswordEditText = findViewById(R.id.repeatPasswordEditText);
        alreadyRegisteredTextView = findViewById(R.id.alreadyRegisteredTextView);

        alreadyRegisteredTextView.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(v -> {
            if (areFieldsValid()) {
                String firstName = firstNameEditText.getText().toString().trim();
                String lastName = lastNameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Guardado en la base de datos
                dbHelper.createUser(this, firstName, lastName, password, email);

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean areFieldsValid() {
        String firstName = firstNameEditText.getText().toString().trim();
        String lastName = lastNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String repeatPassword = repeatPasswordEditText.getText().toString().trim();

        if (firstName.length() < 3 || lastName.length() < 3) {
            showToast("El nombre y el apellido deben tener al menos 3 letras.");
            return false;
        }

        if (email.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            showToast("Por favor, rellena todos los campos.");
            return false;
        }

        if (!isValidEmail(email)) {
            showToast("Por favor, ingresa un correo electrónico válido.");
            return false;
        }

        if (!password.equals(repeatPassword)) {
            showToast("Las contraseñas no coinciden.");
            return false;
        }

        if (password.length() < 6) {
            showToast("La contraseña debe tener al menos 6 caracteres.");
            return false;
        }

        if (dbHelper.isEmailRegistered(email)) {
            showToast("Este correo electrónico ya está registrado.");
            return false;
        }

        return true;
    }

    private boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    private void showToast(String message) {
        Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
