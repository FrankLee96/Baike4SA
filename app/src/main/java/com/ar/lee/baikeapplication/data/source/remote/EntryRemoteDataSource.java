package com.ar.lee.baikeapplication.data.source.remote;

import android.support.annotation.NonNull;

import com.ar.lee.baikeapplication.data.Entry;
import com.ar.lee.baikeapplication.data.EntryComment;
import com.ar.lee.baikeapplication.data.source.EntryDataSource;

/**
 * Created by Lee on 2016/12/20.
 */

public class EntryRemoteDataSource implements EntryDataSource{

    private static EntryRemoteDataSource INSTANCE;

    public static EntryRemoteDataSource getInstance(){
        if (INSTANCE == null){
            INSTANCE = new EntryRemoteDataSource();
        }

        return INSTANCE;
    }

    @Override
    public void getEntry(@NonNull String entryId, @NonNull GetEntryCallback callback) {

    }

    @Override
    public void addEntry(@NonNull Entry newEntry) {

    }

    @Override
    public void loadEntryComments(@NonNull String entryId, @NonNull LoadCommentsCallback callback) {

    }

    @Override
    public void addEntryComment(@NonNull EntryComment newComment, @NonNull AddCommentCallback callback) {

    }
}
