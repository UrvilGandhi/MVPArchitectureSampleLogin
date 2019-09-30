package com.example.myapplication.login.model;

public class UserModel implements IUser {
    String name;
    String password;

    public UserModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int checkUserValidity(String name, String password) {
        if (name == null || password == null || !name.equals(getName()) || !password.equals(getPassword())) {
            return -1;
        }
        return 0;
    }
}