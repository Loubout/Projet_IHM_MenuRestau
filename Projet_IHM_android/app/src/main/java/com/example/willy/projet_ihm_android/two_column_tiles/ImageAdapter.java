package com.example.willy.projet_ihm_android.two_column_tiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
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

        mItems.add(new Item("dessert1", R.drawable.food_dessert_item4));
        mItems.add(new Item("dessert2", R.drawable.food_dessert_item6));
        mItems.add(new Item("dessert3", R.drawable.food_dessert_item5));
        mItems.add(new Item("plat1", R.drawable.food_plat_item14));
        mItems.add(new Item("plat2", R.drawable.food_plat_item15));
        mItems.add(new Item("plat3", R.drawable.food_plat_item16));
        mItems.add(new Item("plat4", R.drawable.food_plat_item17));
        mItems.add(new Item("plat5", R.drawable.food_plat_item18));

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
        name.setText(item.name);

        return v;
    }

    private static class Item {
        public final String name;
        public final int drawableId;

        Item(String name, int drawableId) {
            this.name = name;
            this.drawableId = drawableId;
        }
    }
}