package edu.fsu.cs.mobile.studygroup_;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class createGroup extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        Button create = (Button) findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                intent = new Intent(createGroup.this, groupPage.class);
                startActivity(intent);
            }
        });
    }
}
