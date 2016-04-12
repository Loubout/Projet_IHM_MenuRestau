package com.example.willy.projet_ihm_android.fragment_view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.willy.projet_ihm_android.MainActivity;
import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.two_column_tiles.ImageAdapter;
import com.origamilabs.library.views.StaggeredGridView;

/**
 * Created by Tomohiro on 11/04/16.
 */
public class MenuFragment extends PaneFragment {

    MainActivity act;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        gridView = (StaggeredGridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(ImageAdapter.getMenuImageAdapter(getActivity()));

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
