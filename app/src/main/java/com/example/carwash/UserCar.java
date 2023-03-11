package com.example.carwash;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UserCar {
    @NotNull
    private String userName;
    private String userSurname;
    @NotNull
    private String userCarBrand;
    private String userCarModel;

    @NotNull
    private String service;
    private int imgId;

    private String time;

    public UserCar(@NotNull String userName, String userSurname, @NotNull String userCarBrand, String userCarModel, String service) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.userCarBrand = userCarBrand;
        this.userCarModel = userCarModel;
        this.service = service;
    }

    @NotNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NotNull String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    @NotNull
    public String getUserCarBrand() {
        return userCarBrand;
    }

    public void setUserCarBrand(@NotNull String userCarBrand) {
        this.userCarBrand = userCarBrand;
    }

    public String getUserCarModel() {
        return userCarModel;
    }

    public void setUserCarModel(String userCarModel) {
        this.userCarModel = userCarModel;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @NotNull
    public String getService() {
        return service;
    }

    public void setService(@NotNull String service) {
        this.service = service;
    }
}
