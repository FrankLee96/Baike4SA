package com.ar.lee.baikeapplication.network.httpstack;

import com.ar.lee.baikeapplication.network.Request;
import com.ar.lee.baikeapplication.network.Response;

/**
 * Created by Lee on 2016/11/27.
 */

public interface HttpStack {
    public Response performRequest(Request<?> request);
}
