package com.ar.lee.baikeapplication.data;

import java.io.Serializable;

/**
 * Created by jeffdeen on 2016/12/21.
 */

public class WordsBean implements Serializable {
    private String word_id;
    private String word_title;
    private String word_description;

    public WordsBean( String word_id, String word_title, String word_description) {
        this.word_title = word_title;
        this.word_description = word_description;
        this.word_id = word_id;
    }

    public String getWord_id() {
        return word_id;
    }

    public void setWord_id(String word_id) {
        this.word_id = word_id;
    }

    public String getWord_title() {
        return word_title;
    }

    public void setWord_title(String word_title) {
        this.word_title = word_title;
    }

    public String getWord_description() {
        return word_description;
    }

    public void setWord_description(String word_description) {
        this.word_description = word_description;
    }
}