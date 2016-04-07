package com.example.willy.projet_ihm_android.interactive_map.table;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.data.Chair;

/**
 * Created by tanguinoche on 01/04/16.
 */
public class ChairImageView extends ImageView {
    Chair chairModel;
    private int state=-1;
    private static final int LEFT_GRAY=0, RIGHT_GRAY=1, TOP_GRAY=2, BOTTOM_GRAY=3;
    private static final int LEFT_GREEN=4, RIGHT_GREEN=5, TOP_GREEN=6, BOTTOM_GREEN=7;
    private static final int LEFT_YELLOW=8, RIGHT_YELLOW=9, TOP_YELLOW=10, BOTTOM_YELLOW=11;
    private static final int LEFT_TURQUOISE=12, RIGHT_TURQUOISE=13, TOP_TURQUOISE=14, BOTTOM_TURQUOISE=15;
    private static final int LEFT_ORANGE=16, RIGHT_ORANGE=17, TOP_ORANGE=18, BOTTOM_ORANGE=19;
    private static final int LEFT_PURPLE=20, RIGHT_PURPLE=21, TOP_PURPLE=22, BOTTOM_PURPLE=23;
    private static final int LEFT_BLUE=24, RIGHT_BLUE=25, TOP_BLUE=26, BOTTOM_BLUE=27;
    private static final int LEFT_RED=28, RIGHT_RED=29, TOP_RED=30, BOTTOM_RED=31;
    private static final int LEFT_PINK=32, RIGHT_PINK=33, TOP_PINK=34, BOTTOM_PINK=35;
    private static final int LEFT_GROWN=36, RIGHT_GROWN=37, TOP_GROWN=38, BOTTOM_GROWN=39;

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
    //Constructeurs :
    public ChairImageView(Context context, AttributeSet attrs, int defaultStyle) {
        super(context, attrs, defaultStyle);
        initialTag();
    }

    public ChairImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialTag();
    }

    public ChairImageView(Context context) {
        super(context);
        initialTag();
    }

    //Juste pour déterminer quel sprite a été affecté au départ !
    private void initialTag() {
        Drawable.ConstantState img = this.getDrawable().getConstantState();
        Context c = getContext();
        if(img.equals(ContextCompat.getDrawable(c, R.drawable.left_gray).getConstantState())) this.state=LEFT_GRAY;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.right_gray).getConstantState())) this.state=RIGHT_GRAY;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.top_gray).getConstantState())) this.state=TOP_GRAY;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.bottom_gray).getConstantState())) this.state=BOTTOM_GRAY;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.left_green).getConstantState())) this.state=LEFT_GREEN;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.right_green).getConstantState())) this.state=RIGHT_GREEN;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.top_green).getConstantState())) this.state=TOP_GREEN;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.bottom_green).getConstantState())) this.state=BOTTOM_GREEN;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.left_yellow).getConstantState())) this.state=LEFT_YELLOW;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.right_yellow).getConstantState())) this.state=RIGHT_YELLOW;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.top_yellow).getConstantState())) this.state=TOP_YELLOW;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.bottom_yellow).getConstantState())) this.state=BOTTOM_YELLOW;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.left_turquoise).getConstantState())) this.state=LEFT_TURQUOISE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.right_turquoise).getConstantState())) this.state=RIGHT_TURQUOISE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.top_turquoise).getConstantState())) this.state=TOP_TURQUOISE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.bottom_turquoise).getConstantState())) this.state=BOTTOM_TURQUOISE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.left_orange).getConstantState())) this.state=LEFT_ORANGE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.right_orange).getConstantState())) this.state=RIGHT_ORANGE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.top_orange).getConstantState())) this.state=TOP_ORANGE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.bottom_orange).getConstantState())) this.state=BOTTOM_ORANGE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.left_purple).getConstantState())) this.state=LEFT_PURPLE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.right_purple).getConstantState())) this.state=RIGHT_PURPLE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.top_purple).getConstantState())) this.state=TOP_PURPLE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.bottom_purple).getConstantState())) this.state=BOTTOM_PURPLE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.left_blue).getConstantState())) this.state=LEFT_BLUE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.right_blue).getConstantState())) this.state=RIGHT_BLUE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.top_blue).getConstantState())) this.state=TOP_BLUE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.bottom_blue).getConstantState())) this.state=BOTTOM_BLUE;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.left_red).getConstantState()))  this.state=LEFT_RED;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.right_red).getConstantState())) this.state=RIGHT_RED;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.top_red).getConstantState())) this.state=TOP_RED;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.bottom_red).getConstantState())) this.state=BOTTOM_RED;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.left_pink).getConstantState())) this.state=LEFT_PINK;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.right_pink).getConstantState())) this.state=RIGHT_PINK;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.top_pink).getConstantState())) this.state=TOP_PINK;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.bottom_pink).getConstantState())) this.state=BOTTOM_PINK;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.left_grown).getConstantState())) this.state=LEFT_GROWN;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.right_grown).getConstantState())) this.state=RIGHT_GROWN;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.top_grown).getConstantState())) this.state=TOP_GROWN;
        else if(img.equals(ContextCompat.getDrawable(c, R.drawable.bottom_grown).getConstantState())) this.state=BOTTOM_GROWN;
        else Log.d("ERROR_DRAWABLE", "Initialisation d'une ChairImageView avec un Drawable inconnu ?!");
    }

    public void changeColor() {
        this.state = (state+4)%drawables.length;
        this.setImageResource(drawables[state]);
    }

    public int getColor() {
        return state;
    }

    public void setColor(int color) {
        if(color<0 || color>drawables.length) return;
        int positionChair = state - state/4*4; //LEFT=0, RIGHT=1, TOP=2, BOTTOM=3.
        int baseColor = color/4*4; //The chair with the color "color", in the position 0.
        this.state = baseColor + positionChair;
        this.setImageResource(drawables[state]);
    }

    public void setChairModel(Chair chairModel) {
        this.chairModel = chairModel;
    }
}
