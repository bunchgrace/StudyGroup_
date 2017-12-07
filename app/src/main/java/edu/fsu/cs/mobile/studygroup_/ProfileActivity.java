package edu.fsu.cs.mobile.studygroup_;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by gracebunch on 12/6/17.
 */

public class ProfileActivity  extends AppCompatActivity {
    private FirebaseUser user;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;
    private String UID;
    private DatabaseReference mUserReference;


    TextView username;
    TextView points;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        auth= FirebaseAuth.getInstance();

        user= auth.getCurrentUser();

        mUserReference= FirebaseDatabase.getInstance().getReference().child("users").child(user.getUid());
        UID=user.getUid();
        mDatabase= FirebaseDatabase.getInstance().getReference();
        //mDatabase.child("users").child(user.getUid()).child("points").setValue("10");
        //sets displayname as username in this fragment  - doesn't work if register first
        points = (TextView) findViewById(R.id.points_display);
        username= (TextView) findViewById(R.id.user_display);




    }
    public void onStart(){
        super.onStart();

        //for updating the TextView with the username and current points
        ValueEventListener userListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //get UserInformation object and use the values to update UI
                UserInformation ui = dataSnapshot.getValue(UserInformation.class);
                username.setText(ui.getUsername());


                /* don't uncomment this - will use this code for incrementing points
                 * in event/group creation and joining
                 *
                int temp = ui.getPoints();
                mDatabase.child("users").child(UID).child("points").setValue(temp+10);

                */
                points.setText(String.valueOf((Integer) ui.getPoints()));


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mUserReference.addValueEventListener(userListener);

    }


}