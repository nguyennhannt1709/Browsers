package com.ngh.huuduc197.myapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import com.ngh.huuduc197.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeView extends Fragment {

    View holderView;
    Button btnGo;
    EditText edtAddress;
    WebView webView;

    public HomeView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        holderView = inflater.inflate(R.layout.fragment_home_view, container, false);
        initialize();
        bindingAction();
        return holderView;
    }

    public void initialize() {
        btnGo = holderView.findViewById(R.id.btn_go);
        edtAddress = holderView.findViewById(R.id.edt_address);
        webView = holderView.findViewById(R.id.webview);


        //config webview
    }

    public void bindingAction() {
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String url_Address = edtAddress.getText().toString().trim();
                webView.loadUrl(url_Address);

                edtAddress.setText("");
            }
        });
    }
}
