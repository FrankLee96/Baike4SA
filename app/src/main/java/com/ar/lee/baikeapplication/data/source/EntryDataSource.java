package com.ar.lee.baikeapplication.data.source;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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

    interface UploadImageCallback{

        void uploadSuccess(String filePath);

        void uploadFailure(String code);
    }

    interface AddEntryCallback{

        void addSuccess();

        void addFailure(String code);
    }

    interface LoginCallback{

        void loginSuccess(String username,String userID);

        void loginFailure(String code);

    }

    interface RegisterCallback{

        void registerSuccess(String username,String userID);

        void registerFailure(String code);
    }

    interface GetRecommendationCallback{

        void getSuccess(String response);

        void getFailure(String code);
    }



    void getEntry(@NonNull String entryId, @NonNull GetEntryCallback callback);

    void uploadImage(@NonNull String imgPath, @NonNull UploadImageCallback callback);

    void addEntry(@NonNull Entry newEntry, @NonNull AddEntryCallback callback);

    void loadEntryComments(@NonNull String entryId, @NonNull LoadCommentsCallback callback);

    void addEntryComment(@NonNull String entryId, @NonNull EntryComment newComment, @NonNull AddCommentCallback callback);

    void login(@Nullable String username,@Nullable String passwd,@Nullable LoginCallback callback);

    void register(@Nullable String username,@Nullable String passwd,@Nullable RegisterCallback callback);

    void getRecommendation(@Nullable GetRecommendationCallback callback);
}
