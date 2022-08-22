package com.wangjing.androidutilsdemo.adapter;

import android.content.Context;

import com.wangjing.androidutilsdemo.R;

import java.util.List;

import me.jingbin.library.adapter.BaseByViewHolder;
import me.jingbin.library.adapter.BaseRecyclerAdapter;

public class ComponentsFragmentAdapter extends BaseRecyclerAdapter<String> {


    private Context mContext;
    private List<String> mDatas;

    public ComponentsFragmentAdapter() {
        super(R.layout.item_fragment_components);
    }

    public ComponentsFragmentAdapter(int layoutId, List<String> data) {
        super(layoutId, data);
    }

    @Override
    protected void bindView(BaseByViewHolder<String> holder, String bean, int position) {
        holder.setText(R.id.tv_content, bean);
    }
}
