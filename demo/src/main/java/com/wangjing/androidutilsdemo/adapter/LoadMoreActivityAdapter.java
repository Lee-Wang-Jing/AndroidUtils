package com.wangjing.androidutilsdemo.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LoadMoreActivityAdapter extends RecyclerView.Adapter<LoadMoreActivityAdapter.MViewHolder> {

    private List<String> datas;

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class MViewHolder extends RecyclerView.ViewHolder {
        View mItemView;

        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mItemView = itemView;
        }
    }
}
