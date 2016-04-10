package com.example.willy.projet_ihm_android.fragment_view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.R;

/**
 * Created by Tomohiro on 07/04/16.
 */
public class TopPaneFragment extends Fragment implements AdapterView.OnClickListener {

    ImageView logo;
    TextView panier;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_pane_fragment, container, false);

        logo = (ImageView) view.findViewById(R.id.logoPanel);
        logo.setOnClickListener(this);

        panier = (TextView) view.findViewById(R.id.panier);
        panier.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        //Ici, la position récupérée est celle fournie par la méthode getItem de notre classe MyAdapter

        FragmentManager fragmentManager = getActivity().getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mainPanel, new CarrousselFragment());
        transaction.addToBackStack(null);
        transaction.commit();

        Toast.makeText(getActivity(), "TopPaneClick ", Toast.LENGTH_SHORT).show();
    }


}
