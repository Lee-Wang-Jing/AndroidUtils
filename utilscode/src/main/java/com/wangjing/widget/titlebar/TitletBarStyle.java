package com.wangjing.widget.titlebar;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
        TitletBarStyle.STYLE_0,
        TitletBarStyle.STYLE_1,
        TitletBarStyle.STYLE_2,
        TitletBarStyle.STYLE_3,
        TitletBarStyle.STYLE_4,
        TitletBarStyle.STYLE_5,
        TitletBarStyle.STYLE_6,
        TitletBarStyle.STYLE_7,
        TitletBarStyle.STYLE_8,
        TitletBarStyle.STYLE_9,
        TitletBarStyle.STYLE_10,
        TitletBarStyle.STYLE_11,
})
@Retention(RetentionPolicy.SOURCE)
public @interface TitletBarStyle {

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
}
