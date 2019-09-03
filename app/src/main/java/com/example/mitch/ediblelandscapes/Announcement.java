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
    String annoucementDate[] = {"04/24/2018"};
    String annoucementTime[] = {"11am"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annoucement);

        listView = findViewById(R.id.announcementList);

        CustomAdapter adapter = new CustomAdapter(this, announcementTitles, announcementDesc, images, annoucementDate, annoucementTime);
        listView.setAdapter(adapter);

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
        String rDates[];
        String rTimes[];

        CustomAdapter(Context c, String title[], String descriptions[], int images[], String dates[], String times[]) {
            super(c, R.layout.single_announcement, R.id.titleView, title);
            this.context = c;
            this.rTitles = title;
            this.rDescriptions = descriptions;
            this.rImages = images;
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


            images.setImageResource(rImages[position]);
            myTitle.setText(rTitles[position]);
            myDescription.setText(rDescriptions[position]);
            myDates.setText(rDates[position]);
            myTimes.setText(rTimes[position]);

            return single_announcement;
        }
    }
}
