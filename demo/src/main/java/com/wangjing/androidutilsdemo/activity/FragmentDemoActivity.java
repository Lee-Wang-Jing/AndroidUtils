package com.wangjing.androidutilsdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.wangjing.androidutilsdemo.R;
import com.wangjing.androidutilsdemo.base.BaseActivity;
import com.wangjing.androidutilsdemo.fragment.Fragment1;
import com.wangjing.androidutilsdemo.fragment.Fragment2;
import com.wangjing.androidutilsdemo.fragment.Fragment3;
import com.wangjing.utilscode.FragmentUtils;

import java.util.ArrayList;
import java.util.List;

public class FragmentDemoActivity extends BaseActivity implements View.OnClickListener {

    public static void jump(Context context) {
        context.startActivity(new Intent(context, FragmentDemoActivity.class));
    }

    private Button btn_tab1, btn_tab2, btn_tab3;
    private Fragment fragment1, fragment2, fragment3;
    private List<Fragment> fragmentList = new ArrayList<>();
    private int nowFragmentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        initView();
        initFragment();
    }

    private void initFragment() {
        FragmentUtils.add(getSupportFragmentManager(), getFragmentList(), R.id.container, 0);
    }

    private List<Fragment> getFragmentList() {
        fragmentList.clear();
        if (fragment1 == null) {
            fragment1 = new Fragment1();
        }
        if (fragment2 == null) {
            fragment2 = new Fragment2();
        }
        if (fragment3 == null) {
            fragment3 = new Fragment3();
        }
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        return fragmentList;
    }

    private void initView() {
        btn_tab1 = findViewById(R.id.btn_tab1);
        btn_tab2 = findViewById(R.id.btn_tab2);
        btn_tab3 = findViewById(R.id.btn_tab3);
        btn_tab1.setOnClickListener(this);
        btn_tab2.setOnClickListener(this);
        btn_tab3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_tab1) {
            switchFragment(fragment1);
        } else if (view.getId() == R.id.btn_tab2) {
            switchFragment(fragment2);
        } else if (view.getId() == R.id.btn_tab3) {
            switchFragment(fragment3);
        } else {
            Log.e("MainActivity", "未知ID");
        }
    }

    private void switchFragment(Fragment fragment) {
        FragmentUtils.showHide(fragment, getFragmentList().remove(nowFragmentPosition));
        if (fragment instanceof Fragment1) {
            nowFragmentPosition = 0;
        } else if (fragment instanceof Fragment2) {
            nowFragmentPosition = 1;
        } else if (fragment instanceof Fragment3) {
            nowFragmentPosition = 2;
        } else {
            nowFragmentPosition = 0;
        }
    }
}