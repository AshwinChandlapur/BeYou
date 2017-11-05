package luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

import luck.materialdesign.tabsnavigator.R;
import luck.materialdesign.tabsnavigator.retrofit_MainPage.API_MP;
import luck.materialdesign.tabsnavigator.retrofit_MainPage.DataAdapter_MP;
import luck.materialdesign.tabsnavigator.retrofit_MainPage.JSONResponse_MP;
import luck.materialdesign.tabsnavigator.retrofit_MainPage.RequestInterface_MP;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class LifeStyle extends Fragment {

    public static final String BASE_URL = "https://raw.githubusercontent.com";
    private RecyclerView mRecyclerView;
    private ArrayList<API_MP> mArrayList;
    private DataAdapter_MP mAdapter;

    View rootView;

    public LifeStyle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      rootView = inflater.inflate(R.layout.fragment_life_style, container, false);
        setHasOptionsMenu(true);

        initViews();
        loadJSON();

        return rootView;
    }


    private void initViews(){
        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.card_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
    }
    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface_MP request = retrofit.create(RequestInterface_MP.class);
        Call<JSONResponse_MP> call = request.getLifeStyle();
        call.enqueue(new Callback<JSONResponse_MP>() {
            @Override
            public void onResponse(Call<JSONResponse_MP> call, Response<JSONResponse_MP> response) {

                JSONResponse_MP jsonResponse = response.body();
                Log.d("JSON Response is", "onResponse: "+jsonResponse);
                mArrayList = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                mAdapter = new DataAdapter_MP(mArrayList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<JSONResponse_MP> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                mAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch (id) {
//            case R.id.action_1:
//                // do stuff
//                return true;
//
//            case R.id.action_2:
//                // do more stuff
//                return true;
//        }

        return false;
    }

}
