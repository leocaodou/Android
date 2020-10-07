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
    private Bitmap bitmap = null;
    public CustomView(Context context, AttributeSet attrs) {
        super(context,attrs);
        bitmap = Bitmap.createBitmap(getWidth(),getHeight(),Bitmap.Config.ARGB_8888);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(HandWriting(bitmap), 0, 0,null);
    }
    public Bitmap HandWriting(Bitmap bm){
        Canvas canvas =new Canvas(bm);
        Paint paint = new Paint();
        if(startX != -1 && startY != -1) {
            canvas.drawLine(startX, startY, endX, endY, paint);
            startX = -1;
            startY = -1;
        }
        return bm;
    }
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            if(startX == -1 && startY == -1){
                startX = event.getX();
                startY = event.getY();
                invalidate();
                return true;
            }
        }
        else if(event.getAction() == MotionEvent.ACTION_UP){
            endX = event.getX();
            endY = event.getY();
            invalidate();
            return true;
        }
        return super.onTouchEvent(event);
    }
}
