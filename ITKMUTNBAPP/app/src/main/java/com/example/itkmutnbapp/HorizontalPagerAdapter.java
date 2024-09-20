package com.example.itkmutnbapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HorizontalPagerAdapter extends FragmentPagerAdapter {
    public HorizontalPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ActivityFirstFragment();
        } else if (position == 1) {
            return new FragmentActivityOne();
        } else if (position == 2) {
            return new FragmentActivityTwo();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3; // จำนวน Fragment ที่ต้องการแสดง
    }
}
