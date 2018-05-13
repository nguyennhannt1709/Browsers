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

import com.ngh.huuduc197.myapplication.R;
import com.ngh.huuduc197.myapplication.databases.DatabaseHandler;

public class HomeFragment extends Fragment {

    ImageButton nImageButton, bImageButton, rImageButton;
    Button btnGo;
    EditText urlEditText;
    WebView web;

    public HomeFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        final DatabaseHandler db = new DatabaseHandler(getActivity());
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

}
