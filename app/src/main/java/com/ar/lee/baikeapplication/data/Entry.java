package com.ar.lee.baikeapplication.data;


/**
 * Created by Lee on 2016/12/18.
 */

public class Entry {

    public static String NO_IMAGE_PATH = "a path should load first!";

    public static String NO_ID_WHEN_CREATE = "-1";

    private String mID = NO_ID_WHEN_CREATE;

    private String mTitle;

    private String mDescription;

    private String mImagePath = NO_IMAGE_PATH;

    /**
     *
     * @param id 词条ID，当用户创建上传时无ID，应使用NO_ID_WHEN_CREATE
     * @param title 标题
     * @param description 正文描述
     * @param imagePath 图片路径，当无图片或者未设置时，应使用NO_IMAGE_PATH
     */
    public Entry(String id,String title, String description, String imagePath){
        this.mID = id;
        this.mTitle = title;
        this.mDescription = description;
        this.mImagePath = imagePath;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getImagePath() {
        return mImagePath;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setImagePath(String mImagePath) {
        this.mImagePath = mImagePath;
    }
}
