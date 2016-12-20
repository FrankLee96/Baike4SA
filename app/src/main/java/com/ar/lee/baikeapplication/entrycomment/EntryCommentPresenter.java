package com.ar.lee.baikeapplication.entrycomment;

import com.ar.lee.baikeapplication.data.Entry;
import com.ar.lee.baikeapplication.data.EntryComment;
import com.ar.lee.baikeapplication.data.source.EntryDataSource;
import com.ar.lee.baikeapplication.data.source.EntryRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2016/12/19.
 */

public class EntryCommentPresenter implements EntryCommentContract.Presenter{

    private EntryCommentContract.View mEntryCommentView;

    public EntryCommentPresenter(EntryCommentContract.View view){
        this.mEntryCommentView = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        loadComments("测试词条ID");
    }

    @Override
    public void loadComments(String entryID) {
        EntryRepository.getInstance().loadEntryComments(entryID,
                new EntryDataSource.LoadCommentsCallback() {
                    @Override
                    public void onCommentsLoaded(List<EntryComment> comments) {
                        mEntryCommentView.showComments(comments);
                    }

                    @Override
                    public void onDataNotAvailable() {
                        mEntryCommentView.showCommentsLoadFailure();
                    }
                });

        //测试:

        //success
        List<EntryComment> comments = new ArrayList<>();
        comments.add(new EntryComment("用户1", "这个词条有些错误"));
        comments.add(new EntryComment("用户2", "很好"));
        comments.add(new EntryComment("用户3", "喜欢"));
        comments.add(new EntryComment("用户4", "喜欢"));
        comments.add(new EntryComment("用户5", "喜欢"));
        comments.add(new EntryComment("用户6", "喜欢"));
        comments.add(new EntryComment("用户7", "喜欢"));
        mEntryCommentView.showComments(comments);

        //failure
        /*mEntryCommentView.showCommentsLoadFailure();*/
    }

    @Override
    public void addComment(EntryComment comment) {
        EntryRepository.getInstance().addEntryComment(comment,
                new EntryDataSource.AddCommentCallback() {
                    @Override
                    public void addSuccess() {

                    }

                    @Override
                    public void addFailure(String failureCode) {

                    }
                });
    }
}
