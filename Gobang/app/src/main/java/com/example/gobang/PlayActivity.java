package com.example.gobang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import com.example.gobang.GamePlay.ChessBoard;

public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ChessBoard chesss=new ChessBoard(this);
        chesss.setY(this.getResources().getDisplayMetrics().heightPixels/4);
        chesss.setX(this.getResources().getDisplayMetrics().widthPixels/20);
        setContentView(chesss);
    }
}