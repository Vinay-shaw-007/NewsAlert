package com.example.newsalert;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context context;
    ArrayList<NewsData> mitems = new ArrayList<>();
    NewsItemClicked mNewsItemClicked;
    public NewsAdapter(Context context,NewsItemClicked mNewsItemClicked) {
        this.context = context;
        this.mNewsItemClicked=mNewsItemClicked;
    }
    public void update(ArrayList<NewsData> newsData){
        mitems.clear();
        mitems.addAll(newsData);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_news,parent,false);
        NewsViewHolder newsViewHolder = new NewsViewHolder(view,mNewsItemClicked,mitems);
        return newsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsData currentItem = mitems.get(position);
        holder.headline.setText(currentItem.getTitle());
        Glide.with(holder.itemView.getContext()).load(currentItem.getUrlToImage()).into(holder.image);
        //Glide.with(holder.itemView.getContext()).load(Integer.parseInt(itemList.get(position).urlToImage)).into(holder.url_To_Image);
    }
    

    @Override
    public int getItemCount() {
        return mitems.size();
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView headline;
        ImageView image;
        NewsItemClicked newsItemClicked;
        ArrayList<NewsData> ClickItem;
        public NewsViewHolder(@NonNull View itemView,NewsItemClicked newsItemClicked,ArrayList<NewsData> ClickedItems) {
            super(itemView);
            headline = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.action_image);
            this.newsItemClicked=newsItemClicked;
            this.ClickItem=ClickedItems;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            newsItemClicked.onItemClicked(ClickItem.get(getAdapterPosition()));
        }
    }
    interface NewsItemClicked {
        void onItemClicked( NewsData Items);

    }

}
