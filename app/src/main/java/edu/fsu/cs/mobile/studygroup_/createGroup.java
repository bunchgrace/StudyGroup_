package edu.fsu.cs.mobile.studygroup_;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class createGroup extends AppCompatActivity {
    Intent intent;
    private FirebaseAuth auth;
    private FirebaseAnalytics fba;
    private FirebaseUser user;
    private DatabaseReference mDatabase;
    private String UID;
    private DatabaseReference mUserReference;
    int temp;

    EditText courseCode;
    EditText groupName;
    EditText instructor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        fba = FirebaseAnalytics.getInstance(this);
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        courseCode = (EditText) findViewById(R.id.createCourseCode);
        groupName = (EditText) findViewById(R.id.createGroupName);
        instructor = (EditText) findViewById(R.id.createInstructor);
        user= auth.getCurrentUser();
        UID=user.getUid();
        mDatabase= FirebaseDatabase.getInstance().getReference();
        mUserReference= FirebaseDatabase.getInstance().getReference().child("users").child(user.getUid());

        Button create = (Button) findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDatabase.child("users").child(UID).child("points").setValue(temp+30);
                groupCreate();
                intent = new Intent(createGroup.this, groupPage.class);
                startActivity(intent);
            }
        });
    }
        void groupCreate(){
            Map<String, Object> map = new HashMap<>();
            map.put("courseCode", courseCode.getText().toString());
            map.put("groupName", groupName.getText().toString());
            map.put("instructor", instructor.getText().toString());
            map.put("groupOwner", UID);

            mDatabase.child("groups").child(courseCode.getText().toString()+groupName.getText().toString()).setValue(map);
            mDatabase.child("users").child(UID).child("groups").child(groupName.getText().toString()).setValue(courseCode.getText().toString()+groupName.getText().toString());
        }
    
    //USE THIS TO GET THE CURRENT POINTS AND THEN INCREMENT POINTS - GRACE
    public void onStart(){
        super.onStart();

        //to get the current points.
        ValueEventListener userListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //get UserInformation object and use the values to update UI
                UserInformation ui = dataSnapshot.getValue(UserInformation.class);
                temp = ui.getPoints();
                //Add 20 points for creating an event


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        mUserReference.addValueEventListener(userListener);
    }
}
