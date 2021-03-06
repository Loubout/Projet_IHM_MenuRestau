package com.example.willy.projet_ihm_android.panier;


import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.data.food.Drink;
import com.example.willy.projet_ihm_android.data.food.ItemAbstract;
import com.example.willy.projet_ihm_android.data.food.Menu;
import com.example.willy.projet_ihm_android.data.food.Plat;
import com.example.willy.projet_ihm_android.data.food.Dessert;
import com.example.willy.projet_ihm_android.data.food.ProductAbstract;

import android.app.*;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Masa on 2016/03/19.
 */
public class Panier extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView mListView;
    MyAdapter adapter;
    //liste des noms des items double tap ou element du panier
    ArrayList<ItemAbstract> monpanier=new ArrayList<ItemAbstract>();
    int total;
    TextView tot;
    HashMap<Integer,ElemPanier>data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panier);

        //initialisation de mon panier (a enlever)

        Plat p=new Plat("salade","blabla",10);
        Plat p2=new Plat("steak","blabla",12);
        Dessert d= new Dessert("ice cream","blabla",7);
        Drink b = new Drink("okonomiyaki miso","blabla",3);
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
        monpanier.add(p2);
        monpanier.add(p2);





        //liste des elements qui vont etre affiche ligne par ligne.

        HashMap<String, Integer> quantite = new HashMap<String, Integer>();
        HashMap<String, Integer> prix = new HashMap<String, Integer>();
        ArrayList<String> nom = new ArrayList<String>();

        //prix total de la commande
        total = 0;

        mListView = (ListView) findViewById(R.id.commandeList);


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
        data = new HashMap<Integer, ElemPanier>();
        for (int i = 0; i < nom.size(); i++) {
            ElemPanier tpanier = new ElemPanier(nom.get(i), quantite.get(nom.get(i)), prix.get(nom.get(i)));
            total=total+prix.get(nom.get(i));

            data.put(i, tpanier);

        }

        //creation de adapter de la listview
        ;
        adapter = new MyAdapter(data);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);



        //On gere les bouttons de panier ici

        Button bvalider = (Button) findViewById(R.id.buttonValiderCommande);
        bvalider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(findViewById(android.R.id.content).getContext());
                builder.setMessage("Valider votre commande?")
                        .setCancelable(false)
                        .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                /*
                                *
                                *
                                * ICI ENVOIE DES DONNEES DATA VERS SERVEUR
                                *
                                * */
                                data.clear();
                                total=0;
                                tot.setText("0");
                                adapter = new MyAdapter(data);
                                mListView.setAdapter(adapter);

                                System.out.println("===================HELLO=====");

                            }
                        })
                        .setNegativeButton("Non", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        Button bclean = (Button) findViewById(R.id.clean);
        bclean.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                data.clear();
                monpanier.clear();

            }
        });

        System.out.println("TOTAL NOW" + total);
        tot = (TextView) findViewById(R.id.totalprix);
        tot.setText(((Integer) total).toString());
        this.findViewById(android.R.id.content).invalidate();


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
        public View getView(final int position, final View recycleView, ViewGroup parent) {
            View v = recycleView;
            if (v == null) {
                v = inflater.inflate(R.layout.recap, parent, false);
            }

            final TextView ItemCase = (TextView) v.findViewById(R.id.plat);
            final TextView quantiteCase = (TextView) v.findViewById(R.id.quantite);
            final TextView priceCase = (TextView) v.findViewById(R.id.prix);


            System.out.print("=================="+data.get(position)+"===================");
            if (data.get(position) != null) {
                final Integer nb = data.get(position).getQuantites();
                final Integer pr = data.get(position).getprix();


                Button button = (Button) v.findViewById(R.id.retirer);
                button.setTag(position);
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        //action de retirer
                        if (nb.intValue() == 1) {

                            System.out.println("La valeur de data : "+position+" est de quantite 1");
                            int nnb = 0;
                            int npr = 0;

                            total = total - pr.intValue();
                            tot.setText(((Integer) total).toString());

                            for(int i=0;i<monpanier.size();i++){
                                if((monpanier.get(i).getName()==data.get(position).getNomElem())){
                                    monpanier.remove(i);
                                    i=monpanier.size();
                                }
                            }

/*
                                    for(int i=0;i<data.size();i++){
                                        System.out.println("//////////////////////////");
                                        System.out.println("//Affichage de data :"+i);
                                        System.out.println("//Nom de l'elem :"+data.get(i).getNomElem());
                                        System.out.println("//prix :"+data.get(i).prix);
                                        System.out.println("//nombre :"+data.get(i).getQuantites());
                                        System.out.println("//Fin affichage");
                                        System.out.println("//////////////////////////////");

                                    }

*/

                            System.out.println("REMOVE "+position);

                            HashMap<Integer,ElemPanier>tmp=new HashMap<Integer, ElemPanier>(data);

                            System.out.println("SIZE BEFORE"+data.size()+"==============");
                            data.remove(position);
                            notifyDataSetChanged();

                            //on decale de 1 tous les elements de data
                            if(!data.isEmpty()) {
                                int k = 0;
                                for (int i = 0; i <tmp.size(); i++) {
                                    System.out.println("POSITION ACTUELLE " + position + " Valeur de i " + i + " VALEUR DE DATASIZE "+tmp.size());
                                    if (position != i) {
                                        data.put(k, tmp.get(i));
                                        System.out.println("PUT" + tmp.get(i).getNomElem() + "============== dans" + k);
                                        k++;
                                    }
                                }
                                if(position!=data.size()) {
                                    data.remove(data.size()-1);
                                    notifyDataSetChanged();
                                }
                            }

                            System.out.println("SIZE AFTER"+data.size()+"==============");

                            for(int i=0;i<data.size();i++){
                                System.out.println("//////////////////////////");
                                System.out.println("//Affichage de data :"+i);
                                System.out.println("//Nom de l'elem :"+data.get(i).getNomElem());
                                System.out.println("//prix :"+data.get(i).prix);
                                System.out.println("//nombre :"+data.get(i).getQuantites());
                                System.out.println("//Fin affichage");
                                System.out.println("//////////////////////////////");

                            }
                            System.out.println("Value1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            notifyDataSetChanged();


                        } else {
                            int nnb = nb.intValue() - 1;
                            int npr = (pr.intValue() / (nnb + 1)) * nnb;
                            ElemPanier nelt = new ElemPanier(data.get(position).getNomElem(), nnb, npr);
                            data.put(position, nelt);
                            total = total - (pr.intValue() / (nnb + 1));
                            tot.setText(((Integer) total).toString());
                            notifyDataSetChanged();
                            System.out.println("ValueLots!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                        }

                    }

                });

                Button buttonadd = (Button) v.findViewById(R.id.addItem);
                buttonadd.setTag(position);
                buttonadd.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        //action de rajouter
/*
                                    for(int i=0;i<data.size();i++){
                                        System.out.println("//////////////////////////");
                                        System.out.println("//Affichage de data :"+i);
                                        System.out.println("//Nom de l'elem :"+data.get(i).getNomElem());
                                        System.out.println("//prix :"+data.get(i).prix);
                                        System.out.println("//nombre :"+data.get(i).getQuantites());
                                        System.out.println("//Fin affichage");
                                        System.out.println("//////////////////////////////");

                                    }*/

                        int nb = data.get(position).getQuantites() + 1;
                        int pr =(data.get(position).getprix()/(nb-1))*nb;
                        ElemPanier nelt = new ElemPanier(data.get(position).getNomElem(), nb, pr);
                        data.put(position,nelt);
                        total = total +(data.get(position).getprix()/nb);
                        tot.setText(((Integer) total).toString());
                        System.out.println("ADD " + position);
                        notifyDataSetChanged();
                    }

                });

                System.out.println("DATA: " + position + " NOM " + data.get(position).getNomElem() + "!!!!!!!!!!!!!!!!!!!!!!?????");
                Integer nnb = data.get(position).getQuantites();
                Integer npr = data.get(position).getprix();
                ItemCase.setText(data.get(position).getNomElem());
                quantiteCase.setText(nnb.toString());
                priceCase.setText(npr.toString());

            }


            return v;
        }
    }
}