package com.ar.lee.baikeapplication.network.request;

import android.util.Log;

import com.ar.lee.baikeapplication.network.Request;
import com.ar.lee.baikeapplication.network.Response;
import com.ar.lee.baikeapplication.network.entity.BigMultipartEntity;
import com.ar.lee.baikeapplication.network.listener.RequestCompleteListener;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Lee on 2016/11/27.
 */

public class BigMultipartRequest extends Request<String> {

    BigMultipartEntity bigMultipartEntity = new BigMultipartEntity();

    public BigMultipartRequest(String url, RequestCompleteListener<String> listener){
        super(HttpMethod.GET, url, listener);
    }

    public BigMultipartEntity getBigMultipartEntity(){
        return bigMultipartEntity;
    }

    @Override
    public String getBodyContentType() {
        return bigMultipartEntity.getContentType().getValue();
    }

    @Override
    public String parseResponse(Response response) {
        if (response == null)
            return "null!";
        return new String(response.getRawData());
    }

    @Override
    public byte[] getBody() {
        throw new RuntimeException("BigMultipartRequest should not call this!");
    }

    public void writeBody(OutputStream outputStream){
        try {
            bigMultipartEntity.writeTo(outputStream);
        } catch (IOException e){
            e.printStackTrace();
            Log.e("", "BigMultipartEntity writing exception!");
        }
    }
}
