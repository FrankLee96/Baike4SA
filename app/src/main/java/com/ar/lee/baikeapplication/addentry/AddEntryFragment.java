package com.ar.lee.baikeapplication.addentry;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.ar.lee.baikeapplication.R;
import com.ar.lee.baikeapplication.data.Entry;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddEntryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddEntryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddEntryFragment extends Fragment implements AddEntryContract.View{

    private AddEntryContract.Presenter mPresenter;

    private OnFragmentInteractionListener mListener;

    private EditText entryTitleEditText;
    private EditText entryDescriptionEditText;
    private FloatingActionButton addImageFloatingButton;
    private ImageView entryImageView;

    private String mImgPath = Entry.NO_IMAGE_PATH;

    public AddEntryFragment() {
        // Required empty public constructor
    }

    @Override
    public void setPresenter(AddEntryContract.Presenter presenter) {
        if (presenter == null){
            throw new RuntimeException("Presenter is null when setting");
        }
        this.mPresenter = presenter;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddEntryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddEntryFragment newInstance() {
        AddEntryFragment fragment = new AddEntryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return initViews(inflater.inflate(R.layout.fragment_add_entry, container, false));
    }

    private View initViews(View fragment){
        entryTitleEditText = (EditText) fragment.findViewById(R.id.add_entry_title);

        entryDescriptionEditText = (EditText) fragment.findViewById(R.id.add_entry_description);

        addImageFloatingButton = (FloatingActionButton) getActivity().findViewById(R.id.fab_add_img);
        addImageFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });

        entryImageView = (ImageView) fragment.findViewById(R.id.add_entry_img_view);

        return fragment;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK){

            Bitmap bm = null;
            ContentResolver resolver = getActivity().getContentResolver();
            try {

                Uri originalUri = data.getData(); // 获得图片的uri
                bm = MediaStore.Images.Media.getBitmap(resolver, originalUri);
                String[] proj = { MediaStore.Images.Media.DATA };
                Cursor cursor = getActivity().managedQuery(originalUri, proj, null, null,
                        null);
                int column_index = cursor
                        .getColumnIndex(MediaStore.Images.Media.DATA);
                cursor.moveToNext();
                mImgPath = cursor.getString(column_index);

                Log.d("test", "Path:" + mImgPath);

                entryImageView.setImageBitmap(bm);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFinishClicked() {
        if (entryTitleEditText.length() == 0 || entryDescriptionEditText.length() == 0){
            Snackbar.make(addImageFloatingButton, "输入不能为空", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        } else {
            mPresenter.uploadEntry(
                    new Entry(Entry.NO_ID_WHEN_CREATE, entryTitleEditText.getText().toString(),
                            entryDescriptionEditText.getText().toString(), mImgPath));
        }
    }

    @Override
    public void returnToMeanSearch() {
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
