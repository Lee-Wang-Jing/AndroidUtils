package com.wangjing.utilscode;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

public class CopyUtils {
    public static boolean copy(Context context, String copyStr) {
        try {
            //获取剪切板管理器
            ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            //创建普通字符型 ClipData
            ClipData mClipData = ClipData.newPlainText("Lable", copyStr);
            //将ClipData内容放到系统剪切板里
            cm.setPrimaryClip(mClipData);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
