package com.example.victor.less3110.model;

/**
 * Created by Victor on 07.11.2016.
 */

public class Note {
    //DATA CLASS

    //m - member

    private String mText = null;
    private String mTitle = null;
    private long mTime = 0;

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long mTime) {
        this.mTime = mTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
