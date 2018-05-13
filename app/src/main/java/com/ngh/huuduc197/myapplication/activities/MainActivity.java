package com.ngh.huuduc197.myapplication.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ngh.huuduc197.myapplication.R;
import com.ngh.huuduc197.myapplication.fragments.BookmarkFragment;
import com.ngh.huuduc197.myapplication.fragments.BookmarkView;
import com.ngh.huuduc197.myapplication.fragments.HistoriesView;
import com.ngh.huuduc197.myapplication.fragments.HistoryFragment;
import com.ngh.huuduc197.myapplication.fragments.HomeFragment;
import com.ngh.huuduc197.myapplication.fragments.HomeView;
import com.ngh.huuduc197.myapplication.fragments.SettingView;
import com.ngh.huuduc197.myapplication.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {


            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.nav_home:
                        transaction.replace(R.id.relative,new HomeView()).commit();
                    return true;
                case R.id.nav_bookmark:
                    transaction.replace(R.id.relative, new BookmarkView()).commit();
                    return true;
                case R.id.nav_settings:
                    transaction.replace(R.id.relative, new SettingView()).commit();
                    return true;
                case R.id.nav_history:
                    transaction.replace(R.id.relative, new HistoriesView()).commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();

        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.relative,new HomeView()).commit();

    }

}
