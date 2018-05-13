package com.ngh.huuduc197.myapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ngh.huuduc197.myapplication.R;
import com.ngh.huuduc197.myapplication.activities.MainActivity;
import com.ngh.huuduc197.myapplication.models.Link;

import java.util.ArrayList;
import java.util.List;

import static com.ngh.huuduc197.myapplication.activities.MainActivity.db;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoriesView extends Fragment {

    View holderView;
    List<Link> lists;
    ListView listview;

    public HistoriesView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        holderView = inflater.inflate(R.layout.fragment_histories_view, container, false);
        initialize();
        lists = new ArrayList<>();

        if (db != null) {
            lists = db.getAllLinks();

            List<String> url = new ArrayList<>();
            for (int i=0;i<lists.size(); i++) {
                url.add(lists.get(i).getTitle() + " - " + lists.get(i).getUrl());
            }
            ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, url);
            listview.setAdapter(adapter);

        }
        return holderView;
    }

    public void initialize() {
        listview = holderView.findViewById(R.id.listView);
    }

}
