package com.example.gobang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

import com.example.gobang.GamePlay.ChessBoard;

public class PlayActivity extends AppCompatActivity {
    ImageView frame1,frame2,frame3,frame4;
    ChessBoard chessBoard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_play);

    }
}