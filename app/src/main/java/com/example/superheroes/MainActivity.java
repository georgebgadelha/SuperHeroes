package com.example.superheroes;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.superheroes.fragments.FragmentHome;
import com.example.superheroes.fragments.FragmentSettings;
import com.example.superheroes.fragments.FragmentSuperheroes;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = FragmentHome.newInstance();
//                    TextView textView = findViewById(R.id.message);
//                    textView.setText("CLIQUEI NO HOME");
                    break;
                case R.id.navigation_superheroes_list:
                    selectedFragment = FragmentSuperheroes.newInstance();
                    break;
                case R.id.navigation_settings:
                    selectedFragment = FragmentSettings.newInstance();
                    break;
            }
            assert selectedFragment != null;
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, FragmentHome.newInstance());
        transaction.commit();


    }

}
