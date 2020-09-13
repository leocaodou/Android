package com.example.myapplication.model;

public class UserMessage {
    public static final int TYPE_RECEIVE = 1;
    public static final int TYPE_SEND = 0;
    private String content;
    private int come;

    public UserMessage(String content, int come) {
        this.content = content;
        this.come = come;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCome() {
        return come;
    }

    public void setCome(int come) {
        this.come = come;
    }
}
