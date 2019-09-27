package com.example.myapplication.login.model;

public interface IUser {
    String getName();

    String getPasswd();

    int checkUserValidity(String name, String passwd);
}