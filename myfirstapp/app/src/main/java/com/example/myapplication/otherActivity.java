package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class otherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Button bn = (Button)findViewById(R.id.bu);
        bn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=getIntent();
                String name=intent.getStringExtra("name");
                Integer age=intent.getIntExtra("age",20);
                intent.putExtra("result","姓名"+name+"年龄"+age);
                setResult(0,intent);
                finish();
            }
        });
    }
}