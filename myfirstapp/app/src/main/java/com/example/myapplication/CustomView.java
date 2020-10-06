package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CustomView extends View {
    private float startX = -1;
    private float startY = -1;
    private float endX = -1;
    private float endY = -1;
    public CustomView(Context context, AttributeSet attrs) {
        super(context,attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        
    }

    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            if(startX == -1 && startY == -1){
                startX = event.getX();
                startY = event.getY();
            }
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            endX = event.getX();
            endY = event.getY();

        }
    }
}
