package com.ar.lee.baikeapplication.addentry;

/**
 * Created by Lee on 2016/12/18.
 */

public class AddEntryPresenter implements AddEntryContract.Presenter{

    private AddEntryContract.View mAddEntryView;

    public AddEntryPresenter(AddEntryContract.View view){
        this.mAddEntryView = view;

        view.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
