package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.UserMessage;

import java.util.ArrayList;
import java.util.List;

public class fuduji extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private UserMessageAdapter mUserWordMessageAdapter;
    private EditText con;
    private List<UserMessage> mUserWordMessageList;
    Button bn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuduji);
        con = findViewById(R.id.con);
        bn = (Button) findViewById(R.id.bu);
        mUserWordMessageList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mUserWordMessageAdapter = new UserMessageAdapter(mUserWordMessageList);
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mUserWordMessageAdapter);
        bn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= con.getText().toString();
                x = x.trim();
                if (x.length() == 0) {
                    Toast.makeText(fuduji.this,"文本框不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                addSendMessage(x);
                addReceiveMessage("我接收到"+x);
            }
        });

    }
    private void addReceiveMessage(String content) {
        UserMessage userWordMessage = new UserMessage(content, UserMessage.TYPE_RECEIVE);
        mUserWordMessageList.add(userWordMessage);
        mUserWordMessageAdapter.notifyItemInserted(mUserWordMessageList.size() - 1);
        mRecyclerView.scrollToPosition(mUserWordMessageList.size() - 1);
        con.setText("");
    }
    private void addSendMessage(String content) {
        UserMessage userWordMessage = new UserMessage(content, UserMessage.TYPE_SEND);
        mUserWordMessageList.add(userWordMessage);
        mUserWordMessageAdapter.notifyItemInserted(mUserWordMessageList.size() - 1);
        mRecyclerView.scrollToPosition(mUserWordMessageList.size() - 1);
        con.setText("");
    }
}