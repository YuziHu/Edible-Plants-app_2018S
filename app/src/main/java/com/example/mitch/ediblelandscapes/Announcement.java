package com.example.mitch.ediblelandscapes;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Announcement extends AppCompatActivity {

    ListView listView;
    String announcementTitles[] = {"New Vegetables!"};
    String announcementDesc[] = {"There are new vegetables today!"};
    int images[] = {R.drawable.announcement_icon};
//    private List<AnnounceItem> newsFeed = new ArrayList<AnnounceItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annoucement);

        listView = findViewById(R.id.announcementList);

        CustomAdapter adapter = new CustomAdapter(this, announcementTitles, announcementDesc, images);
        listView.setAdapter(adapter);
//        newsFeed.add(new AnnounceItem("New Vegetables!", "There are new vegetables today!", "9am", "04/05/2018", R.mipmap.ic_launcher));
//
//        ArrayAdapter<AnnounceItem> adapter = new customAdapter();
//
//        ListView announcements = (ListView) (findViewById(R.id.announcementItems));
//        announcements.setAdapter(adapter);

    }

    // back to homepage
    //Intent home = new Intent(Announcement.this, MainActivity.class);
    //public void backToHomepage(){
    //    startActivity(home);
    //}

    class CustomAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitles[];
        String rDescriptions[];
        int rImages[];

        CustomAdapter(Context c, String title[], String descriptions[], int images[]) {
            super(c, R.layout.single_announcement, R.id.titleView, title);
            this.context = c;
            this.rTitles = title;
            this.rDescriptions = descriptions;
            this.rImages = images;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View single_announcement = layoutInflater.inflate((R.layout.single_announcement),parent, false);
            ImageView images = single_announcement.findViewById(R.id.image);
            TextView myTitle = single_announcement.findViewById(R.id.titleView);
            TextView myDescription = single_announcement.findViewById(R.id.descView);

            images.setImageResource(rImages[position]);
            myTitle.setText(rTitles[position]);
            myDescription.setText(rDescriptions[position]);

            return single_announcement;
        }

        //        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            if (convertView == null) {
//                convertView = getLayoutInflater().inflate(R.layout.news, parent, false);
//            }
//
//            AnnounceItem currAnnounce = newsFeed.get(position);
//
//            ImageView newsPhoto = (ImageView) convertView.findViewById(R.id.newsPhoto);
//            TextView newsTitle = (TextView) convertView.findViewById(R.id.newsTitle);
//            TextView newsDesc = (TextView) convertView.findViewById(R.id.newsDesc);
//
//            newsPhoto.setImageResource(currAnnounce.getImageID());
//            newsTitle.setText(currAnnounce.getAnnouncementTitle());
//            newsDesc.setText(currAnnounce.getAnnouncementDesc());
//
//            return convertView;
//        }
    }
}
