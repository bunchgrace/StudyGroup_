package edu.fsu.cs.mobile.studygroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by gracebunch on 11/5/17.
 */

public class registerActivity extends AppCompatActivity{

    private DatabaseReference mDatabase;

    private EditText fname;
    private EditText lname;
    private EditText email;
    private EditText username;
    private EditText password;
    private FirebaseAuth auth;
    private String email1;
    private String pass;
    private Intent intent;
    private FirebaseAnalytics fba;
    private FirebaseUser user;
    private String UID;
    private int points;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        fba = FirebaseAnalytics.getInstance(this);
        auth= FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();


        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        email= (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.username_reg);
        password = (EditText) findViewById(R.id.password_reg);
        points=0;
    }



    //clicking on register opens up mainActivity
    public void regToMain(View view) {
        //create child in root
        //assign value to child
        if (TextUtils.isEmpty(email.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Enter email address", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(fname.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Enter first name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(lname.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Enter last name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(username.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Enter username", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        email1 = email.getText().toString().trim();
        pass = password.getText().toString().trim();


        //Some reason this is failing to add the user to Firebase ????
        auth.createUserWithEmailAndPassword(email1, pass)
                .addOnCompleteListener(registerActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Log.d("TAG", "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(registerActivity.this, "Failed",
                                    Toast.LENGTH_SHORT).show();
                        } else {


                            user = auth.getCurrentUser();
                            UID = user.getUid();

                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(username.getText().toString())
                                    .build();

                            //update display name aka username
                            user.updateProfile(profileUpdates);


                            Map<String, Object> map = new HashMap<>();
                            map.put("email", email.getText().toString());
                            map.put("username", username.getText().toString());
                            map.put("fname", fname.getText().toString());
                            map.put("lname", lname.getText().toString());
                            map.put("points", 10);

                            mDatabase.child("users").child(UID).setValue(map);
                             intent = new Intent(registerActivity.this, MainActivity.class);
                            startActivity(intent);
                        }


                    }
                });













    }

}

