package com.example.myapplication.login.view;

public interface ILoginView {
    void onClearText();
    void onLoginResult(Boolean result, int code);
    void onSetProgressBarVisibility(int visibility);
}