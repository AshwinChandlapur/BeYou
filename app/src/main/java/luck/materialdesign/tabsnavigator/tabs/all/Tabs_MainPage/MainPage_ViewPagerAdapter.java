package luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Edwin on 15/02/2015.
 */
public class MainPage_ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when MainPage_ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the MainPage_ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public MainPage_ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            LifeStyle lifeStyle = new LifeStyle();
            return lifeStyle;
        }
        else if(position ==1)            // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Fashion fashion = new Fashion();
            return fashion;
        }
        else if(position ==2)            // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Beauty beauty = new Beauty();
            return beauty;
        }
        else if(position ==3)            // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Wedding wedding = new Wedding();
            return wedding;
        }
        else if(position ==4)            // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Relationships relationships = new Relationships();
            return relationships;
        }
        else if(position ==5)            // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Intimacy intimacy  = new Intimacy();
            return intimacy;
        }
        else if(position ==6)            // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Food food = new Food();
            return food;
        }
        else          // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            Work work = new Work();
            return work;
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