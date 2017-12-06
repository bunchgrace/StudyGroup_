package edu.fsu.cs.mobile.studygroup_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.content.Intent;
import android.view.View;

import com.google.firebase.database.*;


public class groupPage extends AppCompatActivity {

    TextView textUser1, textUser2, textUser3, textUser4;
    Button eventButton;

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference user1Ref = rootRef.child("user");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_page);
        eventButton = (Button) findViewById(R.id.events);
        textUser1 = (TextView) findViewById(R.id.user1);
        textUser2 = (TextView) findViewById(R.id.user2);
        textUser3 = (TextView) findViewById(R.id.user3);
        textUser4 = (TextView) findViewById(R.id.user4);

        eventButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                goToEventPage();

            }

        });
    }

    private void goToEventPage() {
        Intent intent = new Intent(this, eventPage.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        user1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String username1 = dataSnapshot.toString();
                textUser1.setText(username1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

