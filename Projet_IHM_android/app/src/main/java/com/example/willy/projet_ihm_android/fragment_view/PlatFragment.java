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
public class PlatFragment extends PaneFragment {
    MainActivity act ;

    StaggeredGridView platView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        platView = (StaggeredGridView) view.findViewById(R.id.gridview);
        platView.setAdapter(ImageAdapter.getDishesImageAdapter(getActivity()));
        platView.setOnItemClickListener(new StaggeredGridView.OnItemClickListener() {
            public void onItemClick(StaggeredGridView parent, View v,
                                    int position, long id) {
              //  Toast.makeText(getActivity(), "" + position,
               //         Toast.LENGTH_SHORT).show();


                String itemId = ((ImageAdapter.Item)(parent.getAdapter().getItem(position))).name;
                Drawable i=null;
                String  n=null;
                String d = null;
                String p = null;
                switch (itemId) {
                    case "item14":
                        i=getActivity().getResources().getDrawable(R.drawable.food_plat_item14);
                        break;
                    case "item15":
                        i=getActivity().getResources().getDrawable(R.drawable.food_plat_item15);
                        break;
                    case "item16":
                        i=getActivity().getResources().getDrawable(R.drawable.food_plat_item16);
                        break;
                    case "item17":
                        i=getActivity().getResources().getDrawable(R.drawable.food_plat_item17);
                        break;
                    case "item18":
                        i=getActivity().getResources().getDrawable(R.drawable.food_plat_item18);
                        break;
                }

                switch (itemId) {
                    case "item14":
                        n=getActivity().getResources().getString(R.string.item14_name);
                        break;
                    case "item15":
                        n=getActivity().getResources().getString(R.string.item15_name);
                        break;
                    case "item16":
                        n=getActivity().getResources().getString(R.string.item16_name);
                        break;
                    case "item17":
                        n=getActivity().getResources().getString(R.string.item17_name);
                        break;
                    case "item18":
                        n=getActivity().getResources().getString(R.string.item18_name);
                        break;
                }

                switch (itemId) {
                    case "item14":
                        d=getActivity().getResources().getString(R.string.item14_desc);
                        break;
                    case "item15":
                        d=getActivity().getResources().getString(R.string.item15_desc);
                        break;
                    case "item16":
                        d=getActivity().getResources().getString(R.string.item16_desc);
                        break;
                    case "item17":
                        d=getActivity().getResources().getString(R.string.item17_desc);
                        break;
                    case "item18":
                        d=getActivity().getResources().getString(R.string.item18_desc);
                        break;
                }

                switch (itemId) {
                    case "item14":
                        p=getActivity().getResources().getString(R.string.item14_price);
                        break;
                    case "item15":
                        p=getActivity().getResources().getString(R.string.item15_price);
                        break;
                    case "item16":
                        p=getActivity().getResources().getString(R.string.item16_price);
                        break;
                    case "item17":
                        p=getActivity().getResources().getString(R.string.item17_price);
                        break;
                    case "item18":
                        p=getActivity().getResources().getString(R.string.item18_price);
                        break;
                }



                act = (MainActivity) getActivity();
                act.afficheDesc(n, d, p, i);


            }
        });
        return platView;
    }

}
