package com.ngh.huuduc197.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   // private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.nav_home:
                        transaction.replace(R.id.relative,new HomeFragment()).commit();
                 //   Intent k = new Intent(MainActivity.this, MainHomeActivity.class);
                   // startActivity(k);
                   // mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.nav_bookmark:
                    transaction.replace(R.id.relative, new BookmarkFragment()).commit();
                   // mTextMessage.setText("bookmark");
                    return true;
                case R.id.nav_settings:
                    transaction.replace(R.id.relative, new SettingsFragment()).commit();
                   // mTextMessage.setText("setting");
                    return true;
                case R.id.nav_history:
                    transaction.replace(R.id.relative, new HistoryFragment()).commit();
                   // mTextMessage.setText("add tab");


                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.relative,new HomeFragment()).commit();

    }

}
