package com.example.willy.projet_ihm_android.fragment_view;

/**
 * Created by Willy on 10/04/2016.
 */

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.willy.projet_ihm_android.R;
/**
 * Created by Willy on 07/04/2016.
 */
public class DescriptionFoodFragment extends PaneFragment {

    private TextView food_name;
    private TextView food_desc;
    private TextView food_prix;
    private Button buttonAddPanier;
    private ImageView food_img;

    private String name;
    private String desc;
    private String prix;
    private Drawable img;


    public DescriptionFoodFragment(String n, String d, String p, Drawable i) {
        name = n;
        desc = d;
        prix = p;
        img=i;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.description_food, container, false);
        food_img = (ImageView) view.findViewById(R.id.food_img);
        food_name = (TextView) view.findViewById(R.id.food_name);
        food_desc= (TextView) view.findViewById(R.id.food_desc);
        food_prix= (TextView) view.findViewById(R.id.food_prix);
        buttonAddPanier = (Button) view.findViewById(R.id.buttonAddPanier);

        food_name.setText("NOM DU PLAT :\n"+name);
        food_desc.setText("\nDESCRIPTION :\n"+desc);
        food_prix.setText("\nPRIX :\n"+prix);
        food_img.setImageDrawable(img);
        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
