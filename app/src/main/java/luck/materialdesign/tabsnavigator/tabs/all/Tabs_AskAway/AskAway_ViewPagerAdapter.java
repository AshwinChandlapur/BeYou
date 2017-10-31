package luck.materialdesign.tabsnavigator.tabs.all.Tabs_AskAway;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import luck.materialdesign.tabsnavigator.tabs.all.Tabs_BeautyTips.Eyes;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_BeautyTips.Face;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_BeautyTips.Hair;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_BeautyTips.Mind;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_BeautyTips.Skin;

/**
 * Created by Edwin on 15/02/2015.
 */
public class AskAway_ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when MainPage_ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the MainPage_ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public AskAway_ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            AskAwayFragment askAwayFragment = new AskAwayFragment();
            return askAwayFragment;
        }
        else             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Answers answers = new Answers();
            return answers;
        }



    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}