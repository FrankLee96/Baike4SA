package com.ar.lee.baikeapplication.util;

import java.text.SimpleDateFormat;

/**
 * Created by Lee on 2016/12/20.
 */


public class DateShownUtils {
    private static SimpleDateFormat commentDateFormat = new SimpleDateFormat("MM-dd");
    public static String commentDateFormat(long dateLong){
        return commentDateFormat.format(dateLong);
    }
}
