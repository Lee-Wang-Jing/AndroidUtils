package com.wangjing.utilscode;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class ImageLoaderUtils {
    public static void loadImage(Context context, ImageView imageView, String url) {
        Glide.with(context).load(url).into(imageView);
    }

    public static void loadImage(Fragment fragment, ImageView imageView, String url) {
        Glide.with(fragment).load(url).into(imageView);
    }


    public static void loadImage(Context context, ImageView imageView, Drawable drawable) {
        Glide.with(context).load(drawable).into(imageView);
    }

    public static void loadImage(Fragment fragment, ImageView imageView, Drawable drawable) {
        Glide.with(fragment).load(drawable).into(imageView);
    }

}
