package com.ar.lee.baikeapplication.data.source;

import android.support.annotation.NonNull;

import com.ar.lee.baikeapplication.data.Entry;
import com.ar.lee.baikeapplication.data.EntryComment;
import com.ar.lee.baikeapplication.data.source.remote.EntryRemoteDataSource;

/**
 * Created by Lee on 2016/12/20.
 */

public class EntryRepository implements EntryDataSource{

    private static EntryRepository INSTANCE = null;

    private EntryDataSource mRemoteDataSource;

    private EntryRepository(){
        mRemoteDataSource = EntryRemoteDataSource.getInstance();
    }

    public static EntryRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new EntryRepository();
        }
        return INSTANCE;
    }

    @Override
    public void getEntry(@NonNull String entryId, @NonNull GetEntryCallback callback) {
        mRemoteDataSource.getEntry(entryId, callback);
    }

    @Override
    public void uploadImage(@NonNull String imgPath, @NonNull UploadImageCallback callback) {
        mRemoteDataSource.uploadImage(imgPath, callback);
    }

    @Override
    public void addEntry(@NonNull Entry newEntry, @NonNull AddEntryCallback callback) {
        mRemoteDataSource.addEntry(newEntry, callback);
    }

    @Override
    public void loadEntryComments(@NonNull String entryId, @NonNull LoadCommentsCallback callback) {

    }

    @Override
    public void addEntryComment(@NonNull String entryId, @NonNull EntryComment newComment, @NonNull AddCommentCallback callback) {

    }

    @Override
    public void register(@NonNull String username, @NonNull String passwd, @NonNull RegisterCallback callback) {
        mRemoteDataSource.register(username,passwd,callback);
    }

    @Override
    public void login(@NonNull String username, @NonNull String passwd, @NonNull LoginCallback callback) {
        mRemoteDataSource.login(username,passwd,callback);
    }

    @Override
    public void getRecommendation(@NonNull GetRecommendationCallback callback) {
        mRemoteDataSource.getRecommendation(callback);
    }

    @Override
    public void getQuery(@NonNull String query_txt,@NonNull final GetQueryCallback callback) {
        mRemoteDataSource.getQuery(query_txt,callback);
    }
}
