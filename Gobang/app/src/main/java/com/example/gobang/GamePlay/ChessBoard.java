package com.example.gobang.GamePlay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.example.gobang.R;

public class ChessBoard extends View {
    public int w;
    public int h;
    PaintBoard draw;
    Context context;
    private OnClickListener mListener;
    public interface  OnClickListener{

        public void onBoardClick(); //单击事件处理接口

    }
    public ChessBoard(Context context) {
        super(context);
        this.context = context;
        mListener = (OnClickListener) context;
        w = context.getResources().getDisplayMetrics().widthPixels*9/10;
        h = context.getResources().getDisplayMetrics().heightPixels/2;
        draw=new PaintBoard(this);
        this.setBackgroundResource(R.drawable.wood);
    }
    public ChessBoard(Context context, AttributeSet attrs)
    {
        super(context,attrs);
        this.context = context;
        mListener = (OnClickListener) context;
        w = context.getResources().getDisplayMetrics().widthPixels*9/10-55;
        h = context.getResources().getDisplayMetrics().heightPixels/2;
        draw=new PaintBoard(this);
        this.setBackgroundResource(R.drawable.wood);
    }
    public ChessBoard(Context context, AttributeSet attrs,int defStyle){
        super(context,attrs,defStyle);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制线
        draw.DrawLine(canvas);
        //绘制棋子
        draw.DrawPoint(canvas);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            int eventx=(int)event.getX();
            int eventy=(int)event.getY();
            draw.setGo(eventx,eventy);
            if(mListener!= null)
                mListener.onBoardClick();
        }
        return true;
    }


    public void Regret(){
        draw.delete();
        invalidate();
    }
}
