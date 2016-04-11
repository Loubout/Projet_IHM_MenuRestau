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
        imgAdapt.mItems.add(new Item("item1", R.drawable.food_accompagnement_item1, R.string.item1_name, R.string.item1_price));
        imgAdapt.mItems.add(new Item("item2", R.drawable.food_accompagnement_item2, R.string.item2_name, R.string.item2_price));
        imgAdapt.mItems.add(new Item("item3", R.drawable.food_accompagnement_item3, R.string.item3_name, R.string.item3_price));
        return imgAdapt;
    }



    public static ImageAdapter getDessertsImageAdapter (Context context){
        ImageAdapter imgAdapt = new ImageAdapter(context);
        imgAdapt.mItems.add(new Item("item4", R.drawable.food_dessert_item4, R.string.item4_name, R.string.item4_price));
        imgAdapt.mItems.add(new Item("item6", R.drawable.food_dessert_item5, R.string.item5_name, R.string.item5_price));
        imgAdapt.mItems.add(new Item("item5", R.drawable.food_dessert_item6, R.string.item6_name, R.string.item6_price));
        return imgAdapt;
    }

    public static ImageAdapter getDishesImageAdapter (Context context){
        ImageAdapter imgAdapt = new ImageAdapter(context);
        imgAdapt.mItems.add(new Item("item14", R.drawable.food_plat_item14, R.string.item14_name, R.string.item14_price));
        imgAdapt.mItems.add(new Item("item15", R.drawable.food_plat_item15, R.string.item15_name, R.string.item15_price));
        imgAdapt.mItems.add(new Item("item16", R.drawable.food_plat_item16, R.string.item16_name, R.string.item16_price));
        imgAdapt.mItems.add(new Item("item17", R.drawable.food_plat_item17, R.string.item17_name, R.string.item17_price));
        imgAdapt.mItems.add(new Item("item18", R.drawable.food_plat_item18, R.string.item18_name, R.string.item18_price));
        return imgAdapt;
    }

    public static ImageAdapter getEntreeImageAdapter(Context context){
        ImageAdapter imgAdapt = new ImageAdapter(context);
        imgAdapt.mItems.add(new Item("item7", R.drawable.food_entree_item7, R.string.item7_name, R.string.item7_price));
        imgAdapt.mItems.add(new Item("item8", R.drawable.food_entree_item8, R.string.item8_name, R.string.item8_price));
        imgAdapt.mItems.add(new Item("item9", R.drawable.food_entree_item9, R.string.item9_name, R.string.item9_price));
        imgAdapt.mItems.add(new Item("item10", R.drawable.food_entree_item10, R.string.item10_name, R.string.item10_price));
        imgAdapt.mItems.add(new Item("item11", R.drawable.food_entree_item11, R.string.item11_name, R.string.item11_price));
        imgAdapt.mItems.add(new Item("item12", R.drawable.food_entree_item12, R.string.item12_name, R.string.item12_price));
        imgAdapt.mItems.add(new Item("item13", R.drawable.food_entree_item13, R.string.item13_name, R.string.item13_price));
        return imgAdapt;
    }

    public static ImageAdapter getDrinksImageAdapter(Context context){
        ImageAdapter imgAdapt = new ImageAdapter(context);
        imgAdapt.mItems.add(new Item("item19", R.drawable.food_boisson_item19, R.string.item19_name, R.string.cocktail_price));
        imgAdapt.mItems.add(new Item("item20", R.drawable.food_boisson_item20, R.string.item20_name, R.string.cocktail_price));
        imgAdapt.mItems.add(new Item("item21", R.drawable.food_boisson_item21, R.string.item21_name, R.string.cocktail_price));
        imgAdapt.mItems.add(new Item("item22", R.drawable.food_boisson_item22, R.string.item22_name, R.string.cocktail_price));
        imgAdapt.mItems.add(new Item("item23", R.drawable.food_boisson_item23, R.string.item23_name, R.string.cocktail_price));
        imgAdapt.mItems.add(new Item("item24", R.drawable.food_boisson_item24, R.string.item24_name, R.string.cocktail_price));
        imgAdapt.mItems.add(new Item("item25", R.drawable.food_boisson_item25, R.string.item25_name, R.string.cocktail_price));
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
        name = (TextView) v.getTag(R.id.text);

        Item item = getItem(i);


        picture.setImageResource(item.drawableId);
        name.setText(mInflater.getContext().getResources().getString(item.nameId) + " " + mInflater.getContext().getResources().getString(item.priceId));

        return v;
    }

    public static class Item {
        public final String name;
        public final int drawableId;
        public final int nameId;
        public final int priceId;

        Item(String name, int drawableId, int nameId, int priceId) {
            this.name = name;
            this.drawableId = drawableId;
            this.nameId = nameId;
            this.priceId = priceId;
        }
    }
}