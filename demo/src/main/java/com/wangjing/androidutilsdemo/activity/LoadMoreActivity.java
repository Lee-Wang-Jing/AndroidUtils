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
    private RecyclerView recyclerview;
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
    }

    private void initRecyclerView() {
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));//线性布局管理器
//        recyclerview.setLayoutManager(new GridLayoutManager(this, 4));//网格布局管理器
//        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));//瀑布流布局管理器
        loadMoreActivityAdapter = new LoadMoreActivityAdapter(this, null);
        recyclerview.setAdapter(loadMoreActivityAdapter);
    }
}
