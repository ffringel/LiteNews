package me.quif.litenews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import me.quif.litenews.fragments.BBCSportFragment;
import me.quif.litenews.fragments.ESPNFragment;
import me.quif.litenews.fragments.INDYFragment;
import me.quif.litenews.fragments.NPRFragment;
import me.quif.litenews.fragments.PoliticoFragment;
import me.quif.litenews.fragments.SkySportFragment;

public class PoliticsPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int numbOfTabs;

    public PoliticsPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumOfTabs) {
        super(fm);

        this.Titles = mTitles;
        this.numbOfTabs = mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PoliticoFragment();
            case 1:
                return new NPRFragment();
            case 2:
                return new INDYFragment();
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
