package com.ar.lee.baikeapplication.entrycomment;

/**
 * Created by Lee on 2016/12/19.
 */

public class EntryCommentPresenter implements EntryCommentContract.Presenter{

    private EntryCommentContract.View mEntryCommentView;

    public EntryCommentPresenter(EntryCommentContract.View view){
        this.mEntryCommentView = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

}
