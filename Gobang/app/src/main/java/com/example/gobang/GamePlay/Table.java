package com.example.gobang.GamePlay;

import android.graphics.Point;

import java.util.Stack;

public class Table {
    private int lastX = 0;  //记录上一次下棋的位置坐标
    private int lastY = 0;
    private int last;
    private Stack<Point> point = new Stack<>();
    public int bord[][] = new int[][]
    {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };
    public int getGoType(int x,int y){
        return bord[x][y];
    }
    void add(Position p,int who)
    {
        bord[p.getX()-1][p.getY()-1] = who;
        lastX = p.getX() - 1;
        lastY = p.getY() - 1;
        last = who;
        point.push(new Point(p.getX()-1,p.getY()-1));
    }
    void add2(int x,int y,int who)
    {
        bord[x][y] = who;
        lastX = x;
        lastY = y;
        last = who;
        point.push(new Point(x,y));
    }
    void DeleteP(int x,int y)
    {
        bord[x][y] = 0;
    }
    void Back(){
        Point p = point.peek();
        bord[p.x][p.y] = 0;
        point.pop();
    }
    boolean empty(int a,int b)
    {
        return bord[a][b] == 0;
    }

    public int getLastX() {
        return lastX;
    }

    public void setLastX(int lastX) {
        this.lastX = lastX;
    }

    public int getLastY() {
        return lastY;
    }

    public void setLastY(int lastY) {
        this.lastY = lastY;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
}
