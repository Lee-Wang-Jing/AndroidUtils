package com.wangjing.androidutilsdemo.base;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    protected Context mContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
