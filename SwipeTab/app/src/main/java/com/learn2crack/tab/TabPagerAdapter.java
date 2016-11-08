package com.learn2crack.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		switch (i) {
        case 0:
            return new Android();
        case 1:
            return new Ios();
        case 2:
            return new Windows();
		default:
			return null;
        }


	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}


    }