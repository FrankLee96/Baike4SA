package com.ar.lee.baikeapplication.data;

import com.ar.lee.baikeapplication.util.DateShownUtils;

/**
 * Created by Lee on 2016/12/19.
 */

public class EntryComment {

    private String userName;

    private String content;

    private long createdTime;

    public EntryComment(String userName, String content){
        this.userName = userName;
        this.content = content;
        this.createdTime = System.currentTimeMillis();
    }

    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedDateString() {
        return DateShownUtils.commentDateFormat(createdTime);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
