package luck.materialdesign.tabsnavigator.tabs.all.Tabs_BeautyTips;


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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import luck.materialdesign.tabsnavigator.R;
import luck.materialdesign.tabsnavigator.retrofit_BeautyTips.API_BT;
import luck.materialdesign.tabsnavigator.retrofit_BeautyTips.DataAdapter_BT;
import luck.materialdesign.tabsnavigator.retrofit_BeautyTips.JSONResponse_BT;
import luck.materialdesign.tabsnavigator.retrofit_BeautyTips.RequestInterface_BT;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentsDisplayFragment extends Fragment {

    Bundle bundle;
    String tag;
    public static final String BASE_URL = "https://raw.githubusercontent.com";
    private RecyclerView mRecyclerView;
    private ArrayList<API_BT> mArrayList;
    private DataAdapter_BT mAdapter;
    View rootView;

    public ContentsDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         rootView = inflater.inflate(R.layout.fragment_contents_display, container, false);


        setHasOptionsMenu(true);

        bundle = this.getArguments();
        if (bundle != null) {
            tag = bundle.getString("tag");
        }
        Toast.makeText(getContext(),"Tag value is "+tag,Toast.LENGTH_LONG).show();
        Log.d("Tag value is","tag Vlaue is "+tag);

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
        Call<JSONResponse_BT> call;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface_BT request = retrofit.create(RequestInterface_BT.class);
        Log.d("Tag Value Load Json is","Tags is"+tag);




        String darkcircles=new String("darkcircles");
        String eyebrows=new String("eyebrows");
//        String eyecare=new String("eyecare");

        if(tag.equals(darkcircles))
        {
            call = request.getDarkCircles();
        }else if(tag.equals(eyebrows)){
            call = request.getEyeBrows();
        }else{
            call = request.getEyeCare();
        }



        call.enqueue(new Callback<JSONResponse_BT>() {
            @Override
            public void onResponse(Call<JSONResponse_BT> call, Response<JSONResponse_BT> response) {

                JSONResponse_BT jsonResponse = response.body();
                Log.d("JSON Response is", "onResponse: "+jsonResponse);
                mArrayList = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                mAdapter = new DataAdapter_BT(mArrayList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<JSONResponse_BT> call, Throwable t) {
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
