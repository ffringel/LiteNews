package me.quif.litenews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import me.quif.litenews.fragments.EOnlineFragment;
import me.quif.litenews.fragments.OnionFragment;
import me.quif.litenews.fragments.TMZFragment;

public class ETPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int numbOfTabs;

    public ETPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumOfTabs) {
        super(fm);

        this.Titles = mTitles;
        this.numbOfTabs = mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new EOnlineFragment();
            case 1:
                return new TMZFragment();
            case 2:
                return new OnionFragment();
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
