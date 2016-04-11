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
public class AperitifFragment extends PaneFragment {
    MainActivity act ;

    StaggeredGridView aperitifView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("Aperitif View");
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        aperitifView = (StaggeredGridView) view.findViewById(R.id.gridview);
        aperitifView.setAdapter(ImageAdapter.getAperitifImageAdapter(getActivity()));

        aperitifView.setOnItemClickListener(new StaggeredGridView.OnItemClickListener() {
            public void onItemClick(StaggeredGridView parent, View v,
                                    int position, long id) {
               // Toast.makeText(getActivity(), "" + position,
               //         Toast.LENGTH_SHORT).show();


                // ça c'est l'id de l'item tu peux le modifier dans les constructeurs de ImageAdapter
                String itemId = ((ImageAdapter.Item)(parent.getAdapter().getItem(position))).name;
                Drawable i=null;
                String  n=null;
                String d = null;
                String p = null;
                switch (itemId) {
                    case "item1":
                        i=getActivity().getResources().getDrawable(R.drawable.food_accompagnement_item1);
                        break;
                    case "item2":
                        i=getActivity().getResources().getDrawable(R.drawable.food_accompagnement_item2);
                        break;
                    case "item3":
                        i=getActivity().getResources().getDrawable(R.drawable.food_accompagnement_item3);
                        break;
                }

                switch (itemId) {
                    case "item1":
                        n=getActivity().getResources().getString(R.string.item1_name);
                        break;
                    case "item2":
                        n=getActivity().getResources().getString(R.string.item2_name);
                        break;
                    case "item3":
                        n=getActivity().getResources().getString(R.string.item3_name);
                        break;
                }

                switch (itemId) {
                    case "item1":
                        d=getActivity().getResources().getString(R.string.item1_desc);
                        break;
                    case "item2":
                        d=getActivity().getResources().getString(R.string.item2_desc);
                        break;
                    case "item3":
                        d=getActivity().getResources().getString(R.string.item3_desc);
                        break;
                }

                switch (itemId) {
                    case "item1":
                        p=getActivity().getResources().getString(R.string.item1_price);
                        break;
                    case "item2":
                        p=getActivity().getResources().getString(R.string.item2_price);
                        break;
                    case "item3":
                        p=getActivity().getResources().getString(R.string.item3_price);
                        break;
                }

                act = (MainActivity) getActivity();
                act.afficheDesc(n, d, p, i);



            }
        });
        System.out.println("endActivity");
        return aperitifView;
    }
}
