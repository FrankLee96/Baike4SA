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

    String MULTIPART_FROM_DATA = "multipart/form-data";

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
        //TODO: 根据词条ID从服务器加载词条信息\
        final MultipartRequest request = new MultipartRequest("http://192.168.199.143:54865/User/register/",
                new RequestCompleteListener<String>() {
                    @Override
                    public void onComplete(int stateCode, String response, String errMsg) {
                        Log.d("test", response);
                    }
                });
        Map<String, String> map = request.getHeaders();
        map.put("connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", MULTIPART_FROM_DATA
                + "; boundary=" + request.getMultiPartEntity().getBoundary());

        MultipartEntity multipartEntity = request.getMultiPartEntity();
        multipartEntity.addStringPart("account", "ll456465");
        multipartEntity.addStringPart("password", "123456485");
        BaikeApplication.getRequestQueue().addRequest(request);

        mEntryDetailView.showEntryInf(new Entry(Entry.NO_ID_WHEN_CREATE,
                "测试词条名", "测试词条描述", Entry.NO_IMAGE_PATH));
    }
}
