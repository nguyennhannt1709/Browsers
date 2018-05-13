package com.ngh.huuduc197.myapplication.activities;

import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.os.Bundle;

import com.ngh.huuduc197.myapplication.R;
import com.ngh.huuduc197.myapplication.databases.DatabaseHandler;

/**
 * Created by huuduc on 12/05/2018.
 */

public class Show extends AppCompatActivity {
    DatabaseHandler db;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hienthi);
        db = new DatabaseHandler(this);

        /// ket noi db va lay du lieu tu csdl
        Cursor cursor = db.LayTatCaBr();

        // The desired columns to be bound
        String[] columns = new String[] {
                "link"
        };

        // the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.txtghi

        };


        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information

        adapter = new SimpleCursorAdapter(
                this, R.layout.fragment_history,
                cursor,
                columns,
                to,
                0);


        ListView listView = (ListView) findViewById(R.id.list);
//        // Assign adapter to ListView
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
