package com.wangjing.androidutilsdemo.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.wangjing.androidutilsdemo.R;
import com.wangjing.androidutilsdemo.adapter.LoadMoreActivityAdapter;
import com.wangjing.androidutilsdemo.base.BaseActivity;

public class LoadMoreActivity extends BaseActivity {


    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private LoadMoreActivityAdapter loadMoreActivityAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadmore);

        initSwipeRefreshLayout();
        initRecyclerView();

    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.purple_200, R.color.purple_500, R.color.purple_700);
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.black);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//线性布局管理器
        loadMoreActivityAdapter = new LoadMoreActivityAdapter(R.layout.item_loadmoreactivityadapter, null);
        recyclerView.setAdapter(loadMoreActivityAdapter);
    }
}
