package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText editText = (EditText) findViewById(R.id.text1);
        final TextView textView = (TextView) findViewById(R.id.text2);
        imageView = (ImageView)findViewById(R.id.img);
        @SuppressLint("HandlerLeak") final Handler handler = new Handler() {
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
        Button bu3= (Button) findViewById(R.id.bu3);
        bu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,DrawActivity.class);
                startActivityForResult(intent,0);
            }
        });
        Button bu2 = (Button) findViewById(R.id.bu2);
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null)
            return;
        else
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

}