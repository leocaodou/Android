package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.model.UserMessage;

import java.util.List;

public class UserMessageAdapter extends RecyclerView.Adapter<UserMessageAdapter.UserMessageViewHolder> {
    private final List<UserMessage> mUserWordMessageList;

    public UserMessageAdapter(List<UserMessage> userWordMessageList) {
        this.mUserWordMessageList = userWordMessageList;
    }

    @NonNull
    @Override
    public UserMessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == UserMessage.TYPE_RECEIVE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_msg_left_layout, parent, false);
            return new UserMessageViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_msg_right_layout, parent, false);
            return new UserMessageViewHolder(view);
        }

    }


    @Override
    public void onBindViewHolder(@NonNull UserMessageViewHolder holder, int position) {
        UserMessage msg = mUserWordMessageList.get(position);
        if (msg.getCome() == UserMessage.TYPE_RECEIVE)
            holder.tvLeft.setText(msg.getContent());
        else
            holder.tvRight.setText(msg.getContent());
    }

    public int  getItemViewType(int p){
        UserMessage u = mUserWordMessageList.get(p);
        return u.getCome();
    }

    @Override
    public int getItemCount() {
        return mUserWordMessageList.size();
    }


    class UserMessageViewHolder extends RecyclerView.ViewHolder {
        TextView tvLeft, tvRight;

        UserMessageViewHolder(@NonNull View itemView) {
            super(itemView);

            tvLeft = itemView.findViewById(R.id.user_message_leftText);
            tvRight = itemView.findViewById(R.id.user_message_rightText);


        }


    }
}