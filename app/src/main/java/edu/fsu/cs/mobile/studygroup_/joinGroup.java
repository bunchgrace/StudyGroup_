package edu.fsu.cs.mobile.studygroup_;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class joinGroup extends AppCompatActivity {
    Intent intent;
    private FirebaseAuth auth;
    private FirebaseAnalytics fba;
    private FirebaseUser user;
    private DatabaseReference mDatabase;
    private DatabaseReference tempRef;
    private String UID;
    EditText course;
    EditText group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_group);

        fba = FirebaseAnalytics.getInstance(this);
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        course = (EditText) findViewById(R.id.courseCodeInput) ;
        group = (EditText) findViewById(R.id.groupName);
        user= auth.getCurrentUser();
        UID=user.getUid();

        Button searchButton = (Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tempRef = mDatabase.child("groups");
               tempRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.child(course.getText().toString()+group.getText().toString()).exists()) {
                            Toast.makeText(joinGroup.this, "Group Found",
                                    Toast.LENGTH_LONG).show();
                            mDatabase.child("users").child(UID).child("groups").child(group.getText().toString()).setValue(course.getText().toString()+group.getText().toString());
                            mDatabase.child("groups").child(course.getText().toString()+group.getText().toString()).child("groupMembers").child(UID).setValue(UID);
                        }
                        else{
                            Toast.makeText(joinGroup.this, "Could Not Find Group"+course.getText().toString()+group.getText(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(joinGroup.this, "Error Accessing Database", Toast.LENGTH_SHORT).show();
                    }
                });
               intent = new Intent(joinGroup.this, groupPage.class);
               startActivity(intent);
            }
        });
    }

}
