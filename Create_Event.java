package com.example.khawly.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Create_Event extends AppCompatActivity {

    //DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event);
        // Toolbar toolbar;
        //Object id = null;
        //toolbar = (Toolbar) findViewById(id.toolbar);
        //  setSupportActionBar(toolbar);

        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Eventname = findViewById(R.id.Eventname);
                EditText Date = findViewById(R.id.Date);
                EditText Time = findViewById(R.id.Time);
                EditText Location = findViewById(R.id.Location);

                String en = Eventname.getText().toString();
                String dt = Date.getText().toString();
                String tm = Time.getText().toString();
                String loc = Location.getText().toString();

                DatabaseReference database = FirebaseDatabase.getInstance().getReference();

                DatabaseReference FBEventname = database.child("Event Name");
                DatabaseReference FBDate = database.child("Date");
                DatabaseReference FBTime = database.child("Time");
                DatabaseReference FBLocation = database.child("Location");

                FBEventname.setValue(en);
                FBDate.setValue(dt);
                FBTime.setValue(tm);
                FBLocation.setValue(loc);

                SimpleDateFormat parser = new SimpleDateFormat("mm/dd/yyyy");
                SimpleDateFormat parsert = new SimpleDateFormat("hh:mm aa");

                java.util.Date time = null;
                try {
                    time = parsert.parse(tm);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                java.util.Date date = null;
                try {
                    date = parser.parse(dt);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                SimpleDateFormat month = new SimpleDateFormat("mm");
                SimpleDateFormat day = new SimpleDateFormat("dd");
                SimpleDateFormat year = new SimpleDateFormat("yyyy");

                SimpleDateFormat hour = new SimpleDateFormat("hh");
                SimpleDateFormat minute = new SimpleDateFormat("mm");
                SimpleDateFormat ampm = new SimpleDateFormat("aa");

                String month1 = month.format(date);
                String day1 = day.format(date);
                String year1 = year.format(date);

                String hour1 = hour.format(time);
                String minute1 = minute.format(time);
                String ampm1 = ampm.format(time);


                if(ampm1.equalsIgnoreCase("pm")) {
                    int hour2 = Integer.parseInt(hour1);
                    hour2 = hour2 + 12;
                    hour1 = String.valueOf(hour2);
                }

                if(hour1.equalsIgnoreCase("12") && ampm1.equalsIgnoreCase("am"))
                {
                    int hour2 = Integer.parseInt(hour1);
                    hour2 = hour2 - 12;
                    hour1 = String.valueOf(hour2);
                }

                Intent intent1 = new Intent(getApplicationContext(), Event_Created.class);
              intent1.putExtra("event", en);
              intent1.putExtra("date", dt);
              intent1.putExtra("time", tm);
              intent1.putExtra("location", loc);
           //   intent1.putExtra("month", hour1);
             //  intent1.putExtra("day", minute1);
               // intent1.putExtra("year", ampm1);

                startActivity(intent1);
            }
        });
    }
}


