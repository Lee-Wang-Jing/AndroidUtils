package com.wangjing.androidutilsdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.wangjing.androidutilsdemo.R;
import com.wangjing.androidutilsdemo.base.BaseActivity;
import com.wangjing.widget.titlebar.TitleBar;

public class TitleBarDemoActivity extends BaseActivity {
    public static void jump(Context context) {
        context.startActivity(new Intent(context, TitleBarDemoActivity.class));
    }


    private TitleBar title_bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titlebar_demo);
        title_bar = findViewById(R.id.title_bar);

        title_bar.setLeftOnClick(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
