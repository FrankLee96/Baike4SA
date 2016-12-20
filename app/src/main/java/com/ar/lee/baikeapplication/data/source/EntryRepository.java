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
    public void addEntry(@NonNull Entry newEntry) {

    }

    @Override
    public void loadEntryComments(@NonNull String entryId, @NonNull LoadCommentsCallback callback) {

    }

    @Override
    public void addEntryComment(@NonNull EntryComment newComment, @NonNull AddCommentCallback callback) {

    }
}
