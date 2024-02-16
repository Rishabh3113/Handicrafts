package com.example.handicrafts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.handicrafts.categories.catFragment;
import com.example.handicrafts.fav.favFragment;
import com.example.handicrafts.home.homefragment;
import com.example.handicrafts.profile.accountFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Home extends AppCompatActivity {

    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame, new HomeFragment())
                    .commit();
        }
        navigationView=findViewById(R.id.bottom_nav);

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){


                    case R.id.item1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame, new homefragment())
                                .commit();
                        return true;
                     case R.id.item2:

                         getSupportFragmentManager().beginTransaction()
                                 .replace(R.id.frame, new favFragment())
                                 .commit();
                             return  true;

                    case R.id.item3:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame, new catFragment())
                                .commit();
                        return true;

                    case R.id.item4:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frame, new accountFragment())
                                .commit();
                        return true;



                    default:
                        return false;
                }





            }
        });


    }

}



