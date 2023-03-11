package com.example.carwash;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    CardView c1, c2, c3, c4;
    Intent intent;
    String service = null;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        intent = new Intent(getView().getContext(), RegisterCar.class);

        c1 = getView().findViewById(R.id.cardView1);
        c2 = getView().findViewById(R.id.cardView2);
        c3 = getView().findViewById(R.id.cardView3);
        c4 = getView().findViewById(R.id.cardView4);

        onOfferClick(c1, "Simple");
        onOfferClick(c2, "Classique");
        onOfferClick(c3, "Complet");
        onOfferClick(c4, "Plus ultra");

    }

    public void onOfferClick(CardView c, String s) {
        c.setOnClickListener(view -> {
            service = s;
            intent.putExtra("Service", service);
            startActivity(intent);
        });
    }
}