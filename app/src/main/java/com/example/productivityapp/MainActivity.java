package com.example.productivityapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    ImageView ivProfilepic;
    Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate Method");

        ivProfilepic = findViewById(R.id.ivProfilepic);
        drawable=getResources().getDrawable(R.drawable.forest);

        BottomNavigationView btnNav = findViewById(R.id.bottom_navigation);
        btnNav.setOnNavigationItemSelectedListener(naviListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener naviListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_newTask:
                            selectedFragment = new AvailableFragment() ;
                            break;
                        case R.id.nav_currentTask:
                            selectedFragment = new WorkingFragment() ;
                            break;
                        case R.id.nav_doneTask:
                            selectedFragment = new DoneFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

}