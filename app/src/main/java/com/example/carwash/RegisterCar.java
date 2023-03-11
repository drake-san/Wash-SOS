package com.example.carwash;

import static com.example.carwash.MainActivity.dbHandler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class RegisterCar extends AppCompatActivity {

    EditText userName, userSurname, carBrand, carModel;
    Button registerButton;
    UserCar userCar;
    String service;

    Runnable runnable;
    public static ArrayList<UserCar> userCars = new ArrayList<UserCar>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_car);

        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            service = extras.getString("Service");
        }
        else {
            service = (String) savedInstanceState.getSerializable("Service");
        }

        initComponents();
        registerCar();
    }

    public void initComponents() {
        userName = findViewById(R.id.nameEditText);
        userSurname = findViewById(R.id.surnameEditText);
        carBrand = findViewById((R.id.markEditText));
        carModel = findViewById(R.id.brandEditText);
        registerButton = findViewById(R.id.registerButton);
    }

    public void registerCar() {
        if(userName.getText().toString().isEmpty() && carBrand.getText().toString().isEmpty()) {

            registerButton.setOnClickListener(view -> {

                userCar = new UserCar(userName.getText().toString(),userSurname.getText().toString(), carBrand.getText().toString(), carModel.getText().toString(),service );

                if(userCar.getUserName().isEmpty() || userCar.getUserCarBrand().isEmpty())
                    Toast.makeText(this, "Votre nom et la marque de votre voiture ne peuvent pas etre vides",Toast.LENGTH_SHORT).show();
                else {
                    userCars.add(userCar);
                    switch (service) {
                        case "Simple":
                            dbHandler.addService(userCar.getUserName(), userCar.getUserCarBrand(), service, 500);
                            break;
                        case "Classique":
                            dbHandler.addService(userCar.getUserName(), userCar.getUserCarBrand(), service, 1000);
                            break;
                        case "Complet":
                            dbHandler.addService(userCar.getUserName(), userCar.getUserCarBrand(), service, 2000);
                            break;
                        case "Plus ultra":
                            dbHandler.addService(userCar.getUserName(), userCar.getUserCarBrand(), service, 5000);
                            break;
                    }
                    Toast.makeText(this, "Votre voiture a bien ete enregistree",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}