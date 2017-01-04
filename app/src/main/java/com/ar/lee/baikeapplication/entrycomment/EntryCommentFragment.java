package com.ar.lee.baikeapplication.entrycomment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ar.lee.baikeapplication.R;
import com.ar.lee.baikeapplication.data.EntryComment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EntryCommentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EntryCommentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EntryCommentFragment extends Fragment implements EntryCommentContract.View{

    private OnFragmentInteractionListener mListener;

    private EntryCommentContract.Presenter mPresenter;

    private String entryID = "测试ID";

    //widgets
    private RecyclerView commentRecyclerView;
    private FloatingActionButton addFloatingButton;
    private TextView wrongTextView;

    public EntryCommentFragment() {
        // Required empty public constructor
    }

    @Override
    public void setPresenter(EntryCommentContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EntryCommentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EntryCommentFragment newInstance() {
        EntryCommentFragment fragment = new EntryCommentFragment();
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
        return initViews(inflater.inflate(R.layout.fragment_entry_comment, container, false));
    }

    private View initViews(View fragment){
        commentRecyclerView = (RecyclerView) fragment.findViewById(R.id.entry_comment_list);
        addFloatingButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        addFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCommentDialog();
            }
        });
        wrongTextView = (TextView) fragment.findViewById(R.id.entry_comment_internet_wrong_text);

        return fragment;
    }

    @Override
    public void showComments(List<EntryComment> list) {
        CommentListAdapter adapter = new CommentListAdapter(getContext(), list);
        commentRecyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        commentRecyclerView.setAdapter(adapter);
        commentRecyclerView.addItemDecoration(new CommentListDecoration(getContext(),
                CommentListDecoration.VERTICAL_LIST));
    }

    @Override
    public void showCommentsLoadFailure() {
        wrongTextView.setVisibility(View.VISIBLE);
    }

    private void showCommentDialog(){
        final android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getContext());
        builder.setTitle("请输入评论");
        builder.setView(R.layout.dialog_write_comment);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定", null);
        final AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getContext().getResources().getColor(R.color.colorPrimary));
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getContext().getResources().getColor(R.color.colorTextPrimary));
        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.addComment(entryID, new EntryComment("测试用户名",
                        ((EditText)dialog.findViewById(R.id.comment_dialog_content)).getText().toString()));
                dialog.dismiss();
            }
        });
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
