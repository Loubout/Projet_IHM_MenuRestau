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
import com.origamilabs.library.views.StaggeredGridView;

/**
 * Created by Tomohiro on 09/04/16.
 */
public class AperitifFragment extends PaneFragment {

    StaggeredGridView aperitifView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("Aperitif View");
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        aperitifView = (StaggeredGridView) view.findViewById(R.id.gridview);
        aperitifView.setAdapter(ImageAdapter.getAperitifImageAdapter(getActivity()));

        aperitifView.setOnItemClickListener(new StaggeredGridView.OnItemClickListener() {
            public void onItemClick(StaggeredGridView parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        System.out.println("endActivity");
        return aperitifView;
    }
}
