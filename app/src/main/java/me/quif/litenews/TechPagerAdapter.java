package me.quif.litenews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import me.quif.litenews.fragments.MashableFragment;
import me.quif.litenews.fragments.RecodeFragment;
import me.quif.litenews.fragments.TechCrunchFragment;

public class TechPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int numbOfTabs;

    public TechPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumOfTabs) {
        super(fm);

        this.Titles = mTitles;
        this.numbOfTabs = mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TechCrunchFragment();
            case 1:
                return new RecodeFragment();
            case 2:
                return new MashableFragment();
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
