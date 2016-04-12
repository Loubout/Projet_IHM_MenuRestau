package com.example.willy.projet_ihm_android;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.fragment_view.AperitifFragment;
import com.example.willy.projet_ihm_android.fragment_view.BoissonFragment;
import com.example.willy.projet_ihm_android.fragment_view.CarrousselFragment;
import com.example.willy.projet_ihm_android.fragment_view.DescriptionFoodFragment;
import com.example.willy.projet_ihm_android.fragment_view.DessertFragment;
import com.example.willy.projet_ihm_android.fragment_view.EntreeFragment;
import com.example.willy.projet_ihm_android.fragment_view.LeftPaneFragment;
import com.example.willy.projet_ihm_android.fragment_view.MenuFragment;
import com.example.willy.projet_ihm_android.fragment_view.PaneFragment;
import com.example.willy.projet_ihm_android.fragment_view.PlatFragment;
import com.example.willy.projet_ihm_android.panier.ElemPanier;
import com.example.willy.projet_ihm_android.panier.PanierFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LeftPaneFragment.OnArticleSelectedListener {

    FragmentManager manager;
    FragmentTransaction transaction;

    PaneFragment currentMainFragment;
    String lastPick;
    String currentPick;

    public ArrayList<ElemPanier> panier;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("", "MainActivity started");


        panier = new ArrayList<ElemPanier>();

        LeftPaneFragment leftMenuFragment = new LeftPaneFragment();
        CarrousselFragment carrousselFragment = new CarrousselFragment();

        Toolbar mToolBar = (Toolbar) findViewById(R.id.topPaneToolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView toolbartitle = (TextView) findViewById(R.id.titleActionBar);
        toolbartitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.mainPanel, new CarrousselFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                Toast.makeText(MainActivity.this, "Title toolBar clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView logoIcon = (ImageView) findViewById(R.id.logoIcon);
        logoIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.mainPanel, new CarrousselFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                Toast.makeText(MainActivity.this, "logoIcon click", Toast.LENGTH_SHORT).show();
            }
        });

        currentMainFragment = carrousselFragment;

        manager = getFragmentManager();

        transaction = manager.beginTransaction();

        transaction.add(R.id.leftSidePanel, leftMenuFragment, "leftMenuFragment");
        transaction.add(R.id.mainPanel, carrousselFragment, "mainFragment");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_pane_toolbar, menu);
        //final int titleId = getResources().getIdentifier("logo_icon", "drawable", MainActivity.this.getPackageName());

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fragmentManager;
        switch (item.getItemId()) {
            case R.id.action_panier:
                // User chose the "Settings" item, show the app settings UI...
                fragmentManager = getFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.mainPanel, new PanierFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                Toast.makeText(MainActivity.this, "PanierClick ", Toast.LENGTH_SHORT).show();
                return true;



            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onArticleSelected(String data){
        //PaneFragment previousPanel = currentMainFragment;

        System.out.println("onArticleSelected");

        transaction = manager.beginTransaction();
        lastPick = data;
        currentPick=data;
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
        else if(data.equals("Menu")){
            currentMainFragment = new MenuFragment();
            transaction.replace(R.id.mainPanel, currentMainFragment);
        }
        transaction.addToBackStack(null);
        transaction.commit();
       // currentMainFragment.updateTextField(data);
    }

    public PaneFragment getCurrentFragment(){
        return this.currentMainFragment;
    }

    public void afficheDesc(String n, String d, String p, Drawable i){
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(  currentMainFragment.getId(), new DescriptionFoodFragment(n,d,p,i));
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {


            getFragmentManager().popBackStack();

            if (!currentPick.equals(lastPick)){
                
            }


        }
    }

}