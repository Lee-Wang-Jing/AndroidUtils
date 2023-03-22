package com.wangjing.widget.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    private View bottom_line;

    private Context mContext;


    private String mLeftText;
    private int mLeftTextColor;
    private float mLeftTextSize;
    private int mLeftImageResId;


    private String mCenterText;
    private int mCenterTextColor;
    private float mCenterTextSize;


    private String mRightText;
    private int mRightTextColor;
    private float mRightTextSize;
    private int mRightImageResId;

    private int mBottomLineHeight;
    private int mBottomLineColor;
    private int mStyle = TitleBarStyle.STYLE_0;

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

    private void initAttribute(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WJ_TitleBar);
        mLeftText = typedArray.getString(R.styleable.WJ_TitleBar_titleBar_left_text);
        mLeftTextColor = typedArray.getColor(R.styleable.WJ_TitleBar_titleBar_left_text_color, Color.parseColor("#666666"));
        mLeftTextSize = typedArray.getDimensionPixelSize(R.styleable.WJ_TitleBar_titleBar_left_text_size, ConvertUtils.sp2px(18));
        mLeftImageResId = typedArray.getResourceId(R.styleable.WJ_TitleBar_titleBar_left_image, -1);

        mCenterText = typedArray.getString(R.styleable.WJ_TitleBar_titleBar_center_text);
        mCenterTextColor = typedArray.getColor(R.styleable.WJ_TitleBar_titleBar_center_text_color, Color.parseColor("#666666"));
        mCenterTextSize = typedArray.getDimensionPixelSize(R.styleable.WJ_TitleBar_titleBar_center_text_size, ConvertUtils.sp2px(18));


        mRightText = typedArray.getString(R.styleable.WJ_TitleBar_titleBar_right_text);
        mRightTextColor = typedArray.getColor(R.styleable.WJ_TitleBar_titleBar_right_text_color, Color.parseColor("#666666"));
        mRightTextSize = typedArray.getDimensionPixelSize(R.styleable.WJ_TitleBar_titleBar_right_text_size, ConvertUtils.sp2px(18));
        mRightImageResId = typedArray.getResourceId(R.styleable.WJ_TitleBar_titleBar_right_image, -1);

        mBottomLineHeight = typedArray.getDimensionPixelSize(R.styleable.WJ_TitleBar_titleBar_bottom_line_height, 1);
        mBottomLineColor = typedArray.getColor(R.styleable.WJ_TitleBar_titleBar_bottom_line_color, Color.parseColor("#666666"));

        mStyle = typedArray.getInteger(R.styleable.WJ_TitleBar_titleBar_style, TitleBarStyle.STYLE_0);
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

        bottom_line = rootView.findViewById(R.id.bottom_line);
        if (mBottomLineHeight > 0) {
            bottom_line.setVisibility(VISIBLE);
            ViewGroup.LayoutParams params = bottom_line.getLayoutParams();
            params.height = mBottomLineHeight;
            bottom_line.setLayoutParams(params);
            bottom_line.setBackgroundColor(mBottomLineColor);
        } else {
            bottom_line.setVisibility(GONE);
        }
    }

    private void initListener() {
    }

    private void initViewData() {
        hideAllWithStyle();

        if (!TextUtils.isEmpty(mLeftText)) {
            tv_left_text.setText("" + mLeftText);
            tv_left_text.setTextColor(mLeftTextColor);
            tv_left_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mLeftTextSize);
        } else {
            if (mLeftImageResId != -1) {
                iv_left_image.setImageResource(mLeftImageResId);
            }
        }

        if (!TextUtils.isEmpty(mCenterText)) {
            tv_center_text.setText("" + mCenterText);
            tv_center_text.setTextColor(mCenterTextColor);
            tv_center_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mCenterTextSize);
        }

        if (!TextUtils.isEmpty(mRightText)) {
            tv_right_text.setText("" + mRightText);
            tv_right_text.setTextColor(mRightTextColor);
            tv_right_text.setTextSize(TypedValue.COMPLEX_UNIT_PX, mRightTextSize);
        } else {
            if (mRightImageResId != -1) {
                iv_right_image.setImageResource(mRightImageResId);
            }
        }
    }

    private void hideAllWithStyle() {
        if (mStyle == 0) {
            //图片 文本 无 默认样式
            tv_left_text.setVisibility(GONE);
            iv_left_image.setVisibility(VISIBLE);
            tv_center_text.setVisibility(VISIBLE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(GONE);
        } else if (mStyle == 1) {
            //图片 文本 图片
            tv_left_text.setVisibility(GONE);
            iv_left_image.setVisibility(VISIBLE);
            tv_center_text.setVisibility(VISIBLE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(VISIBLE);
        } else if (mStyle == 2) {
            //图片 文本 文本
            tv_left_text.setVisibility(GONE);
            iv_left_image.setVisibility(VISIBLE);
            tv_center_text.setVisibility(VISIBLE);
            tv_right_text.setVisibility(VISIBLE);
            iv_right_image.setVisibility(GONE);
        } else if (mStyle == 3) {
            //文本 文本 无
            tv_left_text.setVisibility(VISIBLE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(VISIBLE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(GONE);
        } else if (mStyle == 4) {
            //文本 文本 图片
            tv_left_text.setVisibility(VISIBLE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(VISIBLE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(VISIBLE);
        } else if (mStyle == 5) {
            //文本 文本 文本
            tv_left_text.setVisibility(VISIBLE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(VISIBLE);
            tv_right_text.setVisibility(VISIBLE);
            iv_right_image.setVisibility(GONE);
        } else if (mStyle == 6) {
            //图片 无 无
            tv_left_text.setVisibility(GONE);
            iv_left_image.setVisibility(VISIBLE);
            tv_center_text.setVisibility(GONE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(GONE);
        } else if (mStyle == 7) {
            //图片 无 图片
            tv_left_text.setVisibility(GONE);
            iv_left_image.setVisibility(VISIBLE);
            tv_center_text.setVisibility(GONE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(VISIBLE);
        } else if (mStyle == 8) {
            //图片 无 文本
            tv_left_text.setVisibility(VISIBLE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(GONE);
            tv_right_text.setVisibility(VISIBLE);
            iv_right_image.setVisibility(GONE);
        } else if (mStyle == 9) {
            //文本 无 无
            tv_left_text.setVisibility(VISIBLE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(GONE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(GONE);
        } else if (mStyle == 10) {
            //文本 无 图片
            tv_left_text.setVisibility(VISIBLE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(GONE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(VISIBLE);
        } else if (mStyle == 11) {
            //文本 无 文本
            tv_left_text.setVisibility(VISIBLE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(GONE);
            tv_right_text.setVisibility(VISIBLE);
            iv_right_image.setVisibility(GONE);
        } else if (mStyle == 12) {
            //无 文本 无
            tv_left_text.setVisibility(GONE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(VISIBLE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(GONE);
        } else if (mStyle == 13) {
            //无 文本 图片
            tv_left_text.setVisibility(GONE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(VISIBLE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(VISIBLE);
        } else if (mStyle == 14) {
            //无 文本 文本
            tv_left_text.setVisibility(GONE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(VISIBLE);
            tv_right_text.setVisibility(VISIBLE);
            iv_right_image.setVisibility(GONE);
        } else if (mStyle == 15) {
            //无 无 无
            tv_left_text.setVisibility(GONE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(GONE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(GONE);
        } else if (mStyle == 16) {
            //无 无 图片
            tv_left_text.setVisibility(GONE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(GONE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(VISIBLE);
        } else if (mStyle == 17) {
            //无 无 文本
            tv_left_text.setVisibility(GONE);
            iv_left_image.setVisibility(GONE);
            tv_center_text.setVisibility(GONE);
            tv_right_text.setVisibility(VISIBLE);
            iv_right_image.setVisibility(GONE);
        } else {
            tv_left_text.setVisibility(GONE);
            iv_left_image.setVisibility(VISIBLE);
            tv_center_text.setVisibility(VISIBLE);
            tv_right_text.setVisibility(GONE);
            iv_right_image.setVisibility(GONE);
        }
    }

    /**
     * @param style 设置显示样式 具体看 @TitleBarStyle
     */
    public void setTitleBarStyle(@TitleBarStyle int style) {
        mStyle = style;
        initViewData();
    }

    public void setCenterTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tv_center_text.setText("" + title);
        }
    }

    public void setLeftOnClick(OnClickListener onClickListener) {
        fl_left.setOnClickListener(onClickListener);
    }

    public void setRightOnClick(OnClickListener onClickListener) {
        fl_right.setOnClickListener(onClickListener);
    }

    public TextView getLeftTextView() {
        return tv_left_text;
    }

    public ImageView getLeftImageView() {
        return iv_left_image;
    }

    public TextView getCenterTextView() {
        return tv_center_text;
    }

    public TextView getRightTextView() {
        return tv_right_text;
    }

    public ImageView getRightImageView() {
        return iv_right_image;
    }

}
