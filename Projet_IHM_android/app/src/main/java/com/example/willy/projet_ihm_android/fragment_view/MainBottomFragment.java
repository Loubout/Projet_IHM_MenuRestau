package com.example.willy.projet_ihm_android.fragment_view;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.willy.projet_ihm_android.R;

import java.util.ArrayList;

/**
 * Created by Tomohiro on 14/04/16.
 */
public class MainBottomFragment extends Fragment {


    private static ArrayList<String> names;
    private static ArrayList<String> descriptions;
    private static ArrayList<String> prix;
    private static ArrayList<Drawable> images;


    public MainBottomFragment() {
        names = new ArrayList<String>();
        descriptions = new ArrayList<String>();
        prix = new ArrayList<String>();
        images = new ArrayList<Drawable>();
    }

    public void addElement(String n, String d, String p, Drawable i) {
        names.add(n);
        descriptions.add(d);
        prix.add(p);
        images.add(i);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        View view = inflater.inflate(R.layout.main_bottom_pane_fragment, container, false);
        return view;
    }

}
