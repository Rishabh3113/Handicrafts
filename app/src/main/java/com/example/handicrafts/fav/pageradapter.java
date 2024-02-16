package com.example.handicrafts.fav;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pageradapter extends FragmentPagerAdapter {

    int tabcount;

    public pageradapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new fav_activity();

            case 1:
                return new cart_activity();


            default:
                return null;

        }


    }

    @Override
    public int getCount() {
        return 2;
    }
}
