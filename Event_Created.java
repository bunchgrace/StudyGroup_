package com.example.khawly.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Event_Created extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_created);

            Intent intent1 = getIntent();
        //if(getIntent().hasExtra("com.example.khawly.myapplication.quicklauncher.event")){
            TextView en1 = findViewById(R.id.EN);
            String text = intent1.getExtras().getString("event");
            en1.setText(text);
     //   }

    //    if(getIntent().hasExtra("com.example.khawly.myapplication.quicklauncher.date")){
            TextView dt1 = findViewById(R.id.DT);
            String text1 = intent1.getExtras().getString("date");
            dt1.setText(text1);
    //    }

            TextView tm1 = findViewById(R.id.TM);
            String text3 = intent1.getExtras().getString("time");
            tm1.setText(text3);

    //    if(getIntent().hasExtra("com.example.khawly.myapplication.quicklauncher.location")){
            TextView loc1 = findViewById(R.id.LOC);
            String text2 = intent1.getExtras().getString("location");
            loc1.setText(text2);
     //   }

       /* TextView day1 = findViewById(R.id.DY);
        String text6 = intent1.getExtras().getString("day");
        day1.setText(text6);

        TextView month1 = findViewById(R.id.MN);
        String text7 = intent1.getExtras().getString("month");
        month1.setText(text7);

        TextView year1 = findViewById(R.id.YR);
        String text8 = intent1.getExtras().getString("year");
        year1.setText(text8);*/

          /*  SimpleDateFormat parser = new SimpleDateFormat("mm/dd/yyyy");

        Date date = null;
        try {
            date = parser.parse(text1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat month = new SimpleDateFormat("mm");
            SimpleDateFormat day = new SimpleDateFormat("dd");
            SimpleDateFormat year = new SimpleDateFormat("yyyy");

            String month1 = month.format(date);
            String day1 = day.format(date);
            String year1 = year.format(date);*/

      //  Intent checkin = new Intent(this, Checkin.class);

          // Calendar cal = Calendar.getInstance();
           // cal.set(Calendar.)

    }
}
