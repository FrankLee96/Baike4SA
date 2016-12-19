package com.ar.lee.baikeapplication.entrydetail;

import com.ar.lee.baikeapplication.BasePresenter;
import com.ar.lee.baikeapplication.BaseView;
import com.ar.lee.baikeapplication.data.Entry;

/**
 * Created by Lee on 2016/12/18.
 */

public interface EntryDetailContract {

    interface View extends BaseView<Presenter> {

        /**
         * 显示词条信息
         * @param entry 词条项
         */
        void showEntryInf(Entry entry);
    }

    interface Presenter extends BasePresenter{
        void loadEntryToShow(String entryID);
    }
}
