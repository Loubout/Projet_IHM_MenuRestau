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
import com.example.willy.projet_ihm_android.panier.PanierFragment;

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
        if(view.getId() == getActivity().findViewById(R.id.panier).getId()){
            FragmentManager fragmentManager = getActivity().getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.mainPanel, new PanierFragment());
            transaction.addToBackStack(null);
            transaction.commit();
            Toast.makeText(getActivity(), "PanierClick ", Toast.LENGTH_SHORT).show();
        }
        else if(view.getId() == getActivity().findViewById(R.id.logoPanel).getId()) {
            FragmentManager fragmentManager = getActivity().getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.mainPanel, new CarrousselFragment());
            transaction.addToBackStack(null);
            transaction.commit();

            Toast.makeText(getActivity(), "LogoClick ", Toast.LENGTH_SHORT).show();
        }
    }


}
