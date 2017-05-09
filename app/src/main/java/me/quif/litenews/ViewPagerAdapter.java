package me.quif.litenews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import me.quif.litenews.fragments.BBCFragment;
import me.quif.litenews.fragments.CNNFragment;
import me.quif.litenews.fragments.FREFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int numbOfTabs;

    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumOfTabs) {
        super(fm);

        this.Titles = mTitles;
        this.numbOfTabs = mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CNNFragment();
            case 1:
                return new BBCFragment();
            case 2:
                return new FREFragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    @Override
    public int getCount() {
        return numbOfTabs;
    }
}
