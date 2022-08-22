package com.wangjing.androidutilsdemo.utils;

import com.wangjing.androidutilsdemo.bean.DataItemBean;

import java.util.ArrayList;

public class DataUtils {
    /**
     * 一般item的数据
     */
    public static ArrayList<DataItemBean> get(int num) {
        ArrayList<DataItemBean> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            DataItemBean bean = new DataItemBean();
            bean.setTitle("数据展示");
            list.add(bean);
        }
        return list;
    }
}
