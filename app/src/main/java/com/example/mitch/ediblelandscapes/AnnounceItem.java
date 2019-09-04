package com.example.mitch.ediblelandscapes;

/**
 * Created by Yuzi Hu on 4/5/18.
 */

public class AnnounceItem {
    private String title;
    private String description;
    private String announcementDescSmall;
    private String time;
    private String date;
    private int imageID;

    public AnnounceItem(String title, String description, String time, String date) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.date = date;
        this.imageID = R.drawable.announcement_icon;
    }

    public String getAnnouncementTitle() {
        return this.title;
    }

    public String getAnnouncementDesc() {
        return this.description;
    }

    public String getTime() {
        return this.time;
    }

    public String getDate() {
        return this.date;
    }

    public int getImageID() {
        return this.imageID;
    }
}
