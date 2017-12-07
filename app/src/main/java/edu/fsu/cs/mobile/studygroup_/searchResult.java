package edu.fsu.cs.mobile.studygroup_;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class searchResult extends ListActivity {
    ListView groupList = (ListView) findViewById(R.id.groupListView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
    }
}
