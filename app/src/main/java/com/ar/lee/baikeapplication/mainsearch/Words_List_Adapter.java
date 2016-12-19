package com.ar.lee.baikeapplication.mainsearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ar.lee.baikeapplication.R;

import java.util.List;

/**
 * Created by jeffdeen on 2016/12/18.
 */

public class Words_List_Adapter extends ArrayAdapter<WordsBean> {
    private int resourceId;
    public Words_List_Adapter(Context context, int resourceId, List<WordsBean> objects){
        super(context,resourceId,objects);
        this.resourceId = resourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        WordsBean word = getItem(position);
        String word_txt = word.getWord_txt();
        String word_abstract = word.getWord_abstract();
        TextView word_txtView=(TextView)view.findViewById(R.id.word_txt);
        word_txtView.setText(word_txt);
        TextView word_abstractView = (TextView)view.findViewById(R.id.abstract_word);
        word_abstractView.setText(word_abstract);
        return view;
    }
}


