package luck.materialdesign.tabsnavigator.retrofit_MainPage;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import luck.materialdesign.tabsnavigator.R;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage.NewsDisplayFragment;

public class DataAdapter_MP extends RecyclerView.Adapter<DataAdapter_MP.ViewHolder> implements Filterable {
    private ArrayList<API_MP> mArrayList;
    private ArrayList<API_MP> mFilteredList;

    FragmentTransaction ft;



    String title;
    String tag;
    String imgUrl;
    String newsUrl;
    Bundle bundle;

    public DataAdapter_MP(ArrayList<API_MP> arrayList) {
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }

    @Override
    public DataAdapter_MP.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_rows, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataAdapter_MP.ViewHolder viewHolder, final int i) {


        viewHolder.title.setText(mFilteredList.get(i).getTitle());
        viewHolder.tag.setText(mFilteredList.get(i).getTag());
        Glide.with(viewHolder.imageView.getContext())
                .load(mFilteredList.get(i).getImgUrl())
                .centerCrop()
                .into(viewHolder.imageView);


        viewHolder.card_rows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(viewHolder.feedimage.getContext(), "inside viewholder position = " + i, Toast.LENGTH_SHORT).show();


                title = mFilteredList.get(i).getTitle();
                newsUrl = mFilteredList.get(i).getNewsUrl();

                bundle = new Bundle();
                bundle.putString("title",title);
                bundle.putString("newsUrl",newsUrl);
                NewsDisplayFragment newsDisplayFragment = new NewsDisplayFragment();
                newsDisplayFragment.setArguments(bundle);
                ft = ((AppCompatActivity)viewHolder.card_rows.getContext()).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main_activity_linearLayout, newsDisplayFragment);
                ft.addToBackStack(null);
                ft.commit();

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

                    ArrayList<API_MP> filteredList = new ArrayList<>();

                    for (API_MP API : mArrayList) {

                        if (API.getTitle().toLowerCase().contains(charString)||API.getTitle().contains(charString)) {
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
                mFilteredList = (ArrayList<API_MP>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title,tag,newsUrl;
        private ImageView imageView;
        public CardView card_rows;
        public ViewHolder(View view) {
            super(view);
            card_rows = (CardView)view.findViewById(R.id.card_rows);
            title = (TextView)view.findViewById(R.id.title);
            tag = (TextView)view.findViewById(R.id.tag);
            imageView = (ImageView)view.findViewById(R.id.imageView);


        }
    }

}