package com.example.willy.projet_ihm_android.two_column_tiles;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by lboutin on 08/04/16.
 */
public class TileImageView extends ImageView {
    public TileImageView(Context context) {
        super(context);
    }

    public TileImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TileImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth()); //Snap to width
    }
}

