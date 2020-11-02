package com.example.gobang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.gobang.GamePlay.ChessBoard;

public class PlayActivity extends AppCompatActivity implements ChessBoard.OnClickListener{
    ImageView frame1,frame2,frame3,frame4;
    ChessBoard chessBoard;
    ImageButton regret;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_play);
        chessBoard = (ChessBoard)findViewById(R.id.chessboard);
        regret = (ImageButton)findViewById(R.id.regret);
        regret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chessBoard.Regret();
            }
        });

    }

    @Override
    public void onBoardClick() {

    }
}