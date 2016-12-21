package com.ar.lee.baikeapplication.addentry;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ar.lee.baikeapplication.R;
import com.ar.lee.baikeapplication.util.ActivityUtils;

public class AddEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("新建词条");
        actionBar.setDisplayHomeAsUpEnabled(true);

        AddEntryFragment addEntryFragment =
                (AddEntryFragment) getSupportFragmentManager().findFragmentById(R.id.content_add_entry);
        if (addEntryFragment == null){
            addEntryFragment = AddEntryFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    addEntryFragment, R.id.content_add_entry);
        }

        new AddEntryPresenter(addEntryFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_add_entry_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_entry_finish:
                AddEntryFragment addEntryFragment =
                        (AddEntryFragment) getSupportFragmentManager().findFragmentById(R.id.content_add_entry);
                addEntryFragment.onFinishClicked();
                break;
        }

        return false;
    }
}
