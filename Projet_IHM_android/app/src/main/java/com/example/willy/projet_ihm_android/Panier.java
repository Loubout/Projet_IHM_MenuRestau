package com.example.willy.projet_ihm_android;


import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.data.food.Drink;
import com.example.willy.projet_ihm_android.data.food.ItemAbstract;
import com.example.willy.projet_ihm_android.data.food.Menu;
import com.example.willy.projet_ihm_android.data.food.Plat;
import com.example.willy.projet_ihm_android.data.food.Dessert;
import com.example.willy.projet_ihm_android.data.food.ProductAbstract;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Masa on 2016/03/19.
 */
public class Panier extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView mListView;
    //liste des noms des items double tap ou element du panier
    ArrayList<ItemAbstract> monpanier=new ArrayList<ItemAbstract>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panier);
        //on gere l'affichage




        Plat p=new Plat("salade","blabla",10);
        Plat p2=new Plat("steak","blabla",12);
        Dessert d= new Dessert("ice cream","blabla",7);
        Drink b = new Drink("the","blabla",3);
        Drink b1 = new Drink("eau","blabla",1);

        ArrayList<ProductAbstract> mp =new ArrayList<ProductAbstract>();
        mp.add(b);
        mp.add(d);
        mp.add(p);

        Menu m=new Menu("Menu A","entree plat dessert",16,mp);


        monpanier.add(m);
        monpanier.add(m);
        monpanier.add(d);
        monpanier.add(b);
        monpanier.add(b);
        monpanier.add(d);
        monpanier.add(b1);
        monpanier.add(d);
        monpanier.add(p);
        monpanier.add(p2);




        //liste des elements qui vont etre affiche ligne par ligne.
        HashMap<String, Integer> quantite = new HashMap<String, Integer>();
        HashMap<String, Integer> prix = new HashMap<String, Integer>();
        ArrayList<String> nom = new ArrayList<String>();
        double total = 0.0;

        mListView = (ListView) findViewById(R.id.listView1);


        if (!monpanier.isEmpty()) {
            for (int i = 0; i < monpanier.size(); i++) {
                String itemName = monpanier.get(i).getName();
                int itemprix = monpanier.get(i).getPrice();


                if (nom.contains(itemName)) {

                    int currentq = quantite.get(itemName)+1;

                    quantite.put(itemName, currentq);
                    prix.put(itemName, itemprix * (currentq));

                    System.out.println("Item " + itemName + " Prix " + itemprix + " Quantite "+currentq+" Prix tot "+prix.get(itemName));

                } else {
                    quantite.put(itemName,1);
                    prix.put(itemName, itemprix);
                    nom.add(itemName);
                }
            }


        }
        HashMap<Integer, ElemPanier> data = new HashMap<Integer, ElemPanier>();
        for (int i = 0; i < nom.size(); i++) {
            ElemPanier tpanier = new ElemPanier(nom.get(i), quantite.get(nom.get(i)), prix.get(nom.get(i)));

            data.put(i, tpanier);

        }

        MyAdapter adapter = new MyAdapter(data);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Item" + position, Toast.LENGTH_LONG).show();
    }

    public class MyAdapter extends BaseAdapter {
        LayoutInflater inflater;
        HashMap<Integer, ElemPanier> data;

        public MyAdapter(HashMap<Integer, ElemPanier> data) {
            inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.data = data;

        }


        ;

        @Override
        public int getCount() {
            return data.size();

        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View recycleView, ViewGroup parent) {
            View v = recycleView;
            if (v == null) {
                v = inflater.inflate(R.layout.recap, parent, false);
            }
            Random r = new Random();
            TextView ItemCase = (TextView) v.findViewById(R.id.plat);
            TextView quantiteCase = (TextView) v.findViewById(R.id.quantite);
            TextView priceCase=(TextView) v.findViewById(R.id.prix);

            Integer nb=data.get(position).getQuantites();
            Integer pr= data.get(position).getprix();


            ItemCase.setText(data.get(position).getNomElem());
            quantiteCase.setText(nb.toString());
            priceCase.setText(pr.toString());

            return v;
        }
    }
}