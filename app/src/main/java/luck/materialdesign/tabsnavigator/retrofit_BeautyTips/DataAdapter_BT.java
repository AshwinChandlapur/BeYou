package luck.materialdesign.tabsnavigator.retrofit_BeautyTips;
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
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_BeautyTips.ContentsDisplayFragment;
import luck.materialdesign.tabsnavigator.tabs.all.Tabs_MainPage.NewsDisplayFragment;

public class DataAdapter_BT extends RecyclerView.Adapter<DataAdapter_BT.ViewHolder> implements Filterable {
    private ArrayList<API_BT> mArrayList;
    private ArrayList<API_BT> mFilteredList;

    FragmentTransaction ft;



    String title;
    String tag;
    String imgUrl;
    String content;
    Bundle bundle;

    public DataAdapter_BT(ArrayList<API_BT> arrayList) {
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }

    @Override
    public DataAdapter_BT.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_rowbeauty, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataAdapter_BT.ViewHolder viewHolder, final int i) {


        viewHolder.title.setText(mFilteredList.get(i).getTitle());
//        viewHolder.tag.setText(mFilteredList.get(i).getTag());
        viewHolder.content.setText(mFilteredList.get(i).getContent());
        Glide.with(viewHolder.imageView.getContext())
                .load(mFilteredList.get(i).getImgUrl())
                .centerCrop()
                .into(viewHolder.imageView);


        viewHolder.card_rowBeauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(viewHolder.feedimage.getContext(), "inside viewholder position = " + i, Toast.LENGTH_SHORT).show();


                title = mFilteredList.get(i).getTitle();
                content = mFilteredList.get(i).getContent();
                tag = mFilteredList.get(i).getTag();

                bundle = new Bundle();
                bundle.putString("tag",tag);
                ContentsDisplayFragment contentsDisplayFragment = new ContentsDisplayFragment();
                contentsDisplayFragment.setArguments(bundle);
                ft = ((AppCompatActivity)viewHolder.card_rowBeauty.getContext()).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.beautyTips_LinearLayout, contentsDisplayFragment);
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

                    ArrayList<API_BT> filteredList = new ArrayList<>();

                    for (API_BT API : mArrayList) {

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
                mFilteredList = (ArrayList<API_BT>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title,tag,content;
        private ImageView imageView;
        public CardView card_rowBeauty;
        public ViewHolder(View view) {
            super(view);
            card_rowBeauty = (CardView)view.findViewById(R.id.card_rowBeauty);
            title = (TextView)view.findViewById(R.id.title);
//            tag = (TextView)view.findViewById(R.id.tag);
            content = (TextView)view.findViewById(R.id.content);
            imageView = (ImageView)view.findViewById(R.id.imageView);


        }
    }

}