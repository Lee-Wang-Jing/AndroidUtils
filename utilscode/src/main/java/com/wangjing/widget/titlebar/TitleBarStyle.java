package com.wangjing.widget.titlebar;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({TitleBarStyle.STYLE_0,
        TitleBarStyle.STYLE_1,
        TitleBarStyle.STYLE_2,
        TitleBarStyle.STYLE_3,
        TitleBarStyle.STYLE_4,
        TitleBarStyle.STYLE_5,
        TitleBarStyle.STYLE_6,
        TitleBarStyle.STYLE_7,
        TitleBarStyle.STYLE_8,
        TitleBarStyle.STYLE_9,
        TitleBarStyle.STYLE_10,
        TitleBarStyle.STYLE_11,
        TitleBarStyle.STYLE_12,
        TitleBarStyle.STYLE_13,
        TitleBarStyle.STYLE_14,
        TitleBarStyle.STYLE_15,
        TitleBarStyle.STYLE_16,
        TitleBarStyle.STYLE_17,
})
@Retention(RetentionPolicy.SOURCE)
public @interface TitleBarStyle {

    /**
     * 图片 文本 无 默认样式
     */
    int STYLE_0 = 0;//图片 文本 无 默认样式
    int STYLE_1 = 1;//图片 文本 图片
    int STYLE_2 = 2;//图片 文本 文本
    int STYLE_3 = 3;//文本 文本 无
    int STYLE_4 = 4;//文本 文本 图片
    int STYLE_5 = 5;//文本 文本 文本
    int STYLE_6 = 6;//图片 无 无
    int STYLE_7 = 7;//图片 无 图片
    int STYLE_8 = 8;//图片 无 文本
    int STYLE_9 = 9;//文本 无 无
    int STYLE_10 = 10;//文本 无 图片
    int STYLE_11 = 11;//文本 无 文本
    int STYLE_12 = 12;//无 文本 无
    int STYLE_13 = 13;//无 文本 图片
    int STYLE_14 = 14;//无 文本 文本
    int STYLE_15 = 15;//无 无 无
    int STYLE_16 = 16;//无 无 图片
    int STYLE_17 = 17;//无 无 文本
}
