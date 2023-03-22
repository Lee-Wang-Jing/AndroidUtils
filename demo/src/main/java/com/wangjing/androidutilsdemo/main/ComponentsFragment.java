package com.wangjing.androidutilsdemo.main;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import com.wangjing.androidutilsdemo.R;
import com.wangjing.androidutilsdemo.activity.FragmentDemoActivity;
import com.wangjing.androidutilsdemo.activity.TitleBarDemoActivity;
import com.wangjing.androidutilsdemo.adapter.ComponentsFragmentAdapter;
import com.wangjing.androidutilsdemo.base.BaseFragment;
import com.wangjing.widget.titlebar.TitleBar;

import java.util.ArrayList;
import java.util.List;

import me.jingbin.library.ByRecyclerView;
import me.jingbin.library.decoration.GridSpaceItemDecoration;

public class ComponentsFragment extends BaseFragment {


    private TitleBar title_bar;
    private ByRecyclerView recyclerView;
    private ComponentsFragmentAdapter adapter;
    private List<String> datas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_components, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title_bar = view.findViewById(R.id.title_bar);
        title_bar.getLeftTextView().setTypeface(title_bar.getLeftTextView().getTypeface(), Typeface.BOLD);
        recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        GridSpaceItemDecoration itemDecoration = new GridSpaceItemDecoration(10, true)
                .setNoShowSpace(0, 0);
        recyclerView.addItemDecoration(itemDecoration);
        datas.add("Fragment");
        datas.add("RecyclerView");
        datas.add("TitleBar");
        adapter = new ComponentsFragmentAdapter(R.layout.item_fragment_components, datas);
        recyclerView.setAdapter(adapter);
        recyclerView.setOnItemClickListener(new ByRecyclerView.OnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(mContext, "点击了" + position, Toast.LENGTH_LONG).show();
                if (datas.get(position).equals("Fragment")) {
                    FragmentDemoActivity.jump(mContext);
                } else if (datas.get(position).equals("RecyclerView")) {

                } else if (datas.get(position).equals("TitleBar")) {
                    TitleBarDemoActivity.jump(mContext);
                }
            }
        });
    }
}
