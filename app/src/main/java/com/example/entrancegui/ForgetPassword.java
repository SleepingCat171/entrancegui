package com.example.entrancegui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPassword extends AppCompatActivity {

    private EditText editTextEmailReset;
    private Button buttonResetPassword;
    private TextView textViewBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        // Initialize UI elements
        editTextEmailReset = findViewById(R.id.editTextEmailReset);
        buttonResetPassword = findViewById(R.id.buttonResetPassword);
        textViewBackToLogin = findViewById(R.id.textViewBackToLogin);

        // Setup click listeners
        setupClickListeners();
    }

    private void setupClickListeners() {
        buttonResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });

        textViewBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go back to login activity
                finish();
            }
        });
    }

    private void resetPassword() {
        String email = editTextEmailReset.getText().toString().trim();

        // Validate email
        if (email.isEmpty()) {
            editTextEmailReset.setError("Email is required");
            editTextEmailReset.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmailReset.setError("Please enter a valid email");
            editTextEmailReset.requestFocus();
            return;
        }

        // In a real app, you would send a password reset email
        // For now, we'll just show a toast
        Toast.makeText(this, "Password reset email sent to " + email, Toast.LENGTH_SHORT).show();

        // Go back to login activity after a short delay
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 2000); // 2 seconds delay
    }
}