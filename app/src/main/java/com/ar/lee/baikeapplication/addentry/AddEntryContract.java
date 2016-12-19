package com.ar.lee.baikeapplication.addentry;

import com.ar.lee.baikeapplication.BasePresenter;
import com.ar.lee.baikeapplication.BaseView;
import com.ar.lee.baikeapplication.data.Entry;

/**
 * Created by Lee on 2016/12/18.
 */

public interface AddEntryContract{

    interface View extends BaseView<Presenter>{

        /**
         * 当用户点击ActionBar上的完成时调用
         */
        void onFinishClicked();

        /**
         * 上传完成之后关闭界面返回主界面
         */
        void returnToMeanSearch();
    }

    interface Presenter extends BasePresenter{

        /**
         * 上传新建词条
         * @param newEntry 新建词条项
         */
        void uploadEntry(Entry newEntry);
    }
}
