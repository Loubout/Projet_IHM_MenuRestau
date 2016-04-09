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
public class BoissonFragment extends PaneFragment {

    GridView boissonView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        boissonView = (GridView) view.findViewById(R.id.gridview);
        boissonView.setAdapter(new ImageAdapter(getActivity()));

        boissonView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        return boissonView;
    }
}
