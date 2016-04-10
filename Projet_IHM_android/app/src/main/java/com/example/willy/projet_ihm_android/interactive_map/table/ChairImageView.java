package com.example.willy.projet_ihm_android.interactive_map.table;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.example.willy.projet_ihm_android.data.Chair;

import com.example.willy.projet_ihm_android.data.enumeration.ChairState;
/**
 * Created by tanguinoche on 01/04/16.
 */
public class ChairImageView extends ImageView {
    public Chair getChairModel() {
        return chairModel;
    }

    Chair chairModel;
    private int state=-1;


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
        this.state = ChairState.getImgState(c, img);
    }

    public void changeColor() {
        this.state = (state+4)%ChairState.getNbState();
        int id = ChairState.getDrawableId(state);
        this.setImageResource(id);
        Log.d("CHAIRIMAGEVIEW", "changeColor");
        chairModel.setColor(state);
    }

    public int getColor() {
        return state;
    }

    public void setColor(int newColor) {

        int positionChair = state - state/4*4; //LEFT=0, RIGHT=1, TOP=2, BOTTOM=3.
        int baseColor = newColor/4*4; //The chair with the color "color", in the position 0.
        this.state = baseColor + positionChair;
        int id = ChairState.getDrawableId(this.state);
        this.setImageResource(id);
        chairModel.setColor(state);
    }

    public void setChairModel(Chair chairModel) {

        this.chairModel = chairModel;
        this.setColor(chairModel.getColor());
    }
}
