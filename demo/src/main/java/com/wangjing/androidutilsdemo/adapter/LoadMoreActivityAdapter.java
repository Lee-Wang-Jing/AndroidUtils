package com.wangjing.androidutilsdemo.adapter;

import android.content.Context;

import java.util.List;

import me.jingbin.library.adapter.BaseByViewHolder;
import me.jingbin.library.adapter.BaseRecyclerAdapter;

public class LoadMoreActivityAdapter extends BaseRecyclerAdapter<String> {


    private Context mContext;
    private List<String> mDatas;

    public LoadMoreActivityAdapter(int layoutId, List<String> data) {
        super(layoutId, data);
    }

    @Override
    protected void bindView(BaseByViewHolder<String> holder, String bean, int position) {

    }

}
