package com.ar.lee.baikeapplication.mainsearch;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ar.lee.baikeapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainSearchFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainSearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainSearchFragment extends Fragment implements MainSearchContract.View,Words_List_Adapter.ItemClickListener{

    private MainSearchContract.Presenter mPresenter;
    private ListView words_listView;
    private Words_List_Adapter adapter;
    private OnFragmentInteractionListener mListener;
    private Context context;
    private List<WordsBean> words_list=new ArrayList<>();
    public MainSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void setPresenter(MainSearchContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainSearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainSearchFragment newInstance() {
        MainSearchFragment fragment = new MainSearchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment;
        fragment =  inflater.inflate(R.layout.fragment_main_search, container, false);
        words_listView =(ListView) fragment.findViewById(R.id.words_listView);
        return fragment;
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
        this.context = context;
    }

    @Override
    public void onResume() {
        super.onResume();
        //mPresenter.start();
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

    @Override
    public void refresh_words_list(List<WordsBean> list) {
        words_list = list;
    }

    @Override
    public void refresh_listView() {
        adapter = new Words_List_Adapter(context,
                R.layout.word_lists_layout,words_list,this);
        words_listView.setAdapter(adapter);
        Utility();
    }
    private void Utility(){
        if (adapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, words_listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = words_listView.getLayoutParams();
        params.height = totalHeight + (words_listView.getDividerHeight() * (adapter.getCount() - 1));
        words_listView.setLayoutParams(params);
    }

    @Override
    public void clearList() {
        words_listView.setAdapter(null);
    }

    @Override
    public void onItemClick(int position) {
        onItemClicked(position);
    }

    @Override
    public void onItemClicked(int position) {
        Log.d("position",position+"");
    }
}
