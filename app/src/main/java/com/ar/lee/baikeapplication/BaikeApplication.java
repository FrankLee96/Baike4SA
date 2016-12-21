package com.ar.lee.baikeapplication;

import android.app.Application;

import com.ar.lee.baikeapplication.network.HttpController;
import com.ar.lee.baikeapplication.network.RequestQueue;

/**
 * Created by Lee on 2016/12/21.
 */

public class BaikeApplication extends Application{
    public static RequestQueue mQueue;
    @Override
    public void onCreate() {
        super.onCreate();

        mQueue = HttpController.createNewRequestQueue();
        mQueue.start();
    }

    // 开放Volley的HTTP请求队列接口
    public static RequestQueue getRequestQueue() {
        return mQueue;
    }
}
