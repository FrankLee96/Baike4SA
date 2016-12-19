package com.ar.lee.baikeapplication.addentry;

import com.ar.lee.baikeapplication.data.Entry;

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
    public void uploadEntry(Entry newEntry) {
        //TODO: upload the entry to net
        mAddEntryView.returnToMeanSearch();
    }

    @Override
    public void start() {

    }
}
