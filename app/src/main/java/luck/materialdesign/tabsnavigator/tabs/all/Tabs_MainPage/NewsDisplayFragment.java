package luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import luck.materialdesign.tabsnavigator.R;
import luck.materialdesign.tabsnavigator.sliding.SlidingTabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDisplayFragment extends Fragment {

    Bundle bundle;
    String newsUrl,title;
    View rootView;


    Toolbar toolbar;
    ViewPager pager;
    MainPage_ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Lifestyle","Fashion","Beauty","Wedding","Relationships","Intimacy","Food","Work"};
    int Numboftabs =8;


//    MainPage_ViewPagerAdapter adapter;
//    SlidingTabLayout tabs;
//    CharSequence Titles[]={"Lifestyle","Fashion","Beauty","Wedding","Relationships","Intimacy","Food","Work"};
//    int Numboftabs =8;

    public NewsDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_news_display, container, false);


        WebView browser = (WebView) rootView.findViewById(R.id.webview);
        browser.setWebViewClient(new MyBrowser());
        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        bundle = this.getArguments();
        if (bundle != null) {
            newsUrl = bundle.getString("newsUrl");
            title = bundle.getString("title");
        }


        browser.loadUrl(newsUrl);


        return rootView;
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
