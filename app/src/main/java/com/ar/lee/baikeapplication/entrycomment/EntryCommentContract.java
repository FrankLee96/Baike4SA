package com.ar.lee.baikeapplication.entrycomment;

import com.ar.lee.baikeapplication.BasePresenter;
import com.ar.lee.baikeapplication.BaseView;
import com.ar.lee.baikeapplication.data.EntryComment;

import java.util.List;

/**
 * Created by Lee on 2016/12/19.
 */

public interface EntryCommentContract {

    interface View extends BaseView<Presenter>{

        /**
         * 显示评论
         * @param list 评论列表
         */
        void showComments(List<EntryComment> list);

        /**
         *
         */
        void showCommentsLoadFailure();
    }

    interface Presenter extends BasePresenter{

        /**
         * 加载词条评论
         * @param entryID 词条项ID
         */
        void loadComments(String entryID);

        /**
         * 添加评论
         * @param comment 评论项
         */
        void addComment(EntryComment comment);
    }
}
