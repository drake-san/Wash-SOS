package com.example.carwash;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    public static DBHandler dbHandler;

    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHandler = new DBHandler(MainActivity.this);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(RegisterCar.userCars.size() > 0) {
            sendNotification();
        }
    }

    HomeFragment homeFragment = new HomeFragment();
    CarFragment carFragment = new CarFragment();

    UserFragment userFragment = new UserFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                return true;

            case R.id.car:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, carFragment).commit();
                return true;

            case R.id.user:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, userFragment).commit();
                return true;
        }

        return false;
    }

    public void sendNotification() {
        int carIndex = new Random().nextInt(RegisterCar.userCars.size());
        int randomNum = new Random().nextInt((20000 - 10000) + 1) + 10000;
        runnable = () -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Wash OK")
                    .setMessage("Le nettoyage de votre " + RegisterCar.userCars.get(carIndex).getUserCarBrand() + " est termine")
                    .setNeutralButton("OK", (dialogInterface, i) -> {
                    })
                    .show();
            RegisterCar.userCars.remove(carIndex);
        };
        new Handler().postDelayed(runnable, randomNum);

    }
}