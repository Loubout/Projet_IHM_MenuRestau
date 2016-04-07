package com.example.willy.projet_ihm_android.fragment_view;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.willy.projet_ihm_android.R;


/**
 * Created by Tomohiro on 22/03/16.
 */
public class LeftPaneFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_pane_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final String[] items = getResources().getStringArray(R.array.menuItems);
        final ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
                R.layout.menu_item_layout, R.id.menuItem, items);

        setListAdapter(aa);
    }

}