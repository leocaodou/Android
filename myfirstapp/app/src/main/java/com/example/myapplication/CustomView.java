package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private int isDowm = 0;
    private int y = 0;
    private Paint paint;
    private Path path;
    private Path mpath;
    public CustomView(Context context, AttributeSet attrs) {
        super(context,attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        path = new Path();
        mpath = new Path();
    }
    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
        canvas.drawPath(mpath,paint);
        mpath.reset();
    }
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            startX = event.getX();
            startY = event.getY();
            path.moveTo(event.getX(),event.getY());
            isDowm = 1;
        }
        else if(event.getAction() == MotionEvent.ACTION_UP){
            path.lineTo(event.getX(),event.getY());
            isDowm = 0;
            invalidate();
            return true;
        }
        else if(event.getAction() == MotionEvent.ACTION_MOVE && isDowm == 1){
            mpath.moveTo(startX,startY);
            mpath.lineTo(event.getX(),event.getY());
            invalidate();
            return true;
        }
        return true;
    }
}
