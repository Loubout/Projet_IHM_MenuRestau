package com.example.willy.projet_ihm_android.fragment_view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.willy.projet_ihm_android.MainActivity;
import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.two_column_tiles.ImageAdapter;
import com.origamilabs.library.views.StaggeredGridView;

/**
 * Created by Tomohiro on 09/04/16.
 */
public class DessertFragment extends PaneFragment {

    StaggeredGridView dessertView;
    MainActivity act ;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return getDessertView(inflater, container, savedInstanceState);
    }

    /*************
     *  DESSERT  *
     *************/
    public View getDessertView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        dessertView = (StaggeredGridView) view.findViewById(R.id.gridview);
        dessertView.setAdapter(ImageAdapter.getDessertsImageAdapter(getActivity()));

        dessertView.setOnItemClickListener(new StaggeredGridView.OnItemClickListener() {
            public void onItemClick(StaggeredGridView parent, View v,
                                    int position, long id) {
                //Toast.makeText(getActivity(), "" + position,
                 //       Toast.LENGTH_SHORT).show();

                String itemId = ((ImageAdapter.Item)(parent.getAdapter().getItem(position))).name;
                Drawable i=null;
                String  n=null;
                String d = null;
                String p = null;
                switch (itemId) {
                    case "item4":
                        i=getActivity().getResources().getDrawable(R.drawable.food_dessert_item4);
                        break;
                    case "item5":
                        i=getActivity().getResources().getDrawable(R.drawable.food_dessert_item5);
                        break;
                    case "item6":
                        i=getActivity().getResources().getDrawable(R.drawable.food_dessert_item6);
                        break;
                }

                switch (itemId) {
                    case "item4":
                        n=getActivity().getResources().getString(R.string.item4_name);
                        break;
                    case "item5":
                        n=getActivity().getResources().getString(R.string.item5_name);
                        break;
                    case "item6":
                        n=getActivity().getResources().getString(R.string.item6_name);
                        break;
                }

                switch (itemId) {
                    case "item4":
                        d=getActivity().getResources().getString(R.string.item4_desc);
                        break;
                    case "item5":
                        d=getActivity().getResources().getString(R.string.item5_desc);
                        break;
                    case "item6":
                        d=getActivity().getResources().getString(R.string.item6_desc);
                        break;
                }

                switch (itemId) {
                    case "item4":
                        p=getActivity().getResources().getString(R.string.item4_price);
                        break;
                    case "item5":
                        p=getActivity().getResources().getString(R.string.item5_price);
                        break;
                    case "item6":
                        p=getActivity().getResources().getString(R.string.item6_price);
                        break;
                }

                act = (MainActivity) getActivity();
                act.afficheDesc(n, d, p, i);
            }
        });
        return dessertView;
    }
}
