package luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import luck.materialdesign.tabsnavigator.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDisplayFragment extends Fragment {

    Bundle bundle;
    String newsUrl,title;

    public NewsDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_news_display, container, false);
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
