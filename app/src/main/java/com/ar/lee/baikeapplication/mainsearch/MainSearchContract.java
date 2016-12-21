package com.ar.lee.baikeapplication.mainsearch;

import com.ar.lee.baikeapplication.BasePresenter;
import com.ar.lee.baikeapplication.BaseView;

import java.util.List;

/**
 * Created by Lee on 2016/12/17.
 */

public interface MainSearchContract {

    interface View extends BaseView<Presenter>{
        void refresh_listView();
        void refresh_words_list(List<WordsBean> list);
        void clearList();
        void onItemClicked(int position);
    }

    interface Presenter extends BasePresenter{
        void Query(String query_txt);
        void refresh_listView();
        void refresh_words_list();

    }
}
