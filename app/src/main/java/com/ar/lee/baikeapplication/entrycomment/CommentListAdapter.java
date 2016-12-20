package com.ar.lee.baikeapplication.entrycomment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ar.lee.baikeapplication.R;
import com.ar.lee.baikeapplication.data.EntryComment;

import java.util.List;

/**
 * Created by Lee on 2016/12/19.
 */

public class CommentListAdapter extends RecyclerView.Adapter<CommentListAdapter.CommentListViewHolder>{

    private Context mContext;

    private List<EntryComment> mCommentList;

    public CommentListAdapter(Context context, List<EntryComment> list){
        this.mContext = context;
        this.mCommentList = list;
    }

    @Override
    public CommentListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_entry_comment, parent, false);
        return new CommentListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentListViewHolder holder, int position) {
        EntryComment comment = mCommentList.get(position);
        holder.userName.setText(comment.getUserName());
        holder.userComment.setText(comment.getContent());
        holder.commentDate.setText(comment.getCreatedDateString());
    }

    @Override
    public int getItemCount() {
        return mCommentList.size();
    }

    public static class CommentListViewHolder extends RecyclerView.ViewHolder{

        TextView userName;
        TextView userComment;
        TextView commentDate;

        public CommentListViewHolder(View itemView){
            super(itemView);

            userName = (TextView) itemView.findViewById(R.id.entry_comment_user_name);
            userComment = (TextView) itemView.findViewById(R.id.entry_comment_user_comment);
            commentDate = (TextView) itemView.findViewById(R.id.entry_comment_date);
        }
    }
}
