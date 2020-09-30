package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText editText = (EditText) findViewById(R.id.text1);
        final TextView textView = (TextView) findViewById(R.id.text2);
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if(msg.arg1 == 0)
                    textView.setText("不是素数");
                else if(msg.arg1 == 1)
                    textView.setText("是素数");
                else
                    textView.setText("数据错误");
            }
        };
        final Runnable myWorker = new Runnable() {
            @Override
            public void run() {
                int finalX = Integer.valueOf(editText.getText().toString());
                Message msg = handler.obtainMessage();
                if(finalX < 2)
                {
                    msg.arg1 = -1;
                    handler.sendMessage(msg);
                    return;
                }
                int b = 1;
                for(int i = 2;i <= Math.sqrt(finalX);i++)
                {
                    if(finalX % i == 0)
                    {
                        b = 0;
                    }
                }
                msg.arg1 = b;
                handler.sendMessage(msg);
            }
        };
        Button button = (Button) findViewById(R.id.bu1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread workThread = new Thread(null, myWorker, "WorkThread");
                workThread.start();
            }
        });
    }
}