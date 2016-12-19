package com.ar.lee.baikeapplication.mainsearch;

import java.io.Serializable;

/**
 * Created by jeffdeen on 2016/12/19.
 */

public class WordsBean implements Serializable {
    private String word_txt;
    private String word_abstract;

    public WordsBean(String word_txt, String word_abstract) {
        this.word_txt = word_txt;
        this.word_abstract = word_abstract;
    }

    public String getWord_txt() {
        return word_txt;
    }

    public void setWord_txt(String word_txt) {
        this.word_txt = word_txt;
    }

    public String getWord_abstract() {
        return word_abstract;
    }

    public void setWord_abstract(String word_abstract) {
        this.word_abstract = word_abstract;
    }
}
