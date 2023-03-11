package com.example.carwash;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserFragment extends Fragment {

    private TextView historyView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        historyView = getView().findViewById(R.id.historyText);

        try{
            SQLiteDatabase checkDB = null;
            checkDB = SQLiteDatabase.openDatabase("/data/data/com.example.carwash/databases/washsos", null, SQLiteDatabase.OPEN_READONLY);

            historyView.setText(MainActivity.dbHandler.loadHandler());
        }catch(
                SQLiteException e){
            historyView.setText("");
        }
    }
}