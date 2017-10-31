package luck.materialdesign.tabsnavigator.tabs.all.Tabs_BeautyTips;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage.Beauty;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage.Fashion;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage.Food;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage.Intimacy;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage.LifeStyle;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage.Relationships;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage.Wedding;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage.Work;

/**
 * Created by Edwin on 15/02/2015.
 */
public class BeautyTips_ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when MainPage_ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the MainPage_ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public BeautyTips_ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            Face face = new Face();
            return face;
        }
        else if(position ==1)            // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Eyes eyes = new Eyes();
            return eyes;
        }
        else if(position ==2)            // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Hair hair = new Hair();
            return hair;
        }
        else if(position ==3)            // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Mind mind = new Mind();
            return mind;
        }
        else
        {
            Skin skin = new Skin();
            return skin;
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