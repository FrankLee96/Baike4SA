package com.ar.lee.baikeapplication.data.source.remote;

import android.support.annotation.NonNull;
import android.util.Log;

import com.ar.lee.baikeapplication.BaikeApplication;
import com.ar.lee.baikeapplication.data.Entry;
import com.ar.lee.baikeapplication.data.EntryComment;
import com.ar.lee.baikeapplication.data.source.EntryDataSource;
import com.ar.lee.baikeapplication.network.Request;
import com.ar.lee.baikeapplication.network.entity.MultipartEntity;
import com.ar.lee.baikeapplication.network.listener.RequestCompleteListener;
import com.ar.lee.baikeapplication.network.request.MultipartRequest;
import com.ar.lee.baikeapplication.network.request.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lee on 2016/12/20.
 */

public class EntryRemoteDataSource implements EntryDataSource{

    private static EntryRemoteDataSource INSTANCE;
    private final String URL = "http://118.89.57.14:54866";

    public static EntryRemoteDataSource getInstance(){
        if (INSTANCE == null){
            INSTANCE = new EntryRemoteDataSource();
        }

        return INSTANCE;
    }

    @Override
    public void getEntry(@NonNull final String entryId, @NonNull final GetEntryCallback callback) {
        final MultipartRequest request = new MultipartRequest(URL+"/Item/get/",
                new RequestCompleteListener<String>() {
                    @Override
                    public void onComplete(int stateCode, String response, String errMsg) {
                        try {
                            JSONObject object = new JSONObject(response);
                            String err = object.getString("err");
                            if (err.equals("-1")){
                                callback.onDataNotAvailable();
                            } else {
                                callback.onEntryLoaded(new Entry(entryId,
                                        object.getString("title"), object.getString("text"), object.getString("imagePath")));
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                            throw new RuntimeException("JSONException");
                        }
                    }
                });
        Map<String, String> map = request.getHeaders();
        map.put("connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", "multipart/form-data"
                + "; boundary=" + request.getMultiPartEntity().getBoundary());

        MultipartEntity multipartEntity = request.getMultiPartEntity();
        multipartEntity.addStringPart("itemID", entryId);
        BaikeApplication.getRequestQueue().addRequest(request);
    }

    @Override
    public void addEntry(@NonNull Entry newEntry, @NonNull final AddEntryCallback callback) {
        final MultipartRequest request = new MultipartRequest(URL+"/Item/add/",
                new RequestCompleteListener<String>() {
                    @Override
                    public void onComplete(int stateCode, String response, String errMsg) {
                        try {
                            JSONObject object = new JSONObject(response);
                            String err = object.getString("err");
                            if (err.equals("-1")){
                                callback.addFailure(object.getString("msg"));
                            } else {
                                callback.addSuccess();
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                            throw new RuntimeException("JSONException");
                        }
                    }
                });
        Map<String, String> map = request.getHeaders();
        map.put("connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", "multipart/form-data"
                + "; boundary=" + request.getMultiPartEntity().getBoundary());

        MultipartEntity multipartEntity = request.getMultiPartEntity();
        multipartEntity.addStringPart("title", newEntry.getTitle());
        multipartEntity.addStringPart("text", newEntry.getDescription());
        multipartEntity.addStringPart("imagePath", newEntry.getImagePath());
        BaikeApplication.getRequestQueue().addRequest(request);
    }

    @Override
    public void uploadImage(@NonNull String imgPath, @NonNull final UploadImageCallback callback) {
        final MultipartRequest request = new MultipartRequest(URL+"/Image/add/",
                new RequestCompleteListener<String>() {
                    @Override
                    public void onComplete(int stateCode, String response, String errMsg) {
                        try {
                            JSONObject object = new JSONObject(response);
                            String err = object.getString("err");
                            if (err.equals("-1")){
                                callback.uploadFailure(object.getString("msg"));
                            } else {
                                callback.uploadSuccess(object.getString("path"));
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                            throw new RuntimeException("JSONException");
                        }
                    }
                });
        Map<String, String> map = request.getHeaders();
        map.put("connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", "multipart/form-data"
                + "; boundary=" + request.getMultiPartEntity().getBoundary());

        MultipartEntity multipartEntity = request.getMultiPartEntity();
        multipartEntity.addFilePart("file", new File(imgPath));
        BaikeApplication.getRequestQueue().addRequest(request);
    }

    @Override
    public void loadEntryComments(@NonNull String entryId, @NonNull final LoadCommentsCallback callback) {
        final MultipartRequest request = new MultipartRequest(URL+"/Comment/get/",
                new RequestCompleteListener<String>() {
                    @Override
                    public void onComplete(int stateCode, String response, String errMsg) {
                        try {
                            JSONObject object = new JSONObject(response);
                            String err = object.getString("err");
                            if (err.equals("-1")){
                                callback.onDataNotAvailable();
                            } else {
                                JSONArray array = new JSONArray(object.getJSONArray("itemList"));
                                List<EntryComment> list = new ArrayList<>();
                                for (int i = 0; i < array.length(); i++){
                                    JSONObject item = array.getJSONObject(i);
                                    list.add(new EntryComment(item.getString("account"),
                                            item.getString("context"), item.getString("time")));
                                }
                                callback.onCommentsLoaded(list);
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                            throw new RuntimeException("JSONException");
                        }
                    }
                });
        Map<String, String> map = request.getHeaders();
        map.put("connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", "multipart/form-data"
                + "; boundary=" + request.getMultiPartEntity().getBoundary());

        MultipartEntity multipartEntity = request.getMultiPartEntity();
        multipartEntity.addStringPart("itemID", entryId);
        BaikeApplication.getRequestQueue().addRequest(request);
    }

    @Override
    public void addEntryComment(@NonNull String entryId, @NonNull EntryComment newComment, @NonNull final AddCommentCallback callback) {
        final MultipartRequest request = new MultipartRequest(URL+"/Comment/add/",
                new RequestCompleteListener<String>() {
                    @Override
                    public void onComplete(int stateCode, String response, String errMsg) {
                        try {
                            JSONObject object = new JSONObject(response);
                            String err = object.getString("err");
                            if (err.equals("-1")){
                                callback.addFailure("评论发布失败:" + object.getString("msg"));
                            } else {
                                callback.addSuccess();
                            }
                        } catch (JSONException e){
                            e.printStackTrace();
                            throw new RuntimeException("JSONException");
                        }
                    }
                });
        Map<String, String> map = request.getHeaders();
        map.put("connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", "multipart/form-data"
                + "; boundary=" + request.getMultiPartEntity().getBoundary());

        MultipartEntity multipartEntity = request.getMultiPartEntity();
        multipartEntity.addStringPart("userID", "测试用户ID");
        multipartEntity.addStringPart("itemID", entryId);
        multipartEntity.addStringPart("text", newComment.getContent());
        multipartEntity.addStringPart("time", newComment.getCreatedDateString());
        BaikeApplication.getRequestQueue().addRequest(request);
    }

    @Override
    public void register(@NonNull final String username, @NonNull String passwd, @NonNull final RegisterCallback callback) {
        final MultipartRequest request = new MultipartRequest(URL+"/User/register/",
                new RequestCompleteListener<String>() {
                    @Override
                    public void onComplete(int stateCode, String response, String errMsg) {
                        Log.d("test", response);
                        try{
                            JSONObject object = new JSONObject(response);
                            String err = object.getString("err");
                            if(err.equals("0")){
                               callback.registerSuccess(username,object.getString("userID"));
                            }else{
                               callback.registerFailure("注册失败，失败代码 "+object.getString("err"));
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                            throw new RuntimeException("JSONException");
                        }
                    }
                });
        Map<String, String> map = request.getHeaders();
        map.put("connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", "multipart/form-data"
                + "; boundary=" + request.getMultiPartEntity().getBoundary());

        MultipartEntity multipartEntity = request.getMultiPartEntity();
        multipartEntity.addStringPart("account", username);
        multipartEntity.addStringPart("password", passwd);
        BaikeApplication.getRequestQueue().addRequest(request);
    }

    @Override
    public void login(@NonNull final String username, @NonNull String passwd, @NonNull final LoginCallback callback) {
        final MultipartRequest request = new MultipartRequest(URL+"/User/login/",
                new RequestCompleteListener<String>() {
                    @Override
                    public void onComplete(int stateCode, String response, String errMsg){
                        Log.d("test", response);
                        try{
                            JSONObject object = new JSONObject(response);
                            if(object.get("err").toString().equals("0")){
                                callback.loginSuccess(username,object.getString("userID"));
                            }else{
                                callback.loginFailure("登录失败，失败代码 "+object.getString("err"));
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                            throw new RuntimeException("JSONException");
                        }
                    }
                });
        Map<String, String> map = request.getHeaders();
        map.put("connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", "multipart/form-data"
                + "; boundary=" + request.getMultiPartEntity().getBoundary());

        MultipartEntity multipartEntity = request.getMultiPartEntity();
        multipartEntity.addStringPart("account", username);
        multipartEntity.addStringPart("password", passwd);
        BaikeApplication.getRequestQueue().addRequest(request);
    }

    @Override
    public void getRecommendation(@NonNull final GetRecommendationCallback callback) {
        StringRequest request = new StringRequest(Request.HttpMethod.GET, URL+"/Item/recommend/", new RequestCompleteListener<String>() {
            @Override
            public void onComplete(int stateCode, String response, String errMsg) {
                try{
                    Log.d("response",response);
                    JSONObject object = new JSONObject(response);
                    if(object.getString("err").equals("0")){
                       callback.getSuccess(response);
                    }else{
                        callback.getFailure("获取首页内容失败，失败代码 "+object.getString("err"));
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                    throw new RuntimeException("JSONException");
                }

            }
        });
        BaikeApplication.getRequestQueue().addRequest(request);
    }

    @Override
    public void getQuery(@NonNull String query_txt,@NonNull final GetQueryCallback callback) {

        final MultipartRequest request = new MultipartRequest(URL+"/Item/search/",
                new RequestCompleteListener<String>() {
                    @Override
                    public void onComplete(int stateCode, String response, String errMsg){
                        Log.d("test", response);
                        try{
                            JSONObject object = new JSONObject(response);
                            if(object.get("err").toString().equals("0")){
                                callback.getSuccess(response);
                            }else{
                                callback.getFailure("搜索失败，失败代码 "+object.getString("err"));
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                            throw new RuntimeException("JSONException");
                        }
                    }
                });
        Map<String, String> map = request.getHeaders();
        map.put("connection", "keep-alive");
        map.put("Charset", "UTF-8");
        map.put("Content-Type", "multipart/form-data"
                + "; boundary=" + request.getMultiPartEntity().getBoundary());

        MultipartEntity multipartEntity = request.getMultiPartEntity();
        multipartEntity.addStringPart("title", query_txt);
        BaikeApplication.getRequestQueue().addRequest(request);
    }
}
