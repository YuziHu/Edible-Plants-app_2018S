package com.example.mitch.ediblelandscapes;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.service.autofill.Dataset;
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
    List<AnnounceItem> announceItemList = new ArrayList<>();
    List<String> announcementTitles = new ArrayList<>();
    List<String> announcementDesc = new ArrayList<>();
    int images = R.drawable.announcement_icon;
    List<String> announcementDate = new ArrayList<>();
    List<String> announcementTime = new ArrayList<>();
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annoucement);

        // Tests
//        announcementTitles.add("New Vegetables!");
//        announcementDesc.add("There will be new veggies upcoming!");
//        announcementDate.add("11/04/2019");
//        announcementTime.add("11am");

        listView = findViewById(R.id.announcementList);

        adapter = new CustomAdapter(this, announcementTitles, announcementDesc, images, announcementDate, announcementTime);
        listView.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference announcementRef = database.getReference("announcements");
        announcementRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                announceItemList.clear();
                for(DataSnapshot announceData : dataSnapshot.getChildren()){
                    AnnounceItem item = announceData.getValue(AnnounceItem.class);
                    announceItemList.add(item);
                    announcementTitles.add(item.getTitle());
                    announcementDesc.add(item.getDescription());
                    announcementDate.add(item.getDate());
                    announcementTime.add(item.getTime());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//        for(AnnounceItem item : announceItemList){
//            announcementTitles.add(item.getTitle());
//            announcementDesc.add(item.getDescription());
//            announcementDate.add(item.getDate());
//            announcementTime.add(item.getTime());
//        }
//        announcementRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                announceItemList.clear();
//                for(DataSnapshot announceData : dataSnapshot.getChildren()){
//                    AnnounceItem item = announceData.getValue(AnnounceItem.class);
//                    announceItemList.add(item);
//                }
//                for(AnnounceItem item : announceItemList){
//                    announcementTitles.add(item.getAnnouncementTitle());
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

    }

    // back to homepage
    //Intent home = new Intent(Announcement.this, MainActivity.class);
    //public void backToHomepage(){
    //    startActivity(home);
    //}

    class CustomAdapter extends ArrayAdapter<String> {
        Context context;
        List<String> rTitles;
        List<String> rDescriptions;
        int rImage;
        List<String> rDates;
        List<String> rTimes;

        CustomAdapter(Context c, List<String> titles, List<String> descriptions, int images, List<String> dates, List<String> times) {
            super(c, R.layout.single_announcement, R.id.titleView, titles);
            this.context = c;
            this.rTitles = titles;
            this.rDescriptions = descriptions;
            this.rImage = images;
            this.rDates = dates;
            this.rTimes = times;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View single_announcement = layoutInflater.inflate((R.layout.single_announcement),parent, false);
            ImageView images = single_announcement.findViewById(R.id.image);
            TextView myTitle = single_announcement.findViewById(R.id.titleView);
            TextView myDescription = single_announcement.findViewById(R.id.descView);
            TextView myDates = single_announcement.findViewById(R.id.dateView);
            TextView myTimes = single_announcement.findViewById(R.id.timeView);


            images.setImageResource(rImage);
            myTitle.setText(rTitles.get(position));
            myDescription.setText(rDescriptions.get(position));
            myDates.setText(rDates.get(position));
            myTimes.setText(rTimes.get(position));

            return single_announcement;
        }
    }
}
