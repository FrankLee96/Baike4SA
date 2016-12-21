package com.ar.lee.baikeapplication.loginAndRegister;

/**
 * Created by jeffdeen on 2016/12/19.
 */

public class LoginAndRegisterPresenter implements LoginAndRegisterContract.Presenter{
    private LoginAndRegisterContract.View fragment;
    public LoginAndRegisterPresenter(LoginRegisterFragment fragment){
        this.fragment = fragment;
        fragment.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void login() {
        String username = fragment.getUsername();
        String password = fragment.getPassword();
        fragment.loginSuccess();
    }

    @Override
    public void register() {
        String username = fragment.getUsername();
        String password = fragment.getPassword();
        fragment.registerSuccess();
    }
}
