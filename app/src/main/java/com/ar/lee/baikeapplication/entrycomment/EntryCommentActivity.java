package com.ar.lee.baikeapplication.entrycomment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ar.lee.baikeapplication.R;
import com.ar.lee.baikeapplication.util.ActivityUtils;

public class EntryCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_comment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("词条评论");
        actionBar.setDisplayHomeAsUpEnabled(true);

        EntryCommentFragment entryCommentFragment = (EntryCommentFragment)
                getSupportFragmentManager().findFragmentById(R.id.content_entry_comment);
        if (entryCommentFragment == null){
            entryCommentFragment = EntryCommentFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    entryCommentFragment, R.id.content_entry_comment);
        }

        new EntryCommentPresenter(entryCommentFragment);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
