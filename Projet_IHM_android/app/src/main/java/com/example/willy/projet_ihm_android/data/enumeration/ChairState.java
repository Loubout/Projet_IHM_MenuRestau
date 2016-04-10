package com.example.willy.projet_ihm_android.data.enumeration;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.example.willy.projet_ihm_android.R;

/**
 * Created by tanguinoche on 08/04/16.
 */
public final class ChairState {
    public static final int LEFT_GRAY=0, RIGHT_GRAY=1, TOP_GRAY=2, BOTTOM_GRAY=3;
    public static final int LEFT_GREEN=4, RIGHT_GREEN=5, TOP_GREEN=6, BOTTOM_GREEN=7;
    public static final int LEFT_YELLOW=8, RIGHT_YELLOW=9, TOP_YELLOW=10, BOTTOM_YELLOW=11;
    public static final int LEFT_TURQUOISE=12, RIGHT_TURQUOISE=13, TOP_TURQUOISE=14, BOTTOM_TURQUOISE=15;
    public static final int LEFT_ORANGE=16, RIGHT_ORANGE=17, TOP_ORANGE=18, BOTTOM_ORANGE=19;
    public static final int LEFT_PURPLE=20, RIGHT_PURPLE=21, TOP_PURPLE=22, BOTTOM_PURPLE=23;
    public static final int LEFT_BLUE=24, RIGHT_BLUE=25, TOP_BLUE=26, BOTTOM_BLUE=27;
    public static final int LEFT_RED=28, RIGHT_RED=29, TOP_RED=30, BOTTOM_RED=31;
    public static final int LEFT_PINK=32, RIGHT_PINK=33, TOP_PINK=34, BOTTOM_PINK=35;
    public static final int LEFT_GROWN=36, RIGHT_GROWN=37, TOP_GROWN=38, BOTTOM_GROWN=39;


    private static final int[] drawables = {
            R.drawable.left_gray, R.drawable.right_gray, R.drawable.top_gray, R.drawable.bottom_gray,
            R.drawable.left_green, R.drawable.right_green, R.drawable.top_green, R.drawable.bottom_green,
            R.drawable.left_yellow, R.drawable.right_yellow, R.drawable.top_yellow, R.drawable.bottom_yellow,
            R.drawable.left_turquoise, R.drawable.right_turquoise, R.drawable.top_turquoise, R.drawable.bottom_turquoise,
            R.drawable.left_orange, R.drawable.right_orange, R.drawable.top_orange, R.drawable.bottom_orange,
            R.drawable.left_purple, R.drawable.right_purple, R.drawable.top_purple, R.drawable.bottom_purple,
            R.drawable.left_blue, R.drawable.right_blue, R.drawable.top_blue, R.drawable.bottom_blue,
            R.drawable.left_red, R.drawable.right_red, R.drawable.top_red, R.drawable.bottom_red,
            R.drawable.left_pink, R.drawable.right_pink, R.drawable.top_pink, R.drawable.bottom_pink,
            R.drawable.left_grown, R.drawable.right_grown, R.drawable.top_grown, R.drawable.bottom_grown
    };

    public static int getImgState(Context c, Drawable.ConstantState d) {
        if(d.equals(ContextCompat.getDrawable(c, R.drawable.left_gray).getConstantState())) return ChairState.LEFT_GRAY;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.right_gray).getConstantState())) return ChairState.RIGHT_GRAY;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.top_gray).getConstantState())) return ChairState.TOP_GRAY;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.bottom_gray).getConstantState())) return ChairState.BOTTOM_GRAY;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.left_green).getConstantState())) return ChairState.LEFT_GREEN;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.right_green).getConstantState())) return ChairState.RIGHT_GREEN;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.top_green).getConstantState())) return ChairState.TOP_GREEN;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.bottom_green).getConstantState())) return ChairState.BOTTOM_GREEN;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.left_yellow).getConstantState())) return ChairState.LEFT_YELLOW;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.right_yellow).getConstantState())) return ChairState.RIGHT_YELLOW;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.top_yellow).getConstantState())) return ChairState.TOP_YELLOW;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.bottom_yellow).getConstantState())) return ChairState.BOTTOM_YELLOW;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.left_turquoise).getConstantState())) return ChairState.LEFT_TURQUOISE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.right_turquoise).getConstantState())) return ChairState.RIGHT_TURQUOISE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.top_turquoise).getConstantState())) return ChairState.TOP_TURQUOISE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.bottom_turquoise).getConstantState())) return ChairState.BOTTOM_TURQUOISE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.left_orange).getConstantState())) return ChairState.LEFT_ORANGE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.right_orange).getConstantState())) return ChairState.RIGHT_ORANGE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.top_orange).getConstantState())) return ChairState.TOP_ORANGE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.bottom_orange).getConstantState())) return ChairState.BOTTOM_ORANGE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.left_purple).getConstantState())) return ChairState.LEFT_PURPLE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.right_purple).getConstantState())) return ChairState.RIGHT_PURPLE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.top_purple).getConstantState())) return ChairState.TOP_PURPLE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.bottom_purple).getConstantState())) return ChairState.BOTTOM_PURPLE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.left_blue).getConstantState())) return ChairState.LEFT_BLUE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.right_blue).getConstantState())) return ChairState.RIGHT_BLUE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.top_blue).getConstantState())) return ChairState.TOP_BLUE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.bottom_blue).getConstantState())) return ChairState.BOTTOM_BLUE;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.left_red).getConstantState()))  return ChairState.LEFT_RED;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.right_red).getConstantState())) return ChairState.RIGHT_RED;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.top_red).getConstantState())) return ChairState.TOP_RED;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.bottom_red).getConstantState())) return ChairState.BOTTOM_RED;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.left_pink).getConstantState())) return ChairState.LEFT_PINK;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.right_pink).getConstantState())) return ChairState.RIGHT_PINK;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.top_pink).getConstantState())) return ChairState.TOP_PINK;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.bottom_pink).getConstantState())) return ChairState.BOTTOM_PINK;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.left_grown).getConstantState())) return ChairState.LEFT_GROWN;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.right_grown).getConstantState())) return ChairState.RIGHT_GROWN;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.top_grown).getConstantState())) return ChairState.TOP_GROWN;
        else if(d.equals(ContextCompat.getDrawable(c, R.drawable.bottom_grown).getConstantState())) return ChairState.BOTTOM_GROWN;
        else Log.d("ERROR_DRAWABLE", "Initialisation d'une ChairImageView avec un Drawable inconnu ?!");
        return 0;
    }


    public static int getDrawableId(int color) {
        if(color<0 || color>drawables.length) return drawables[0];
        return drawables[color];
    }

    public static int getNbState() {
        return drawables.length;
    }
}
