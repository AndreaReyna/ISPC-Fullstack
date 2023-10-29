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

public class LoginActivity extends AppCompatActivity {

    private DataBaseSQLiteHelper dbHelper;

    private EditText emailEditText;
    private EditText passwordEditText;
    private TextView registerTextView;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DataBaseSQLiteHelper(this);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        registerTextView = findViewById(R.id.registerTextView);
        loginButton = findViewById(R.id.loginButton);

        registerTextView.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });

        loginButton.setOnClickListener(v -> {
            if (areLoginFieldsValid()) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean areLoginFieldsValid() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty()) {
            showToast("Por favor, ingresa tu correo electrónico.");
            return false;
        }

        if (!isValidEmail(email)) {
            showToast("Por favor, ingresa un correo electrónico válido.");
            return false;
        }

        if (password.isEmpty()) {
            showToast("Por favor, ingresa tu contraseña.");
            return false;
        }

        // Validación con la base de datos
        if (!dbHelper.validateUserCredentials(this, email, password)) {
            showToast("Error, verifique los datos de inicio de sesión y vuelva a intentarlo");
            return false;
        }

        return true;
    }

    private void showToast(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}