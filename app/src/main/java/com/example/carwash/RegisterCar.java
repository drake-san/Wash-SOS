package com.example.carwash;

import static com.example.carwash.MainActivity.dbHandler;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

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