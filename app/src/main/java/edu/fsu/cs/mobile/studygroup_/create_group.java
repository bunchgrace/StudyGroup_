package edu.fsu.cs.mobile.studygroup_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class create_group extends AppCompatActivity {

    private String course;
    private Button createGroup;
    private EditText courseNum;
    DatabaseReference db = FirebaseDatabase.getInstance().getReference();

    DatabaseReference dbGroup = db.child("groups");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        createGroup = (Button) findViewById(R.id.create_group);
        courseNum = (EditText) findViewById(R.id.course_num);

        createGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                course = courseNum.getText().toString();
                dbGroup.setValue(course);
                Intent intent = new Intent(create_group.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
