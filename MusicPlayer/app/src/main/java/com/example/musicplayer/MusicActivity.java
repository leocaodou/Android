package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.musicplayer.musiccontract.Music;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class MusicActivity extends AppCompatActivity {
    private TextView name,singer,now,total;
    private SeekBar seekBar;
    private Button pause,next,last;
    private ArrayList<Music> musics;
    private int position;
    private boolean isSeekBarChanging;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private SimpleDateFormat format;
    private Timer timer;
    private RadioGroup rg;
    private int how = 1;
    @SuppressLint("SimpleDateFormat")
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
        rg = (RadioGroup) findViewById(R.id.se);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                switch (how) {
                    case 1:
                        Music music = musics.get(position);
                        setMusic(music);
                        break;
                    case 2:
                        position++;
                        if(position == musics.size())
                            position = 0;
                        Music music2 = musics.get(position);
                        setMusic(music2);
                        break;
                    case 3:
                        position = (int)(Math.random()*(musics.size()));
                        Music music3 = musics.get(position);
                        setMusic(music3);
                        break;
                }
            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.round:
                        how = 1;
                        break;
                    case R.id.loop:
                        how = 2;
                        break;
                    case R.id.random:
                        how = 3;
                        break;
                }

            }
        });
        seekBar.setOnSeekBarChangeListener(new MySeekBar());
        musics = getMusiclist();
        pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
                else{
                    mediaPlayer.start();//开始播放
                }
            }
        });
        last.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (how) {
                    case 1:
                    case 2:
                        position--;
                        if(position == 0)
                            position = musics.size() - 1;
                        Music music = musics.get(position);
                        setMusic(music);
                        break;
                    case 3:
                        position = (int)(Math.random()*(musics.size()+1));
                        Music music2 = musics.get(position);
                        setMusic(music2);
                        break;
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (how) {
                    case 1:
                    case 2:
                        position++;
                        if(position == musics.size())
                            position = 0;
                        Music music = musics.get(position);
                        setMusic(music);
                        break;
                    case 3:
                        position = (int)(Math.random()*(musics.size()));
                        Music music2 = musics.get(position);
                        setMusic(music2);
                        break;
                }
            }
        });
        final Intent data = getIntent();
        position = data.getIntExtra("position",-1);
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
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(music.getPath());
            mediaPlayer.prepare();
            mediaPlayer.setLooping(false);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @SuppressLint("SetTextI18n")
                public void onPrepared(MediaPlayer mp) {
                    seekBar.setMax(mediaPlayer.getDuration());
                    total.setText(format.format(mediaPlayer.getDuration()) + "");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
        if(timer == null)
            timer = new Timer();
        else {
            timer.cancel();
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            Runnable updateUI = new Runnable() {
                @SuppressLint("SetTextI18n")
                @Override
                public void run() {
                    now.setText(format.format(mediaPlayer.getCurrentPosition()) + "");
                }
            };
            public void run() {
                if (!isSeekBarChanging) {
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    runOnUiThread(updateUI);
                }
            }
        }, 0, 50);
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

    protected void onDestroy() {
        super.onDestroy();
        isSeekBarChanging = true;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

}