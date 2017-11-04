package luck.materialdesign.tabsnavigator.retrofit;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import luck.materialdesign.tabsnavigator.R;
import luck.materialdesign.tabsnavigator.retrofit.API;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements Filterable {
    private ArrayList<API> mArrayList;
    private ArrayList<API> mFilteredList;

    FragmentTransaction ft;


    String sno;
    String amtPledged;
    String blurb;
    String by;
    String country;
    String currency;
    String endtime;
    String location;
    String percentage;
    String backers;
    String state;
    String title;
    String type;
    String url;
    Bundle bundle;

    public DataAdapter(ArrayList<API> arrayList) {
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.sno.setText(String.valueOf(mFilteredList.get(i).getSno()));
        viewHolder.amtPledged.setText(mFilteredList.get(i).getAmtPledged());
        viewHolder.blurb.setText(mFilteredList.get(i).getBlurb());
        viewHolder.by.setText(mFilteredList.get(i).getBy());
        viewHolder.country.setText(mFilteredList.get(i).getCountry());
        viewHolder.currency.setText(mFilteredList.get(i).getCurrency());
        viewHolder.endtime.setText(String.valueOf(mFilteredList.get(i).getEndtime()));
        viewHolder.location.setText(mFilteredList.get(i).getLocation());
        viewHolder.percentage.setText(String.valueOf(mFilteredList.get(i).getPercentage()));
        viewHolder.backers.setText(String.valueOf(mFilteredList.get(i).getBackers()));
        viewHolder.state.setText(mFilteredList.get(i).getState());
        viewHolder.title.setText(mFilteredList.get(i).getTitle());
        viewHolder.type.setText(mFilteredList.get(i).getType());
        viewHolder.url.setText(mFilteredList.get(i).getUrl());



        viewHolder.parent_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(viewHolder.feedimage.getContext(), "inside viewholder position = " + i, Toast.LENGTH_SHORT).show();

                sno = String.valueOf(mFilteredList.get(i).getSno());
                amtPledged = String.valueOf(mFilteredList.get(i).getAmtPledged());
                blurb = mFilteredList.get(i).getBlurb();
                by = mFilteredList.get(i).getBy();
                country = mFilteredList.get(i).getCountry();
                currency = mFilteredList.get(i).getCurrency();
                endtime = String.valueOf(mFilteredList.get(i).getEndtime());
                location = mFilteredList.get(i).getLocation();
                percentage = String.valueOf(mFilteredList.get(i).getPercentage());
                backers = String.valueOf(mFilteredList.get(i).getBackers());
                state = mFilteredList.get(i).getState();
                title = mFilteredList.get(i).getTitle();
                type = mFilteredList.get(i).getType();
                url = mFilteredList.get(i).getUrl();

                bundle = new Bundle();
                bundle.putString("sno",sno);
                bundle.putString("amtPledged",amtPledged);
                bundle.putString("blurb",blurb);
                bundle.putString("by",by);
                bundle.putString("country",country);
                bundle.putString("currency",currency);
                bundle.putString("endtime",endtime);
                bundle.putString("location",location);
                bundle.putString("percentage",percentage);
                bundle.putString("backers",backers);
                bundle.putString("state",state);
                bundle.putString("title",title);
                bundle.putString("type",type);
                bundle.putString("url",url);
//                MainFeed mainFeed = new MainFeed();
//                mainFeed.setArguments(bundle);
//
//                ft = ((AppCompatActivity)viewHolder.parent_feed.getContext()).getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.content_main, mainFeed);
//                ft.addToBackStack(null);
//                ft.commit();

            }
        });

    }

    @Override
    public int getItemCount() {

        return mFilteredList == null ? 0 : mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<API> filteredList = new ArrayList<>();

                    for (API API : mArrayList) {

                        if (API.getTitle().toLowerCase().contains(charString)||API.getTitle().contains(charString)|| API.getLocation().toLowerCase().contains(charString)||API.getLocation().contains(charString)|| API.getBackers().contains(charString)||API.getAmtPledged().contains(charString)) {
                            filteredList.add(API);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<API>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView sno,amtPledged,blurb,by,country,currency,endtime,location,percentage,backers,state,title,type,url;
        public CardView parent_feed;
        public ViewHolder(View view) {
            super(view);
            parent_feed = (CardView)view.findViewById(R.id.parent_feed);
            sno = (TextView)view.findViewById(R.id.sno);
            amtPledged = (TextView)view.findViewById(R.id.amtPledged);
            blurb = (TextView)view.findViewById(R.id.blurb);
            by = (TextView)view.findViewById(R.id.by);
            country = (TextView)view.findViewById(R.id.country);
            currency = (TextView)view.findViewById(R.id.currency);
            endtime = (TextView)view.findViewById(R.id.endtime);
            location = (TextView)view.findViewById(R.id.location);
            percentage = (TextView)view.findViewById(R.id.percentage);
            backers = (TextView)view.findViewById(R.id.backers);
            state=(TextView)view.findViewById(R.id.state);
            title = (TextView)view.findViewById(R.id.title);
            type = (TextView)view.findViewById(R.id.type);
            url = (TextView)view.findViewById(R.id.url);

        }
    }

}