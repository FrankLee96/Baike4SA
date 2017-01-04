package com.ar.lee.baikeapplication.mainsearch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ar.lee.baikeapplication.R;
import com.ar.lee.baikeapplication.data.WordsBean;

import java.util.List;

import static com.ar.lee.baikeapplication.R.id.word_txt;

/**
 * Created by jeffdeen on 2016/12/18.
 */

public class Words_List_Adapter extends ArrayAdapter<WordsBean> {
    public interface ItemClickListener {
        void onItemClick(int position);
    }

    private int resourceId;
    private static ItemClickListener mItemClickListener;

    public Words_List_Adapter(Context context, int resourceId, List<WordsBean> objects,ItemClickListener itemClickListener){
        super(context,resourceId,objects);
        this.resourceId = resourceId;
        mItemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        WordsBean word = getItem(position);
        String word_title = word.getWord_title();
        String word_abstract = word.getWord_description();
        TextView word_txtView=(TextView)view.findViewById(word_txt);
        word_txtView.setText(word_title);
        TextView word_abstractView = (TextView)view.findViewById(R.id.abstract_word);
        word_abstractView.setText(word_abstract);
        CardView cardView = (CardView)view.findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(position);
            }
        });
        return view;
    }
}


