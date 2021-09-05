package com.example.pager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pager.Model.HomeDataBean;
import com.example.pager.R;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder>{

    private List<HomeDataBean.Offer> bannerModelList;
    private Context context;

    public BannerAdapter(List<HomeDataBean.Offer> bannerModelList, Context context) {
        this.bannerModelList = bannerModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BannerViewHolder(LayoutInflater.from(context).inflate(R.layout.banner_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {

         //holder.imageView.setImageResource(R.drawable.ic_mechanical);
    }

    @Override
    public int getItemCount() {
//        if(bannerModelList != null){
//            return bannerModelList.size();
//        }
        return 6;
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageView;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
        }
    }
}
