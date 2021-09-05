package com.example.pager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

import com.example.pager.Adapter.BannerAdapter;
import com.example.pager.Model.HomeDataBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<HomeDataBean.Offer> offerDataList=new ArrayList();
    private Context context;
    private BannerAdapter bannerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        recyclerView=findViewById(R.id.recyclerview);
        setAdapter();
    }

    public void setAdapter()
    {
        bannerAdapter = new BannerAdapter(offerDataList,context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(bannerAdapter);
        Handler handler = new Handler();
        final Handler handler2 = handler;
        final int timer = 3000;
        handler.postDelayed(new Runnable() {
            int count = 0;
            boolean flag = true;

            @Override
            public void run() {
                if (count < bannerAdapter.getItemCount()) {
                    if (count == bannerAdapter.getItemCount() - 1) {
                        flag = false;
                    } else if (count == 0) {
                        flag = true;
                    }
                    if (flag) {
                        count++;
                    } else {
                        count--;
                    }
                    recyclerView.smoothScrollToPosition(count);
                    handler2.postDelayed(this, timer);
                }
            }
        }, timer);
    }

}
