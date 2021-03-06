package com.example.willy.projet_ihm_android.two_column_tiles;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by lboutin on 08/04/16.
 */
public class TileImageView extends ImageView {
    public TileImageView(Context context) {
        super(context);
    }

    private boolean scaleToWidth = false;

    public TileImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setScaleType(ScaleType.CENTER_INSIDE);
    }

    public TileImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /*@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth()); //Snap to width
    }*/

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        /**
         * if both width and height are set scale width first. modify in future if necessary
         */

        if(widthMode == MeasureSpec.EXACTLY || widthMode == MeasureSpec.AT_MOST){
            scaleToWidth = true;
        }else if(heightMode == MeasureSpec.EXACTLY || heightMode == MeasureSpec.AT_MOST){
            scaleToWidth = false;
        }else throw new IllegalStateException("width or height needs to be set to match_parent or a specific dimension");

        if(getDrawable()==null || getDrawable().getIntrinsicWidth()==0 ){
            // nothing to measure
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }else{
            if(scaleToWidth){
                int iw = this.getDrawable().getIntrinsicWidth();
                int ih = this.getDrawable().getIntrinsicHeight();
                int heightC = width*ih/iw;
                if(height > 0)
                    if(heightC>height){
                        // dont let hegiht be greater then set max
                        heightC = height;
                        width = heightC*iw/ih;
                    }

                this.setScaleType(ScaleType.CENTER_CROP);
                setMeasuredDimension(width, heightC);

            }else{
                // need to scale to height instead
                int marg = 0;
                if(getParent()!=null){
                    if(getParent().getParent()!=null){
                        marg+= ((RelativeLayout) getParent().getParent()).getPaddingTop();
                        marg+= ((RelativeLayout) getParent().getParent()).getPaddingBottom();
                    }
                }

                int iw = this.getDrawable().getIntrinsicWidth();
                int ih = this.getDrawable().getIntrinsicHeight();

                width = height*iw/ih;
                height-=marg;
                setMeasuredDimension(width, height);
            }

        }
    }
}

