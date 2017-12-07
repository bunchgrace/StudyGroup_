package edu.fsu.cs.mobile.studygroup_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class create_group extends AppCompatActivity {

    private String course;
    private Button createGroup;
    private EditText courseNum;
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    private FirebaseUser user;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;
    private String UID;
    int temp;
    private DatabaseReference mUserReference;

    DatabaseReference dbGroup = db.child("groups");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        createGroup = (Button) findViewById(R.id.create_group);
        courseNum = (EditText) findViewById(R.id.course_num);

        //to increment points - grace
        auth= FirebaseAuth.getInstance();
        user= auth.getCurrentUser();
        UID=user.getUid();
        mDatabase= FirebaseDatabase.getInstance().getReference();
        mUserReference= FirebaseDatabase.getInstance().getReference().child("users").child(user.getUid());



        createGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add 30 points for creating a group
                mDatabase.child("users").child(UID).child("points").setValue(temp+30);


                course = courseNum.getText().toString();
                dbGroup.setValue(course);
                Intent intent = new Intent(create_group.this, MainActivity.class);
                startActivity(intent);
            }
        });
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
