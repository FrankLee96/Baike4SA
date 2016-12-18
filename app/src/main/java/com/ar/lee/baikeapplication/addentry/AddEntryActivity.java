package com.ar.lee.baikeapplication.addentry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ar.lee.baikeapplication.R;
import com.ar.lee.baikeapplication.util.ActivityUtils;

public class AddEntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        AddEntryFragment addEntryFragment =
                (AddEntryFragment) getSupportFragmentManager().findFragmentById(R.id.content_add_entry);
        if (addEntryFragment == null){
            addEntryFragment = AddEntryFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    addEntryFragment, R.id.content_add_entry);
        }

        new AddEntryPresenter(addEntryFragment);
    }
}
