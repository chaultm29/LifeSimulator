package com.example.lifesimulator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.lifesimulator.Fragment.*;

import com.example.lifesimulator.Model.Identity;
import com.example.lifesimulator.Model.AppDataStore;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDataStore.identity = new Identity("Min", 20, false);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        bottomNavigationView.setItemIconTintList(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new IdentityFragment()).commit();

    }
private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_identity:
                selectedFragment = new IdentityFragment();
                break;
            case R.id.nav_relation:
                selectedFragment = new RelationFragment();
                break;
            case R.id.nav_job:
                selectedFragment = new JobFragment();
                break;
            case R.id.nav_cure:
                selectedFragment = new CureFragment();
                break;
            case R.id.nav_bank:
                selectedFragment = new BankFragment();
                break;
        }
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        }
        return true;
    }

};


}