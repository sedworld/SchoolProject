package com.example.victor.less3110.model;

import com.example.victor.less3110.db.NotesContract;

import android.database.Cursor;


/**
 * Created by Victor on 07.11.2016.
 */

public class Note {
    //DATA CLASS

    //m - member

    private String mText = null;
    private String mTitle = null;
    private String mTime = null;


    public Note(Cursor data) {
        mTitle = data.getString(data.getColumnIndex(NotesContract.TITLE_COLUMN));
        mText = data.getString(data.getColumnIndex(NotesContract.TEXT_COLUMN));
        mTime = data.getString(data.getColumnIndex(NotesContract.TIME_COLUMN));
    }


    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
