package com.pm.colorapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "color")
public class Color {
    @PrimaryKey(autoGenerate = true)
    int id;
    private String colorCode;
    private long time;
    @NonNull
    private String date;

    public Color(String colorCode, long time, @NonNull String date) {
        this.colorCode = colorCode;
        this.time = time;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorCode() {
        return colorCode;
    }
    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public long getTime() {
        return time;
    }


    public void setTime(long time) {
        this.time = time;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }
}


