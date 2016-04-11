package com.example.willy.projet_ihm_android.fragment_view;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.MainActivity;
import com.example.willy.projet_ihm_android.fragment_view.fragment_data.ViewSelector;
import com.example.willy.projet_ihm_android.two_column_tiles.ImageAdapter;
import com.origamilabs.library.views.StaggeredGridView;

/**
 * Created by Tomohiro on 09/04/16.
 */
public class PaneFragment extends Fragment {
    MainActivity act ;
    private int cpt=0;
    protected StaggeredGridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        gridView.setOnItemClickListener(new StaggeredGridView.OnItemClickListener() {
            public void onItemClick(StaggeredGridView parento, View vo, int positiono, long id) {

                final StaggeredGridView parent = parento;
                final int position = positiono;
                cpt++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        if (cpt == 1) {
                            cpt = 0;
                            ImageAdapter.Item item = ((ImageAdapter.Item) (parent.getAdapter().getItem(position)));
                            Drawable i = ContextCompat.getDrawable(getActivity().getApplicationContext(), item.drawableId);
                            String n = getActivity().getString(item.nameId);
                            String d = getActivity().getString(item.descId);
                            String p = getActivity().getString(item.priceId);

                            act = (MainActivity) getActivity();
                            act.afficheDesc(n, d, p, i);
                        }
                    }
                };

                if (cpt == 1) { //Simple clic
                    handler.postDelayed(r, 300);
                } else if (cpt == 2) { //Double clic
                    cpt = 0;
                }
            }
        });
        return gridView;
    }
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