package com.example.willy.projet_ihm_android.fragment_view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.two_column_tiles.ImageAdapter;

/**
 * Created by Tomohiro on 09/04/16.
 */
public class DessertFragment extends PaneFragment {

    GridView dessertView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return getDessertView(inflater, container, savedInstanceState);
    }

    /*************
     *  DESSERT  *
     *************/
    public View getDessertView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        dessertView = (GridView) view.findViewById(R.id.gridview);
        dessertView.setAdapter(new ImageAdapter(getActivity()));

        dessertView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        return dessertView;
    }
}
