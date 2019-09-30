package com.example.myapplication.login.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.myapplication.login.model.IUser;
import com.example.myapplication.login.model.UserModel;
import com.example.myapplication.login.view.ILoginView;

public class LoginPresenterCompl implements ILoginPresenter {
    private ILoginView iLoginView;
    private IUser user;
    private Handler handler;

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        initUser();
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clear() {
        iLoginView.onClearText();
    }

    @Override
    public void doLogin(String name, String password) {
        boolean isLoginSuccess = true;
        final int code = user.checkUserValidity(name,password);
        if (code!=0) isLoginSuccess = false;
        final boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(result, code);
            }
        }, 5000);
    }

    @Override
    public void setProgressBarVisibility(int visibility){
        iLoginView.onSetProgressBarVisibility(visibility);
    }

    private void initUser(){
        user = new UserModel("mvp","mvp");
    }
}
