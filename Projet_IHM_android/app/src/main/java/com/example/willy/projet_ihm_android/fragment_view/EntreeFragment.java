package com.example.willy.projet_ihm_android.fragment_view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.two_column_tiles.ImageAdapter;
import com.origamilabs.library.views.StaggeredGridView;

/**
 * Created by Tomohiro on 09/04/16.
 */
public class EntreeFragment extends PaneFragment {

    StaggeredGridView entreeView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        entreeView = (StaggeredGridView) view.findViewById(R.id.gridview);
        entreeView.setAdapter(ImageAdapter.getEntreeImageAdapter(getActivity()));


       entreeView.setOnItemClickListener(new StaggeredGridView.OnItemClickListener() {
           public void onItemClick(StaggeredGridView parent, View v,
                                   int position, long id) {
               Toast.makeText(getActivity(), "" + position,
                       Toast.LENGTH_SHORT).show();
           }
       });
        return entreeView;
    }

}
