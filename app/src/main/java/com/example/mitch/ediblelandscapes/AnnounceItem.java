package com.example.mitch.ediblelandscapes;

/**
 * Created by Yuzi Hu on 4/5/18.
 */

public class AnnounceItem {
    private String title;
    private String description;
//    private String announcementDescSmall;
    private String time;
    private String date;
    private int imageID;

    public AnnounceItem() {
    }

    public AnnounceItem(String title, String description, String time, String date, int imageID) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.date = date;
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
