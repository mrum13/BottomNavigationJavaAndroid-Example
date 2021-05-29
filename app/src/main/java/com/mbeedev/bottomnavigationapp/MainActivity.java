package com.mbeedev.bottomnavigationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openFragment(new HomeFragment());
        bottomNavigationView = findViewById(R.id.bottom_navigation);

//        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        if (getIntent().hasExtra("sms")){
            openFragment(new SmsFragment());
            bottomNavigationView.setSelectedItemId(R.id.navigation_sms);
        }


        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        fragment = null;
        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_sms:
                fragment = new SmsFragment();
                break;
            case R.id.navigation_notifications:
                fragment = new NotificationFragment();
                break;
        }
        return openFragment(fragment);
    }

    private boolean openFragment(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            return true;
        }
        return false;
    }
}