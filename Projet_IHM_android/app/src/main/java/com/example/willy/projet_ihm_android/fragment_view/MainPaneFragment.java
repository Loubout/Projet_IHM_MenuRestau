package com.example.willy.projet_ihm_android.fragment_view;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.carroussel_view.CarouselView;
import com.example.willy.projet_ihm_android.carroussel_view.ImageListener;
import com.example.willy.projet_ihm_android.fragment_view.fragment_data.ViewSelector;
import com.example.willy.projet_ihm_android.two_column_tiles.ImageAdapter;

/**
 * Created by Tomohiro on 22/03/16.
 */
public class MainPaneFragment extends Fragment implements AdapterView.OnClickListener {

    ViewSelector viewSelector = ViewSelector.CARROUSSEL;

    CarouselView carouselView;
    GridView aperitifView;
    GridView entreeView;
    GridView platView;
    GridView dessertView;
    GridView boissonView;


    int[] sampleImages = {R.drawable.food_accompagnement_item1, R.drawable.food_accompagnement_item2, R.drawable.food_accompagnement_item3, R.drawable.food_dessert_item4, R.drawable.food_dessert_item5};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(viewSelector == ViewSelector.CARROUSSEL)
            return getCarrousselView(inflater, container, savedInstanceState);
        else if(viewSelector == ViewSelector.APERITIF)
            return getAperitifView(inflater, container, savedInstanceState);
        else if(viewSelector == ViewSelector.ENTREE)
            return getEntreeView(inflater, container, savedInstanceState);
        else if(viewSelector == ViewSelector.PLAT)
            return getPlatView(inflater, container, savedInstanceState);
        else if(viewSelector == ViewSelector.DESSERT)
            return getDessertView(inflater, container, savedInstanceState);
        else if(viewSelector == ViewSelector.BOISSON)
            return getBoissonView(inflater, container, savedInstanceState);
        else
            return getCarrousselView(inflater, container, savedInstanceState);
    }

    /****************
     *  CARROUSSEL  *
     ****************/
    public View getCarrousselView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_sample_carousel_view, container, false);

        carouselView = (CarouselView)view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        return view;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


    /**************
     *  APERITIF  *
     **************/
    public View getAperitifView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        aperitifView = (GridView) view.findViewById(R.id.gridview);
        aperitifView.setAdapter(new ImageAdapter(getActivity()));

        aperitifView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        return aperitifView;
    }


    /************
     *  ENTREE  *
     ************/
    public View getEntreeView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        entreeView = (GridView) view.findViewById(R.id.gridview);
        entreeView.setAdapter(new ImageAdapter(getActivity()));

        entreeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        return entreeView;
    }


    /**********
     *  PLAT  *
     **********/
    public View getPlatView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        platView = (GridView) view.findViewById(R.id.gridview);
        platView.setAdapter(new ImageAdapter(getActivity()));

        platView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        return platView;
    }


    /*************
     *  DESSERT  *
     *************/
    public View getDessertView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        dessertView = (GridView) view.findViewById(R.id.gridview);
        dessertView.setAdapter(new ImageAdapter(getActivity()));

        dessertView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        return dessertView;
    }


    /*************
     *  BOISSON  *
     *************/
    public View getBoissonView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.two_column_tiles, container, false);
        boissonView = (GridView) view.findViewById(R.id.gridview);
        boissonView.setAdapter(new ImageAdapter(getActivity()));

        boissonView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(getActivity(), "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        return boissonView;
    }


    @Override
    public void onClick(View view) {
        //Ici, la position récupérée est celle fournie par la méthode getItem de notre classe MyAdapter
        Toast.makeText(getActivity(), "MainPaneClick ", Toast.LENGTH_SHORT).show();
    }

    public void updateTextField(String data){
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

    }
}