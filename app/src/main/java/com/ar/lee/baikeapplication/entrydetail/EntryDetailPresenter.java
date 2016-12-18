package com.ar.lee.baikeapplication.entrydetail;

/**
 * Created by Lee on 2016/12/18.
 */

public class EntryDetailPresenter implements EntryDetailContract.Presenter{

    private EntryDetailContract.View mEntryDetailView;

    public EntryDetailPresenter(EntryDetailContract.View view){
        this.mEntryDetailView = view;

        view.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
