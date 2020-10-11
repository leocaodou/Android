package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.musicplayer.musiccontract.Music;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MusicActivity extends AppCompatActivity {
    private TextView name,singer,now,total;
    private SeekBar seekBar;
    private Button pause,next,last;
    private boolean isSeekBarChanging;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private SimpleDateFormat format;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        format = new SimpleDateFormat("mm:ss");
        name = (TextView) findViewById(R.id.name);
        singer =  (TextView) findViewById(R.id.singer);
        now =  (TextView)findViewById(R.id.now);
        total =  (TextView)findViewById(R.id.total);
        seekBar = (SeekBar) findViewById(R.id.line);
        pause = (Button) findViewById(R.id.pause);
        next = (Button) findViewById(R.id.next);
        last = (Button) findViewById(R.id.last);
        seekBar.setOnSeekBarChangeListener(new MySeekBar());
        ArrayList<Music> musics = getMusiclist();
        final Intent data = getIntent();
        int position = data.getIntExtra("position",-1);
        if(position == -1){
            name.setText("无法读取");
            return;
        }
        Music music = musics.get(position);
        setMusic(music);

    }
    private ArrayList<Music> getMusiclist(){
        Cursor cursor = getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        ArrayList<Music> musics = new ArrayList<Music>();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            String name = cursor.getString((cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)));
            String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            int duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION))/1000;
            String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            int isMusic = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));
            if (isMusic != 0) {
                Music music = new Music(url,name,singer,duration);
                musics.add(music);
            }
        }
        return musics;
    }
    private void setMusic(Music music){
        name.setText(music.getName());
        singer.setText(music.getSinger());
        total.setText(format.format(music.getTime()));
        try {
            mediaPlayer.setDataSource(music.getPath());
            mediaPlayer.prepare();
            mediaPlayer.setLooping(true);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mp) {
                    seekBar.setMax(mediaPlayer.getDuration());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    public class MySeekBar implements SeekBar.OnSeekBarChangeListener {

        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
        }

        /*滚动时,应当暂停后台定时器*/
        public void onStartTrackingTouch(SeekBar seekBar) {
            isSeekBarChanging = true;
        }

        /*滑动结束后，重新设置值*/
        public void onStopTrackingTouch(SeekBar seekBar) {
            isSeekBarChanging = false;
            mediaPlayer.seekTo(seekBar.getProgress());
        }
    }

}