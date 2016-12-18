package com.ar.lee.baikeapplication.mainsearch;

import android.support.annotation.NonNull;

/**
 * Created by Lee on 2016/12/17.
 */

public class MainSearchPresenter implements MainSearchContract.Presenter{

    private MainSearchContract.View mMainSerachView;

    public MainSearchPresenter(@NonNull MainSearchContract.View view){
        this.mMainSerachView = view;

        view.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
