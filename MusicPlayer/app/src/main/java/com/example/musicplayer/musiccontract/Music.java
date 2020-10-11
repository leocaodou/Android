package com.example.musicplayer.musiccontract;

public class Music {
    private String path;
    private String name;
    private String singer;
    private int time;

    public Music(String path,String name,String singer,int time) {
        this.path = path;
        this.name = name;
        this.singer = singer;
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
