package com.example.gobang.GamePlay;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class ChessBoard extends View {
    public int w;
    public int h;
    PaintBoard hua;

    public ChessBoard(Context context) {
        super(context);
        w = context.getResources().getDisplayMetrics().widthPixels;
        h = context.getResources().getDisplayMetrics().heightPixels;
        hua=new PaintBoard(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制线
        hua.DrawLine(canvas);
        //绘制棋子
        hua.DrawPoint(canvas);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            /// int event=(int)event.GetX()
            int eventx=(int)event.getX();
            int eventy=(int)event.getY();
            hua.setGo(eventx,eventy);
        }
        return true;
    }
}
