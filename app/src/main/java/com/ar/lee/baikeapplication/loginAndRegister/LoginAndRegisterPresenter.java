package com.ar.lee.baikeapplication.loginAndRegister;


import android.content.Context;
import android.content.SharedPreferences;

import com.ar.lee.baikeapplication.data.source.EntryDataSource;
import com.ar.lee.baikeapplication.data.source.EntryRepository;

/**
 * Created by jeffdeen on 2016/12/19.
 */

public class LoginAndRegisterPresenter implements LoginAndRegisterContract.Presenter{
    private LoginAndRegisterContract.View fragment;
    String MULTIPART_FROM_DATA = "multipart/form-data";
    public LoginAndRegisterPresenter(LoginRegisterFragment fragment){
        this.fragment = fragment;
        fragment.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void login() {
        fragment.showDialog("登录中...");
        String username = fragment.getUsername();
        String password = fragment.getPassword();
        EntryRepository.getInstance().login(username,password,new EntryDataSource.LoginCallback(){
            @Override
            public void loginSuccess(String username,String userID) {
                SharedPreferences preferences=fragment.getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("username", username);
                editor.putString("userID", userID);
                editor.apply();
                fragment.hideDialog();
                fragment.loginSuccess();
            }

            @Override
            public void loginFailure(String code) {
                fragment.hideDialog();
                fragment.loginFailure(code);
            }
        });

    }

    @Override
    public void register() {
        fragment.showDialog("注册中...");
        final String username = fragment.getUsername();
        final String password = fragment.getPassword();

        EntryRepository.getInstance().register(username,password,new EntryDataSource.RegisterCallback(){
            @Override
            public void registerSuccess(String username,String userID) {
                SharedPreferences preferences=fragment.getContext().getSharedPreferences("user", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("username", username);
                editor.putString("userID", userID);
                editor.apply();
                fragment.hideDialog();
                fragment.registerSuccess();
            }

            @Override
            public void registerFailure(String code) {
                fragment.hideDialog();
                fragment.registerFailure(code);
            }
        });
    }
}
