package com.example.carwash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class SignUp extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private EditText mail;
    private TextView others;
    private MaterialButton loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initComponents();
        createAccount();
        account();
    }

    private void initComponents() {
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        mail = findViewById(R.id.mail);
        others = findViewById(R.id.others);
        loginBtn = findViewById(R.id.loginbtn);
    }

    private void createAccount() {
        loginBtn.setOnClickListener(view -> {
            if(mail.getText().toString().isEmpty() && userName.getText().toString().isEmpty() && password.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Veuillez renseignez toutes vos informations", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);
            }
        });
    }

    private void account() {
        others.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SignIn.class);
            startActivity(intent);
        });
    }
}