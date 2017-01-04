package com.ar.lee.baikeapplication.addentry;

import com.ar.lee.baikeapplication.data.Entry;
import com.ar.lee.baikeapplication.data.source.EntryDataSource;
import com.ar.lee.baikeapplication.data.source.EntryRepository;

/**
 * Created by Lee on 2016/12/18.
 */

public class AddEntryPresenter implements AddEntryContract.Presenter{

    private AddEntryContract.View mAddEntryView;

    public AddEntryPresenter(AddEntryContract.View view){
        this.mAddEntryView = view;

        view.setPresenter(this);
    }

    @Override
    public void uploadEntry(final Entry newEntry) {
        EntryRepository.getInstance().uploadImage(newEntry.getImagePath(), new EntryDataSource.UploadImageCallback() {
            @Override
            public void uploadSuccess(String filePath) {
                newEntry.setImagePath(filePath);
                EntryRepository.getInstance().addEntry(newEntry, new EntryDataSource.AddEntryCallback() {
                    @Override
                    public void addSuccess() {
                        mAddEntryView.returnToMeanSearch();
                    }

                    @Override
                    public void addFailure(String code) {
                        mAddEntryView.showErrorInf("词条上传失败:" + code);
                    }
                });
            }

            @Override
            public void uploadFailure(String code) {
                mAddEntryView.showErrorInf("图片上传失败:" + code);
            }
        });
    }

    @Override
    public void start() {
    }
}
