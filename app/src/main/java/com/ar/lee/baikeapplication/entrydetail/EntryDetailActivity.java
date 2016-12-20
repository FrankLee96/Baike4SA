package com.ar.lee.baikeapplication.entrydetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.ar.lee.baikeapplication.R;
import com.ar.lee.baikeapplication.addentry.AddEntryFragment;
import com.ar.lee.baikeapplication.entrycomment.EntryCommentActivity;
import com.ar.lee.baikeapplication.util.ActivityUtils;

public class EntryDetailActivity extends AppCompatActivity {

    private ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        EntryDetailFragment entryDetailFragment =
                (EntryDetailFragment) getSupportFragmentManager().findFragmentById(R.id.content_entry_detail);
        if (entryDetailFragment == null){
            entryDetailFragment = EntryDetailFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    entryDetailFragment, R.id.content_entry_detail);
        }

        new EntryDetailPresenter(entryDetailFragment);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_entry_detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_entry_detail_edit:
                //TODO: go to edit activity
                break;

            case R.id.action_entry_detail_comment:
                Intent intentToComment = new Intent(EntryDetailActivity.this, EntryCommentActivity.class);
                startActivity(intentToComment);
                break;
        }

        return false;
    }

    public void setActionBarTitle(String title){
        mActionBar.setTitle(title);
    }
}
