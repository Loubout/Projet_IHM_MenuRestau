package com.example.willy.projet_ihm_android.fragment_view;

import android.app.Fragment;

import com.example.willy.projet_ihm_android.fragment_view.fragment_data.ViewSelector;

/**
 * Created by Tomohiro on 09/04/16.
 */
public class PaneFragment extends Fragment {

    ViewSelector viewSelector = ViewSelector.CARROUSSEL;

    public void DoubleTap(){

    }


    public void updateTextField(String data){
    /*
        if(data.equals("Apéritif")){
            viewSelector = ViewSelector.APERITIF;
        }
        else if(data.equals("Entrée")){
            viewSelector = ViewSelector.ENTREE;
        }
        else if(data.equals("Plat")){
            viewSelector = ViewSelector.PLAT;
        }
        else if(data.equals("Dessert")){
            viewSelector = ViewSelector.DESSERT;
        }
        else if(data.equals("Boisson")){
            viewSelector = ViewSelector.BOISSON;
        }

        Fragment currentFragment = getActivity().getFragmentManager().findFragmentById(R.id.mainPanel);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.detach(currentFragment);
        fragmentTransaction.attach(currentFragment);
        fragmentTransaction.commit();


        TextView textview = (TextView) getActivity().findViewById(R.id.testReceiveMessage);
        textview.setText(data);
*/
    }

}