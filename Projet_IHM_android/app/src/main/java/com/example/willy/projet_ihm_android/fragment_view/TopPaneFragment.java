package com.example.willy.projet_ihm_android.fragment_view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.willy.projet_ihm_android.R;

/**
 * Created by Tomohiro on 07/04/16.
 */
public class TopPaneFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_pane_fragment, container, false);
        return view;
    }

}
