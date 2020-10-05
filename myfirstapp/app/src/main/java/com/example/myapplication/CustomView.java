package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {

    public CustomView(Context context, AttributeSet attrs) {
        super(context,attrs);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(10, 10, 100, 100, paint);
        Path path=new Path();
        path.moveTo(10, 120);
        path.lineTo(200, 120);
        path.lineTo(100, 200);
        path.close();
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
        paint.setTextSize(12);
        paint.setColor(Color.BLUE);
        paint.setStrikeThruText(true);
        canvas.drawText("hello world", 10, 200, paint);
        Path pathText=new Path();
        pathText.addCircle(200,300,80, Path.Direction.CCW);
        canvas.drawTextOnPath("Draw the text, with origin at (x,y), using the specified paint, along the specified path.",pathText,0,10,paint);
    }
}
