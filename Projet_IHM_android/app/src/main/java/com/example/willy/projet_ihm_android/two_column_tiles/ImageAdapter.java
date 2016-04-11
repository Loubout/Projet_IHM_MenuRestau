package com.example.willy.projet_ihm_android.two_column_tiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.willy.projet_ihm_android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lboutin on 07/04/16.
 */

public final class ImageAdapter extends BaseAdapter {
    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;

    public ImageAdapter(Context context) {
        mInflater = LayoutInflater.from(context);

    }

    // c'est là qu'on se dit qu'on pourrait une factory ...
    // mais en fait non fuck it
    public static ImageAdapter getAperitifImageAdapter (Context context){
        ImageAdapter imgAdapt = new ImageAdapter(context);
        imgAdapt.mItems.add(new Item("item1", R.drawable.food_accompagnement_item1));
        imgAdapt.mItems.add(new Item("item2", R.drawable.food_accompagnement_item2));
        imgAdapt.mItems.add(new Item("item3", R.drawable.food_accompagnement_item3));
        return imgAdapt;
    }



    public static ImageAdapter getDessertsImageAdapter (Context context){
        ImageAdapter imgAdapt = new ImageAdapter(context);
        imgAdapt.mItems.add(new Item("item4", R.drawable.food_dessert_item4));
        imgAdapt.mItems.add(new Item("item6", R.drawable.food_dessert_item6));
        imgAdapt.mItems.add(new Item("item5", R.drawable.food_dessert_item5));
        return imgAdapt;
    }

    public static ImageAdapter getDishesImageAdapter (Context context){
        ImageAdapter imgAdapt = new ImageAdapter(context);
        imgAdapt.mItems.add(new Item("item14", R.drawable.food_plat_item14));
        imgAdapt.mItems.add(new Item("item15", R.drawable.food_plat_item15));
        imgAdapt.mItems.add(new Item("item16", R.drawable.food_plat_item16));
        imgAdapt.mItems.add(new Item("item17", R.drawable.food_plat_item17));
        imgAdapt.mItems.add(new Item("item18", R.drawable.food_plat_item18));
        return imgAdapt;
    }

    public static ImageAdapter getEntreeImageAdapter(Context context){
        ImageAdapter imgAdapt = new ImageAdapter(context);
        imgAdapt.mItems.add(new Item("item7", R.drawable.food_entree_item7));
        imgAdapt.mItems.add(new Item("item8", R.drawable.food_entree_item8));
        imgAdapt.mItems.add(new Item("item9", R.drawable.food_entree_item9));
        imgAdapt.mItems.add(new Item("item10", R.drawable.food_entree_item10));
        imgAdapt.mItems.add(new Item("item11", R.drawable.food_entree_item11));
        imgAdapt.mItems.add(new Item("item12", R.drawable.food_entree_item12));
        imgAdapt.mItems.add(new Item("item13", R.drawable.food_entree_item13));
        return imgAdapt;
    }

    public static ImageAdapter getDrinksImageAdapter(Context context){
        ImageAdapter imgAdapt = new ImageAdapter(context);
        imgAdapt.mItems.add(new Item("Cuba Libre", R.drawable.food_boisson_2));
        imgAdapt.mItems.add(new Item("Little Tickle", R.drawable.food_boisson_3));
        imgAdapt.mItems.add(new Item("Vanilla Pear Drop", R.drawable.food_boisson_4));
        imgAdapt.mItems.add(new Item("Blue Hawaiian", R.drawable.food_boisson_5));
        imgAdapt.mItems.add(new Item("Mary Pickford", R.drawable.food_boisson_6));
        imgAdapt.mItems.add(new Item("Winter Daiquiri", R.drawable.food_boisson_7));
        imgAdapt.mItems.add(new Item("Marseillan", R.drawable.food_boisson_8));
        return imgAdapt;
    }



    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView picture;
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.tile_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }

        picture = (ImageView) v.getTag(R.id.picture);
        //name = (TextView) v.getTag(R.id.text);

        Item item = getItem(i);

        picture.setImageResource(item.drawableId);
       // name.setText(item.name);

        return v;
    }

    public static class Item {
        public final String name;
        public final int drawableId;

        Item(String name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}