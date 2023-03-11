package com.example.carwash;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder>{
        private ArrayList<UserCar> listdata;
        public CarAdapter(ArrayList<UserCar> listdata) {
            this.listdata = listdata;
        }

        public CarAdapter(UserCar data) {}
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View listItem= layoutInflater.inflate(R.layout.service_list, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final UserCar myListData = listdata.get(position);
            holder.userName.setText(listdata.get(position).getUserName());
            holder.carBrand.setText(listdata.get(position).getUserCarBrand());
            holder.carModel.setText(listdata.get(position).getUserCarModel());
            holder.service.setText(listdata.get(position).getService());
        }


        @Override
        public int getItemCount() {
            return listdata.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView service;
            public TextView userName;
            public TextView carBrand;
            public TextView carModel;
            public ConstraintLayout constraintLayout;
            public ViewHolder(View itemView) {
                super(itemView);
                this.service = itemView.findViewById(R.id.textView11);
                this.userName = itemView.findViewById(R.id.textView8);
                this.carBrand = itemView.findViewById(R.id.textView9);
                this.carModel = itemView.findViewById(R.id.textView10);
                constraintLayout = itemView.findViewById(R.id.constraintLayout);
            }
        }
    }
