package com.example.calculator;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class PaperMainAdapter extends FragmentPagerAdapter {
    private final List<Fragment> frags;

    public PaperMainAdapter(FragmentManager fm, List<Fragment> frags) {
        super(fm);
        this.frags = frags;
    }

    public PaperMainAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> frags) {
        super(fm, behavior);
        this.frags = frags;
    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags.size();
    }
}
