package com.wangjing.widget.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wangjing.utilscode.ConvertUtils;
import com.wangjing.utilscode.R;

public class TitleBar extends FrameLayout {

    private FrameLayout fl_left;
    private TextView tv_left_text;
    private ImageView iv_left_image;

    private FrameLayout fl_center;
    private TextView tv_center_text;

    private FrameLayout fl_right;
    private TextView tv_right_text;
    private ImageView iv_right_image;

    private Context mContext;

    public TitleBar(@NonNull Context context) {
        this(context, null);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View rootView = layoutInflater.inflate(R.layout.layout_base_titlebar, this, true);
        initAttribute(context, attrs);
        initView(rootView);
        initListener();
        initViewData();
    }

    protected String mLeftText;
    protected int mLeftTextColor;
    protected float mLeftTextSize;
    protected int mLeftImageResId;


    protected String mCenterText;
    protected int mCenterTextColor;
    protected float mCenterTextSize;


    protected String mRightText;
    protected int mRightTextColor;
    protected float mRightTextSize;
    protected int mRightImageResId;
    protected int mStyle = TitletBarStyle.STYLE_0;

    private void initAttribute(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WJ_TitleBar);
        mLeftText = typedArray.getString(R.styleable.WJ_TitleBar_titleBar_left_text);
        mLeftTextColor = typedArray.getDimensionPixelSize(R.styleable.WJ_TitleBar_titleBar_left_text_color, Color.parseColor("#666666"));
        mLeftTextSize = typedArray.getDimensionPixelSize(R.styleable.WJ_TitleBar_titleBar_left_text_size, ConvertUtils.sp2px(18));
        mLeftImageResId = typedArray.getResourceId(R.styleable.WJ_TitleBar_titleBar_left_image, R.mipmap.wj_ic_back);

        mCenterText = typedArray.getString(R.styleable.WJ_TitleBar_titleBar_center_text);
        mCenterTextColor = typedArray.getColor(R.styleable.WJ_TitleBar_titleBar_center_text_color, Color.parseColor("#666666"));
        mCenterTextSize = typedArray.getDimensionPixelSize(R.styleable.WJ_TitleBar_titleBar_center_text_size, ConvertUtils.sp2px(18));


        mRightText = typedArray.getString(R.styleable.WJ_TitleBar_titleBar_right_text);
        mRightTextColor = typedArray.getColor(R.styleable.WJ_TitleBar_titleBar_right_text_color, Color.parseColor("#666666"));
        mRightTextSize = typedArray.getDimensionPixelSize(R.styleable.WJ_TitleBar_titleBar_right_text_size, ConvertUtils.sp2px(18));
        mRightImageResId = typedArray.getResourceId(R.styleable.WJ_TitleBar_titleBar_right_image, -1);
        mStyle = typedArray.getInteger(R.styleable.WJ_TitleBar_titleBar_style, TitletBarStyle.STYLE_0);
        typedArray.recycle();
    }


    private void initView(View rootView) {
        fl_left = rootView.findViewById(R.id.fl_left);
        tv_left_text = rootView.findViewById(R.id.tv_left_text);
        iv_left_image = rootView.findViewById(R.id.iv_left_image);

        fl_center = rootView.findViewById(R.id.fl_center);
        tv_center_text = rootView.findViewById(R.id.tv_center_text);

        fl_right = rootView.findViewById(R.id.fl_right);
        tv_right_text = rootView.findViewById(R.id.tv_right_text);
        iv_right_image = rootView.findViewById(R.id.iv_right_image);
    }

    private void initListener() {

    }

    private void initViewData() {

    }
}
