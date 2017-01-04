package com.ar.lee.baikeapplication.entrydetail;

import android.util.Log;

import com.ar.lee.baikeapplication.BaikeApplication;
import com.ar.lee.baikeapplication.data.Entry;
import com.ar.lee.baikeapplication.network.Request;
import com.ar.lee.baikeapplication.network.entity.MultipartEntity;
import com.ar.lee.baikeapplication.network.listener.RequestCompleteListener;
import com.ar.lee.baikeapplication.network.request.MultipartRequest;
import com.ar.lee.baikeapplication.network.request.StringRequest;

import java.util.Map;

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
        loadEntryToShow("测试ID");
    }

    @Override
    public void loadEntryToShow(String entryID) {


        mEntryDetailView.showEntryInf(new Entry(Entry.NO_ID_WHEN_CREATE,
                "测试词条名", "测试词条描述", Entry.NO_IMAGE_PATH));
    }
}
