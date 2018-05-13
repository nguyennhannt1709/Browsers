package com.ngh.huuduc197.myapplication.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.ngh.huuduc197.myapplication.databases.KetNoiDB;
import com.ngh.huuduc197.myapplication.R;
import com.ngh.huuduc197.myapplication.models.getSet;

import java.util.ArrayList;



public class HistoryFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    //ArrayList<Show> mang;
    //KetNoiDB db;
    //SimpleCursorAdapter adapter;

    KetNoiDB db; // goi class Database moi tao
    ListView listcv;
    ArrayList<getSet> arrayCongViec;
    Button btn;

    public HistoryFragment() {
    }

    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // mang = new ArrayList<Show>();


        View view = inflater.inflate(R.layout.fragment_history, container, false);
        //ListView listView = (ListView) view.findViewById(R.id.list);
        //final Class<Show> showClass = Show.class;
        btn = (Button)view.findViewById(R.id.button);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getActivity(), Show.class);
//                startActivity(i);
//            }
//        });


        return view;



    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            //throw new RuntimeException(context.toString()
                   // + " must implement OnFragmentInteractionListener");
            Toast.makeText(context, "History Fragment", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
