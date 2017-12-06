package edu.fsu.cs.mobile.studygroup_;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


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

        Button button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Eventname = (EditText) findViewById(R.id.Eventname);
                EditText Date = (EditText) findViewById(R.id.Date);
                EditText Time = (EditText) findViewById(R.id.Time);
                EditText Location = (EditText) findViewById(R.id.Location);

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

              Intent intent1 = new Intent(getApplicationContext(), Event_Created.class);
              intent1.putExtra("event", en);
              intent1.putExtra("date", dt);
              intent1.putExtra("time", tm);
              intent1.putExtra("location", loc);
              startActivity(intent1);
            }
        });
    }
}


