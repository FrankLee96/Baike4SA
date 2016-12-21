package com.ar.lee.baikeapplication.loginAndRegister;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ar.lee.baikeapplication.R;

/**
 * Created by jeffdeen on 2016/12/19.
 */

public class LoginRegisterFragment extends Fragment implements LoginAndRegisterContract.View{
    private TextView username_tv;
    private TextView password_tv;
    private Button login;
    private Button register;
    private LoginAndRegisterContract.Presenter presenter;
    private Context context;

    @Override
    public void setPresenter(LoginAndRegisterContract.Presenter presenter) {
        this.presenter = presenter;
    }
    public static LoginRegisterFragment newInstance(){
        LoginRegisterFragment fragment = new LoginRegisterFragment();
        return fragment;
    }
    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_login_register, container, false);
        username_tv = (TextView)fragment.findViewById(R.id.username);
        password_tv = (TextView)fragment.findViewById(R.id.password);
        login = (Button)fragment.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });
        register = (Button)fragment.findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.register();
            }
        });
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public String getUsername() {
        return username_tv.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return password_tv.getText().toString().trim();
    }

    @Override
    public void loginSuccess() {
        //TODO
        Snackbar.make(login,"login success",Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void loginFailure() {
        //TODO

    }

    @Override
    public void registerSuccess() {
        //TODO
        Snackbar.make(login,"register success",Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void registerFailure() {
        //TODO
    }
}
