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
public class PlatFragment extends PaneFragment {

    GridView platView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        platView = (GridView) view.findViewById(R.id.gridview);
        platView.setAdapter(ImageAdapter.getDishesImageAdapter(getActivity()));

                platView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {
                        Toast.makeText(getActivity(), "" + position,
                                Toast.LENGTH_SHORT).show();
                    }
                });
        return platView;
    }

}
