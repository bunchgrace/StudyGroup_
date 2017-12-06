package edu.fsu.cs.mobile.studygroup_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.content.Intent;
import android.view.View;

import com.google.firebase.database.*;

public class eventPage extends AppCompatActivity {

    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_page);
        create = (Button) findViewById(R.id.create_event);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                goToCreateEvent();
            }
        });
    }

    void goToCreateEvent() {
        Intent intent = new Intent(this, Create_Event.class);
        startActivity(intent);
    }
}
