package com.example.willy.projet_ihm_android.fragment_view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
public class EntreeFragment extends PaneFragment {
    MainActivity act ;

    int cpt=0;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        gridView = (StaggeredGridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(ImageAdapter.getEntreeImageAdapter(getActivity()));


        gridView.setOnItemClickListener(new StaggeredGridView.OnItemClickListener() {
            public void onItemClick(StaggeredGridView parento, View vo,
                                    int positiono, long id) {
                // Toast.makeText(getActivity(), "" + position,
                //         Toast.LENGTH_SHORT).show();

                final StaggeredGridView parent = parento;
                final View v = vo;
                final int position = positiono;
                cpt++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        if (cpt == 1) {
                            System.out.println("ClickSIMPLE///////////////////////////////////");
                            cpt = 0;


                            String itemId = ((ImageAdapter.Item) (parent.getAdapter().getItem(position))).name;
                            Drawable i = null;
                            String n = null;
                            String d = null;
                            String p = null;
                            switch (itemId) {
                                case "item7":
                                    i = getActivity().getResources().getDrawable(R.drawable.food_entree_item7);
                                    break;
                                case "item8":
                                    i = getActivity().getResources().getDrawable(R.drawable.food_entree_item8);
                                    break;
                                case "item9":
                                    i = getActivity().getResources().getDrawable(R.drawable.food_entree_item9);
                                    break;
                                case "item10":
                                    i = getActivity().getResources().getDrawable(R.drawable.food_entree_item10);
                                    break;
                                case "item11":
                                    i = getActivity().getResources().getDrawable(R.drawable.food_entree_item11);
                                    break;
                                case "item12":
                                    i = getActivity().getResources().getDrawable(R.drawable.food_entree_item12);
                                    break;
                                case "item13":
                                    i = getActivity().getResources().getDrawable(R.drawable.food_entree_item13);
                                    break;

                            }

                            switch (itemId) {
                                case "item7":
                                    n = getActivity().getResources().getString(R.string.item7_name);
                                    break;
                                case "item8":
                                    n = getActivity().getResources().getString(R.string.item8_name);
                                    break;
                                case "item9":
                                    n = getActivity().getResources().getString(R.string.item9_name);
                                    break;
                                case "item10":
                                    n = getActivity().getResources().getString(R.string.item10_name);
                                    break;
                                case "item11":
                                    n = getActivity().getResources().getString(R.string.item11_name);
                                    break;
                                case "item12":
                                    n = getActivity().getResources().getString(R.string.item12_name);
                                    break;
                                case "item13":
                                    n = getActivity().getResources().getString(R.string.item13_name);
                                    break;
                            }

                            switch (itemId) {
                                case "item7":
                                    d = getActivity().getResources().getString(R.string.item7_desc);
                                    break;
                                case "item8":
                                    d = getActivity().getResources().getString(R.string.item8_desc);
                                    break;
                                case "item9":
                                    d = getActivity().getResources().getString(R.string.item9_desc);
                                    break;
                                case "item10":
                                    d = getActivity().getResources().getString(R.string.item10_desc);
                                    break;
                                case "item11":
                                    d = getActivity().getResources().getString(R.string.item11_desc);
                                    break;
                                case "item12":
                                    d = getActivity().getResources().getString(R.string.item12_desc);
                                    break;
                                case "item13":
                                    d = getActivity().getResources().getString(R.string.item13_desc);
                                    break;
                            }

                            switch (itemId) {
                                case "item7":
                                    p = getActivity().getResources().getString(R.string.item7_price);
                                    break;
                                case "item8":
                                    p = getActivity().getResources().getString(R.string.item8_price);
                                    break;
                                case "item9":
                                    p = getActivity().getResources().getString(R.string.item9_price);
                                    break;
                                case "item10":
                                    p = getActivity().getResources().getString(R.string.item10_price);
                                    break;
                                case "item11":
                                    p = getActivity().getResources().getString(R.string.item11_price);
                                    break;
                                case "item12":
                                    p = getActivity().getResources().getString(R.string.item12_price);
                                    break;
                                case "item13":
                                    p = getActivity().getResources().getString(R.string.item13_price);
                                    break;
                            }


                            act = (MainActivity) getActivity();
                            act.afficheDesc(n, d, p, i);

                            // On va ajouter l'item dans le panier
                          
                        }
                    }
                };


                if (cpt == 1) {
                    handler.postDelayed(r, 300);
                } else if (cpt == 2) {
                    //Double click
                    cpt = 0;
                    System.out.println("/////////////////////////////DOUBLE CLICK/////////");
                }



/*
                    // ça c'est l'id de l'item tu peux le modifier dans les constructeurs de ImageAdapter

*/
            }
        });
        return gridView;
    }

}
