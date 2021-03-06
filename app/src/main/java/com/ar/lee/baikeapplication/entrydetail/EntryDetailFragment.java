package com.ar.lee.baikeapplication.entrydetail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ar.lee.baikeapplication.R;
import com.ar.lee.baikeapplication.data.Entry;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EntryDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EntryDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EntryDetailFragment extends Fragment implements EntryDetailContract.View{

    private EntryDetailContract.Presenter mPresenter;

    private OnFragmentInteractionListener mListener;

    private Entry mEntry;

    //widgets
    private TextView descriptionTextView;

    public EntryDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void setPresenter(EntryDetailContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EntryDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EntryDetailFragment newInstance() {
        EntryDetailFragment fragment = new EntryDetailFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return initViews(inflater.inflate(R.layout.fragment_entry_detail, container, false));
    }

    private View initViews(View fragment){
        descriptionTextView = (TextView) fragment.findViewById(R.id.entry_detail_description);

        return fragment;
    }

    @Override
    public void showEntryInf(Entry entry) {
        mEntry = entry;

        ((EntryDetailActivity)getActivity()).setActionBarTitle(entry.getTitle());
        //设置正文
        descriptionTextView.setText(entry.getDescription());
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
