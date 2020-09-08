package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView show;
    Button bn1;
    Button bn2;
    Button bn3;
    Button bn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = findViewById(R.id.num);
        bn1 = (Button) findViewById(R.id.buA);
        bn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= (String) show.getText();
                int y = Integer.valueOf(x);
                y++;
                x = String.valueOf(y);
                show.setText(x);
            }
        });
        bn2 = (Button) findViewById(R.id.buB);
        bn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String x= (String) show.getText();
                int y = Integer.valueOf(x);
                y--;
                x = String.valueOf(y);
                show.setText(x);
            }
        });

        bn3 = (Button) findViewById(R.id.buC);
        bn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=
                        new AlertDialog.Builder(MainActivity.this);
                final View viewDialog = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog,null,false);
                builder.setTitle("登陆")
                        .setView(viewDialog)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText editTextUserId = viewDialog.findViewById(R.id.UserId);
                                EditText editTextUserPassWord = viewDialog.findViewById(R.id.UserPassWord);
                                if(editTextUserId.getText().toString().equals("abc") && editTextUserPassWord.getText().toString().equals("123"))
                                {
                                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                                }
                                else
                                    Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.create().show();
            }
        });
        bn4 = (Button) findViewById(R.id.buD);
        bn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,otherActivity.class);
                intent.putExtra("name","Liukehong");
                intent.putExtra("age",20);
                startActivityForResult(intent,0);
            }
        });
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 0 && resultCode == 0)
        {
            String str = data.getStringExtra("result");
            Toast.makeText(this,str,Toast.LENGTH_LONG).show();
        }
    }
}
