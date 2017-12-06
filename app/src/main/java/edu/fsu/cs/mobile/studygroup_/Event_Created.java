package edu.fsu.cs.mobile.studygroup_;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Event_Created extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_created);

            Intent intent1 = getIntent();
        //if(getIntent().hasExtra("com.example.khawly.myapplication.quicklauncher.event")){
            TextView en1 =  (TextView) findViewById(R.id.EN);
            String text = intent1.getExtras().getString("event");
            en1.setText(text);
     //   }

    //    if(getIntent().hasExtra("com.example.khawly.myapplication.quicklauncher.date")){
            TextView dt1 = (TextView) findViewById(R.id.DT);
            String text1 = intent1.getExtras().getString("date");
            dt1.setText(text1);
    //    }

            TextView tm1 = (TextView) findViewById(R.id.TM);
            String text3 = intent1.getExtras().getString("time");
            tm1.setText(text3);

    //    if(getIntent().hasExtra("com.example.khawly.myapplication.quicklauncher.location")){
            TextView loc1 = (TextView) findViewById(R.id.LOC);
            String text2 = intent1.getExtras().getString("location");
            loc1.setText(text2);
     //   }
    }
}
