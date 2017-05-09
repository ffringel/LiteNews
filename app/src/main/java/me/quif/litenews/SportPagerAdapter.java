package me.quif.litenews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import me.quif.litenews.fragments.BBCSportFragment;
import me.quif.litenews.fragments.ESPNFragment;
import me.quif.litenews.fragments.MashableFragment;
import me.quif.litenews.fragments.RecodeFragment;
import me.quif.litenews.fragments.SkySportFragment;

public class SportPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int numbOfTabs;

    public SportPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumOfTabs) {
        super(fm);

        this.Titles = mTitles;
        this.numbOfTabs = mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SkySportFragment();
            case 1:
                return new ESPNFragment();
            case 2:
                return new BBCSportFragment();
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
