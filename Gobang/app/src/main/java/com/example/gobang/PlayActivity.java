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
    ImageView robot;
    ChessBoard chessBoard;
    ImageButton regret,end;
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
                robot.setImageDrawable(getResources().getDrawable(R.drawable.hello));
            }
        });
        robot = (ImageView)findViewById(R.id.robot);
        robot.setImageDrawable(getResources().getDrawable(R.drawable.hello));
        end = (ImageButton)findViewById(R.id.lose);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robot.setImageDrawable(getResources().getDrawable(R.drawable.vegetables));
                chessBoard.locked();
            }
        });
    }

    @Override
    public void onBoardClick(int x) {
        switch (x) {
            case -1:
            case 0:
                return;
            case 1:
                robot.setImageDrawable(getResources().getDrawable(R.drawable.six));
                chessBoard.locked();
                return;
            case 2:
                robot.setImageDrawable(getResources().getDrawable(R.drawable.vegetables));
                chessBoard.locked();
        }
    }
}