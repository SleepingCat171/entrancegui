package com.example.entrancegui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private EditText editTextFullName, editTextEmailSignUp, editTextPasswordSignUp, editTextConfirmPassword;
    private Button buttonRegister;
    private TextView textViewLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize UI elements
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextEmailSignUp = findViewById(R.id.editTextEmailSignUp);
        editTextPasswordSignUp = findViewById(R.id.editTextPasswordSignUp);
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
        textViewLoginLink = findViewById(R.id.textViewLoginLink);

        // Setup click listeners
        setupClickListeners();
    }

    private void setupClickListeners() {
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        textViewLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to login activity
                finish();
            }
        });
    }

    private void registerUser() {
        String fullName = editTextFullName.getText().toString().trim();
        String email = editTextEmailSignUp.getText().toString().trim();
        String password = editTextPasswordSignUp.getText().toString().trim();
        String confirmPassword = editTextConfirmPassword.getText().toString().trim();

        // Validate inputs
        if (fullName.isEmpty()) {
            editTextFullName.setError("Full name is required");
            editTextFullName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editTextEmailSignUp.setError("Email is required");
            editTextEmailSignUp.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmailSignUp.setError("Please enter a valid email");
            editTextEmailSignUp.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPasswordSignUp.setError("Password is required");
            editTextPasswordSignUp.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPasswordSignUp.setError("Password should be at least 6 characters");
            editTextPasswordSignUp.requestFocus();
            return;
        }

        if (!password.equals(confirmPassword)) {
            editTextConfirmPassword.setError("Passwords do not match");
            editTextConfirmPassword.requestFocus();
            return;
        }

        // In a real app, you would register the user in a database or through an API
        // For now, we'll just show a toast and go back to the login screen
        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
        finish(); // Go back to login activity
    }
}