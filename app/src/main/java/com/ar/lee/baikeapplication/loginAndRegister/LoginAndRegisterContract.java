package com.ar.lee.baikeapplication.loginAndRegister;

import com.ar.lee.baikeapplication.BasePresenter;
import com.ar.lee.baikeapplication.BaseView;

/**
 * Created by jeffdeen on 2016/12/19.
 */

public interface LoginAndRegisterContract {

    interface View extends BaseView<Presenter> {
        String getUsername();
        String getPassword();

    }

    interface Presenter extends BasePresenter {
        void login();
        void register();
    }
}