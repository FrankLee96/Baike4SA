package com.ar.lee.baikeapplication.loginAndRegister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ar.lee.baikeapplication.R;
import com.ar.lee.baikeapplication.util.ActivityUtils;

public class LoginAndRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        LoginRegisterFragment loginRegisterFragment = (LoginRegisterFragment)
                getSupportFragmentManager().findFragmentById(R.id.content_login_register);
        if (loginRegisterFragment == null){
            loginRegisterFragment = LoginRegisterFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    loginRegisterFragment, R.id.content_login_register);
        }
        LoginAndRegisterPresenter presenter = new LoginAndRegisterPresenter(loginRegisterFragment);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
