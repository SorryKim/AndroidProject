package com.example.myproject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Memo implements Serializable {
    final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    float score;
    String content;
    Date date;
    boolean checked;


    public Memo(){}
    public Memo(float score, String content, Date date) {
        this.score = score;
        this.content = content;
        this.date = date;
    }

    public float getScore() {
        return score;
    }

    public void setTitle(Float score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateFormatted() {
        return format.format(date);
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String body) {
        this.content = body;
    }
}