package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class otherActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Button bn = (Button)findViewById(R.id.bu);
        Log.v("otherActivity","这是onCreate()");
        final Intent data=getIntent();
        String str = data.getStringExtra("a");
        Toast.makeText(this,"欢迎您，"+str,Toast.LENGTH_LONG).show();
        bn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                String name=data.getStringExtra("name");
                Integer age=data.getIntExtra("age",20);
                data.putExtra("result","姓名"+name+"年龄"+age);
                setResult(0,data);
                finish();
            }
        });
    }
    protected void onStart() {
        super.onStart();
        Log.v("otherActivity","这是onStart()");
    }

    protected void onRestart() {
        super.onRestart();
        Log.v("otherActivity", "这是onRestart()");
    }

    protected void onResume() {
        super.onResume();
        Log.v("otherActivity", "这是onResume()");
    }

    protected void onPause() {
        super.onPause();
        Log.v("otherActivity", "这是onPause()");
    }

    protected void onStop() {
        super.onStop();
        Log.v("otherActivity", "这是onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.v("otherActivity", "这是onDestroy()");
    }
}