package com.tml.tabhost.adapter;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tml.tabhost.Lakshya;
import com.tml.tabhost.Moksh;
import com.tml.tabhost.Tatva;

import java.util.List;

/**
 * Created by divya on 17/1/17.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    List<android.support.v4.app.Fragment> fragments;

    public TabsPagerAdapter(FragmentManager fm, List<android.support.v4.app.Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {

        return fragments.size();
    }

}