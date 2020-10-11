package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.musicplayer.musiccontract.Music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ArrayList<Map<String ,String>> musics ;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.musiclist);
        musics = getMusiclist();
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,musics,R.layout.item,new String[]{"path","name","singer","time"},new int[]{R.id.path,R.id.musicName,R.id.musicSinger,R.id.time});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    private ArrayList<Map<String,String>> getMusiclist(){
        Cursor cursor = getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        ArrayList<Map<String,String>> arr = new ArrayList();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            String name = cursor.getString((cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)));
            String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            int duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION))/1000;
            String fen,miao;
            if(duration/60 < 10)
                fen = '0' + String.valueOf(duration / 60);
            else
                fen = String.valueOf(duration / 60);
            if(duration % 60 < 10)
                miao = '0' + String.valueOf(duration % 60);
            else
                miao = String.valueOf(duration % 60);
            String time = fen + ':' + miao;
            String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            int isMusic = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));
            if (isMusic != 0) {
                Map<String,String> map = new HashMap<>();
                map.put("path",url);
                map.put("name",name);
                map.put("singer",singer);
                map.put("time",time);
                arr.add(map);
            }
        }
        return arr;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this,MusicActivity.class);
        intent.putExtra("position",position);
        startActivityForResult(intent,0);
    }
}