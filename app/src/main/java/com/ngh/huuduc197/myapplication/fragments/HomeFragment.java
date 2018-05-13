package com.ngh.huuduc197.myapplication.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ngh.huuduc197.myapplication.databases.KetNoiDB;
import com.ngh.huuduc197.myapplication.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    ImageButton nImageButton, bImageButton, rImageButton;
    Button btnGo;
    EditText urlEditText;
    WebView web;
   // KetNoiDB db;

    public HomeFragment() {
        // Required empty public constructor

    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        btnGo = (Button)view.findViewById(R.id.btnGo);
        nImageButton=(ImageButton)view.findViewById(R.id.next);
        bImageButton=(ImageButton)view.findViewById(R.id.back);
        rImageButton=(ImageButton)view.findViewById(R.id.reload);

        urlEditText=(EditText)view.findViewById(R.id.edtsearch);
        web=(WebView)view.findViewById(R.id.webView);
        final KetNoiDB db = new KetNoiDB(getActivity());
//---------



        web.setWebViewClient(new WebViewClient());
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent i = new Intent(MainActivity.this,ViewWebActivity.class);

                String url=urlEditText.getText().toString().trim();
                web.loadUrl("http://"+url);
                urlEditText.setText(web.getUrl());
                db.add(url);

                //final Class<Show> showClass = Show.class;
            }
        });


//nút reload- để load lại trang web
        rImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.reload();
                urlEditText.setText(web.getUrl());

            }
        });
        //button next- khi click next: 1. Neu da co du lieu thì Toast lên "Trang sau",
        // ngược lại thì Toast khong co du lieu
        nImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(web.canGoForward()){
                    web.goForward();
                    urlEditText.setText(web.getUrl());
                    Toast.makeText(getActivity(),"trang sau", Toast.LENGTH_LONG).show();

                }else{

                    Toast.makeText(getActivity(), "khong co du lieu trang sau de di toi", Toast.LENGTH_LONG).show();
                }
            }
        });
        //button next- khi back next: 1. Neu da co du lieu thì Toast lên "Trang trước",
        // ngược lại thì Toast khong co du lieu
        bImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(web.canGoBack()){
                    web.goBack();
                    urlEditText.setText(web.getUrl());

                    Toast.makeText(getActivity(), "Trang Truoc", Toast.LENGTH_LONG).show();

                }else{

                    Toast.makeText(getActivity(), "khong co du lieu trang truoc de quay ve", Toast.LENGTH_LONG).show();
                }

            }
        });
        web.getSettings().setLoadsImagesAutomatically(true);
        WebSettings WebSetting =web.getSettings();
        WebSetting.setBuiltInZoomControls(true);
        WebSetting.setDisplayZoomControls(false);
        WebSetting.setJavaScriptEnabled(true);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
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
           // throw new RuntimeException(context.toString()
                   // + " must implement OnFragmentInteractionListener");
            Toast.makeText(context, "Home Fragment", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
