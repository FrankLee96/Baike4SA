package com.ar.lee.baikeapplication.mainsearch;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2016/12/17.
 */

public class MainSearchPresenter implements MainSearchContract.Presenter{

    private MainSearchContract.View mMainSearchView;
    //private String queryTxt;
    private List<WordsBean> words_list = new ArrayList<>();
    public MainSearchPresenter(@NonNull MainSearchContract.View view){
        this.mMainSearchView = view;
        view.setPresenter(this);
    }
    @Override
    public void start() {
        refresh_listView();
    }

    @Override
    public void refresh_words_list() {
        mMainSearchView.refresh_words_list(words_list);
    }

    @Override
    public void refresh_listView() {
        refresh_words_list();
        mMainSearchView.refresh_listView();
    }

    @Override
    public void Query(String query_txt) {
       WordsBean word = new WordsBean("立顿","立顿”是全球最大的茶叶品牌。立顿的宗旨是光明," +
                "活力和自然美好的乐趣。汤姆斯·立顿是这一品牌的创始人，1890年他正式在英国推出立顿");
        for (int i = 0;i<5;++i){
            words_list.add(word);
        }
        start();
    }
}
