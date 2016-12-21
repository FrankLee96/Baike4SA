package com.ar.lee.baikeapplication.network;

import com.ar.lee.baikeapplication.network.httpstack.OkHttpStack;

/**
 * Created by Lee on 2016/11/27.
 */

public class HttpController {

    public static RequestQueue createNewRequestQueue() {
        RequestQueue newQueue = new RequestQueue(new OkHttpStack());
        newQueue.start();
        return newQueue;
    }
}
