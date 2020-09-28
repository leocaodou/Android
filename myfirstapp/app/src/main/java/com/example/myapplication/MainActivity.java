package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    TextView show;
    Button bn1;
    Button bn2;
    Button bn3;
    Button bn4,bn5,bn6,bn7,bn8,bn9,bn10,bn11,bn12,bn13,bn14;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private final static String SharedPreferenceFileName = "NI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = findViewById(R.id.num);
        bn1 = (Button) findViewById(R.id.buA);
        Log.v("MainActivity","这是onCreate()");
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
                        .setNegativeButton(("取消"), new DialogInterface.OnClickListener() {
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
                intent.putExtra("a","刘科宏");
                intent.putExtra("name","Liukehong");
                intent.putExtra("age",20);
                startActivityForResult(intent,0);
            }
        });
        bn5 = (Button) findViewById(R.id.buE);
        bn5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,fuduji.class);
                startActivityForResult(intent,1);
            }
        });
        bn6 = (Button) findViewById(R.id.buF);
        bn6.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
        bn7 = (Button) findViewById(R.id.buG);
        preferences = getSharedPreferences(SharedPreferenceFileName,MODE_PRIVATE);
        editor = preferences.edit();
        bn7.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                editor.putString("StudentName","刘科宏");
                editor.putString("StudentId","2018011252");
                editor.apply();
            }
        });
        bn8 = (Button) findViewById(R.id.buH);
        bn8.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                String StuId = preferences.getString("StudentId",null);
                String StuName = preferences.getString("StudentName",null);
                if(StuId != null && StuName != null)
                {
                    Toast.makeText(MainActivity.this,"学生姓名为" + StuName + "学生学号为" + StuId,Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(MainActivity.this,"还未记录学生信息",Toast.LENGTH_LONG).show();
            }
        });
        bn9 = (Button) findViewById(R.id.buI);
        bn9.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            public void onClick(View view) {
                OutputStream out = null;
                try {
                    FileOutputStream fileOutputStream = openFileOutput("StuInform",MODE_PRIVATE);
                    out = new BufferedOutputStream(fileOutputStream);
                    String inform = "刘科宏2018011252";
                    try {
                        out.write(inform.getBytes(StandardCharsets.UTF_8));
                        Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_LONG).show();
                    }
                    finally {
                        if (out != null)
                            out.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bn10 = (Button) findViewById(R.id.buJ);
        bn10.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                InputStream in = null;
                try {
                    FileInputStream fileInputStream = openFileInput("StuInform");
                    in = new BufferedInputStream(fileInputStream);
                    int c;
                    StringBuilder stringBuilder = new StringBuilder("");
                    try {
                        while ((c=in.read())!=-1)
                        {
                            stringBuilder.append((char) c);
                        }
                        String s = new String(stringBuilder.toString().getBytes("iso8859-1"),"UTF-8");
                        Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
                    }
                    finally {
                        if (in != null)
                            in.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        bn11 = (Button) findViewById(R.id.buK);
        preferences = getSharedPreferences(SharedPreferenceFileName,MODE_PRIVATE);
        editor = preferences.edit();
        bn11.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
                while(cursor.moveToNext())
                {
                    String msg;
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    msg = "id" + id;
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    msg = msg + "name" + name;
                    Cursor pns = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + id,null,null);
                    while(pns.moveToNext())
                    {
                        String pn = pns.getString(pns.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        msg = msg + "phone:" + pn;

                    }
                    Cursor emails = getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI,null,ContactsContract.CommonDataKinds.Email.CONTACT_ID + "=" + id,null,null);
                    while(emails.moveToNext())
                    {
                        String email = emails.getString(emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                        msg = msg + "Email:" + email;

                    }
                    Log.v("TAG",msg);
                }
            }
        });
        bn12 = (Button) findViewById(R.id.buL);
        bn12.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                Uri uri = Uri.parse("content://com.example.vocabularybook.provider/words");
                ContentValues values = new ContentValues();
                values.put("word","liu");
                getContentResolver().insert(uri,values);
            }
        });
        bn13 = (Button) findViewById(R.id.buM);
        bn13.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                Uri uri = Uri.parse("content://com.example.vocabularybook.provider/words");
                getContentResolver().delete(uri,"_id = ?",new String[] {"2"});
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
    protected void onStart() {
        super.onStart();
        Log.v("MainActivity","这是onStart()");
    }

    protected void onRestart() {
        super.onRestart();
        Log.v("MainActivity", "这是onRestart()");
    }

    protected void onResume() {
        super.onResume();
        Log.v("MainActivity", "这是onResume()");
    }

    protected void onPause() {
        super.onPause();
        Log.v("MainActivity", "这是onPause()");
    }

    protected void onStop() {
        super.onStop();
        Log.v("MainActivity", "这是onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.v("MainActivity", "这是onDestroy()");
    }
}
