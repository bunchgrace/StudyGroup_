package edu.fsu.cs.mobile.studygroup;

import android.app.ListActivity;
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
