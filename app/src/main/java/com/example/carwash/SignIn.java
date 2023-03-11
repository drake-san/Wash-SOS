package com.example.carwash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class SignIn extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private TextView others;
    private MaterialButton loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initComponents();
        login();
        account();
    }

    private void initComponents() {
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        others = findViewById(R.id.others);
        loginBtn = findViewById(R.id.loginbtn);
    }

    private void login() {
        loginBtn.setOnClickListener(view -> {
            if(!userName.getText().toString().equals("admin") || !password.getText().toString().equals("admin")) {
                Toast.makeText(getApplicationContext(), "Informations incorrectes", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void account() {
        others.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SignUp.class);
            startActivity(intent);
        });
    }
}