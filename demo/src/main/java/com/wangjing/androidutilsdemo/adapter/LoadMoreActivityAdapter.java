package com.wangjing.androidutilsdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wangjing.androidutilsdemo.R;

import java.util.ArrayList;
import java.util.List;

public class LoadMoreActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_FOOTER = -1001;
    private static final int TYPE_NORMAL = -1000;

    private Context mContext;
    private List<String> mDatas;

    public LoadMoreActivityAdapter(Context context, List<String> datas) {
        this.mContext = context;
        if (datas != null) {
            this.mDatas = datas;
        } else {
            this.mDatas = new ArrayList<>();
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER) {
            View footView = LayoutInflater.from(parent.getContext()).inflate(R.layout.loading_foot, parent, false);
            return new FootViewHolder(footView);
        }
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loadmoreactivityadapter, parent, false);
        return new FootViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    static class FootViewHolder extends RecyclerView.ViewHolder {
        View mItemView;

        public FootViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mItemView = itemView;
        }
    }
}
