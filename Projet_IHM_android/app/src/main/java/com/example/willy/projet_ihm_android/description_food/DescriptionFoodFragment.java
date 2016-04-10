package com.example.willy.projet_ihm_android.description_food;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.willy.projet_ihm_android.R;
/**
 * Created by Willy on 07/04/2016.
 */
public class DescriptionFoodFragment extends Fragment {

    private TextView food_name;
    private TextView food_desc;
    private TextView food_prix;
    private Button buttonAddPanier;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.description_food, container, false);

        food_name = (TextView) view.findViewById(R.id.food_name);
        food_desc= (TextView) view.findViewById(R.id.food_desc);
        food_prix= (TextView) view.findViewById(R.id.food_prix);
        buttonAddPanier = (Button) view.findViewById(R.id.buttonAddPanier);

        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
