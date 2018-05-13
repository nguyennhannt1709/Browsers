package com.ngh.huuduc197.myapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ngh.huuduc197.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeView extends Fragment {

    View holderView;

    public HomeView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        holderView = inflater.inflate(R.layout.fragment_home_view, container, false);
        return holderView;
    }

}
