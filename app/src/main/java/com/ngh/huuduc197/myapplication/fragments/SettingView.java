package com.ngh.huuduc197.myapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.ngh.huuduc197.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingView extends Fragment {

    View holderView;
    ToggleButton tgb;
    public SettingView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        holderView = inflater.inflate(R.layout.fragment_setting_view, container, false);
       tgb = (ToggleButton)holderView.findViewById(R.id.tog);
       tgb.setChecked(true);

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        }
        return holderView;
    }

}
