package com.example.gobang.GamePlay;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

public class PaintBoard {
    private int w, h;
    private final int jianju = 62;
    private int numline, numcolumn;

    private Paint paint;

    private final int radius = 20;
    private int cx, cy;
    private int cLine, cColumn;
    private boolean isBlack;
    private List<Point> list;

    public PaintBoard(ChessBoard cb) {
        this.w = cb.w;
        this.h = cb.h;

        numline = h / jianju;
        numcolumn = w / jianju;
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(4);
        list = new ArrayList<Point>();
    }

    public void setGo(int eventx, int eventy) {
        cColumn = eventx / jianju;
        cLine = eventy / jianju;

        int modex = eventx % jianju;
        int modey = eventy % jianju;

        if (modex < jianju / 2 && modey < jianju / 2) {

        } else if (modex > jianju / 2 && modey < jianju / 2) {
            cColumn += 1;
        } else if (modex < jianju / 2 && modey > jianju / 2) {
            cLine += 1;
        } else if (modex > jianju / 2 && modey > jianju / 2) {
            cLine += 1;
            cColumn += 1;
        }
        cx = cColumn * jianju;
        cy = cLine * jianju;
        for (int i = 0; i < list.size(); i++) {
            Point p = list.get(i);
            if (p.x == cx && p.y == cy) {
                return;
            }
        }
        list.add(new Point(cx, cy));
    }

    public void DrawLine(Canvas canvas) {

        paint.setColor(Color.BLACK);
        int i = 0;
        for (i = 0; i <= numline; i++) {
            canvas.drawLine(0, jianju * i, w, jianju*i, paint);
        }
        for (i = 0; i <= numcolumn; i++) {
            canvas.drawLine(jianju * i, 0,jianju*i,h, paint);
        }

    }

    public void DrawPoint(Canvas canvas) {
        Point p=null;
        paint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < list.size(); i++) {
            paint.setColor(i%2==1?Color.BLACK:Color.WHITE);
            p=list.get(i);
            canvas.drawCircle(p.x, p.y, radius, paint);
        }
    }
}
