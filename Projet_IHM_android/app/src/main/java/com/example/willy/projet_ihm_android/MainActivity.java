package com.example.willy.projet_ihm_android;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.example.willy.projet_ihm_android.fragment_view.AperitifFragment;
import com.example.willy.projet_ihm_android.fragment_view.BoissonFragment;
import com.example.willy.projet_ihm_android.fragment_view.CarrousselFragment;
import com.example.willy.projet_ihm_android.fragment_view.DescriptionFoodFragment;
import com.example.willy.projet_ihm_android.fragment_view.DessertFragment;
import com.example.willy.projet_ihm_android.fragment_view.EntreeFragment;
import com.example.willy.projet_ihm_android.fragment_view.LeftPaneFragment;
import com.example.willy.projet_ihm_android.fragment_view.PaneFragment;
import com.example.willy.projet_ihm_android.fragment_view.PlatFragment;
import com.example.willy.projet_ihm_android.fragment_view.TopPaneFragment;

public class MainActivity extends Activity implements LeftPaneFragment.OnArticleSelectedListener {

    FragmentManager manager;
    FragmentTransaction transaction;

    PaneFragment currentMainFragment;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("", "MainActivity started");

        TopPaneFragment topPaneFragment = new TopPaneFragment();
        LeftPaneFragment leftMenuFragment = new LeftPaneFragment();
        CarrousselFragment carrousselFragment = new CarrousselFragment();

        currentMainFragment = carrousselFragment;

        manager = getFragmentManager();

        transaction = manager.beginTransaction();

        transaction.add(R.id.logoPanel, topPaneFragment, "topPaneFragment");
        transaction.add(R.id.leftSidePanel, leftMenuFragment, "leftMenuFragment");
        transaction.add(R.id.mainPanel, carrousselFragment, "mainFragment");

    }

    @Override
    public void onArticleSelected(String data){
        //PaneFragment previousPanel = currentMainFragment;

        System.out.println("onArticleSelected");

        transaction = manager.beginTransaction();

        if(data.equals("Apéritif")){
            currentMainFragment = new AperitifFragment();
            transaction.replace(R.id.mainPanel, currentMainFragment);
        }
        else if(data.equals("Entrée")){
            currentMainFragment = new EntreeFragment();
            transaction.replace(R.id.mainPanel, currentMainFragment);
        }
        else if(data.equals("Plat")){
            currentMainFragment = new PlatFragment();
            transaction.replace(R.id.mainPanel, currentMainFragment);
        }
        else if(data.equals("Dessert")){
            currentMainFragment = new DessertFragment();
            transaction.replace(R.id.mainPanel, currentMainFragment);
        }
        else if(data.equals("Boisson")){
            currentMainFragment = new BoissonFragment();
            transaction.replace(R.id.mainPanel, currentMainFragment);
        }
        transaction.addToBackStack(null);
        transaction.commit();
       // currentMainFragment.updateTextField(data);
    }

    public PaneFragment getCurrentFragment(){
        return this.currentMainFragment;
    }

    public void afficheDesc(String n, String d, String p,Drawable i){
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(  currentMainFragment.getId(), new DescriptionFoodFragment(n,d,p,i));
        transaction.addToBackStack(null);
        transaction.commit();
    }


}