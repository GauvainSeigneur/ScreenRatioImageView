package com.example.gauvain.screenratioimageview;

/**
 * Created by Gauvain on 27/01/2017.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;


public class ScreenRatioImageView extends ImageView {

    private int mScreenWidthPercent;
    private int mScreenHeightPercent;

    public ScreenRatioImageView(Context context) {
        super(context);
    }

    public ScreenRatioImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.SreenRatioImageView,
                0, 0);

        try {
            //Retrieve dimension in percentage of imageview you set up in XML
            mScreenWidthPercent = a.getInt(R.styleable.SreenRatioImageView_ScreenWidthPercent, -1);
            mScreenHeightPercent = a.getInt(R.styleable.SreenRatioImageView_ScreenHeightPercent, -1);
        } finally {
            //Release so you can reuse it
            a.recycle();
        }
    }

    public ScreenRatioImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }
    //getter for width parameter
    public int getmScreenWidthRatio() {
        return mScreenWidthPercent;
    }
    //getter for height parameter
    public int getmScreenHeightRatio() {
        return mScreenHeightPercent;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthPercent = getmScreenWidthRatio();
        int heightPercent = getmScreenHeightRatio();

        Drawable d = getDrawable();
        if (d != null) {
            //set imageview size according to the parameters set in XML
            int w = (MeasureSpec.getSize(widthMeasureSpec)*widthPercent/100);
            int h = (MeasureSpec.getSize(heightMeasureSpec)*heightPercent/100);

            setMeasuredDimension(w, h);
        }
        else super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}