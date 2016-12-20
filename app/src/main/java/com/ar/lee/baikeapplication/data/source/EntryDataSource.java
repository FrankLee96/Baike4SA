package com.ar.lee.baikeapplication.data.source;

import android.support.annotation.NonNull;

import com.ar.lee.baikeapplication.data.Entry;
import com.ar.lee.baikeapplication.data.EntryComment;

import java.util.List;

/**
 * Created by Lee on 2016/12/20.
 */

public interface EntryDataSource {

    interface LoadEntriesCallback{

        void onEntriesLoaded(List<Entry> entries);

        void onDataNotAvailable();
    }

    interface GetEntryCallback{

        void onEntryLoaded(Entry entry);

        void onDataNotAvailable();
    }

    interface LoadCommentsCallback{

        void onCommentsLoaded(List<EntryComment> comments);

        void onDataNotAvailable();
    }

    interface AddCommentCallback{

        void addSuccess();

        void addFailure(String code);
    }

    void getEntry(@NonNull String entryId, @NonNull GetEntryCallback callback);

    void addEntry(@NonNull Entry newEntry);

    void loadEntryComments(@NonNull String entryId, @NonNull LoadCommentsCallback callback);

    void addEntryComment(@NonNull EntryComment newComment, @NonNull AddCommentCallback callback);
}
