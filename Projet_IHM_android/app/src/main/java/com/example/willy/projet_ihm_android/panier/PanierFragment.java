package com.example.willy.projet_ihm_android.panier;


import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.MainActivity;
import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.data.food.Dessert;
import com.example.willy.projet_ihm_android.data.food.Drink;
import com.example.willy.projet_ihm_android.data.food.ItemAbstract;
import com.example.willy.projet_ihm_android.data.food.Menu;
import com.example.willy.projet_ihm_android.data.food.Plat;
import com.example.willy.projet_ihm_android.data.food.ProductAbstract;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Masa on 2016/03/19.
 */
public class PanierFragment extends Fragment implements AdapterView.OnItemClickListener{

    ListView mListView;
    MyAdapter adapter;

    //liste des noms des items double tap ou element du panier
    ArrayList<ElemPanier> monpanier;

    int total;
    TextView tot;
    HashMap<Integer,ElemPanier>data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.panier, container, false);

        //On rempli monpanier
        monpanier = ((MainActivity) getActivity()).panier;

        //prix total de la commande
        total = 0;

        //creation de la liste view
        mListView = (ListView) view.findViewById(R.id.commandeList);

        //Remplissage de data pour affichage de la liste view
        data = new HashMap<Integer, ElemPanier>();
        for(int i = 0; i < monpanier.size(); i++) {
            ElemPanier tpanier = new ElemPanier(monpanier.get(i).getNomElem(), monpanier.get(i).getQuantites(), monpanier.get(i).getprix());
            total = total + monpanier.get(i).getprix();
            data.put(i, tpanier);
        }

        // Creation de l'adapter de la listView
        adapter = new MyAdapter(data);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);

        //On gere les boutons de panier ici

        //Bouton valider avec dialogBox
        Button bvalider = (Button) view.findViewById(R.id.buttonValiderCommande);
        bvalider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity().findViewById(android.R.id.content).getContext());
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
                                monpanier.clear();
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


        //bouton Vider panier avec dialogBox
        Button bclear = (Button) view.findViewById(R.id.clean);
        bclear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity().findViewById(android.R.id.content).getContext());
                builder.setMessage("Etes vous sur de supprimer toutes les commandes?")
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
                                monpanier.clear();


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

        //affichage de total
        tot = (TextView) view.findViewById(R.id.totalprix);
        tot.setText(((Integer) total).toString());
        getActivity().findViewById(android.R.id.content).invalidate();



        return view;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item" + position, Toast.LENGTH_LONG).show();
    }

    //Adapter pour ListView
    public class MyAdapter extends BaseAdapter {
        LayoutInflater inflater;
        HashMap<Integer, ElemPanier> data;

        public MyAdapter(HashMap<Integer, ElemPanier> data) {
            inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

            if (data.get(position) != null) {
                final Integer nb = data.get(position).getQuantites();
                final Integer pr = data.get(position).getprix();

                //On gere les boutons de recap ici

                //bouton retirer
                ImageButton button = (ImageButton) v.findViewById(R.id.retirer);
                button.setTag(position);
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        if (nb.intValue() == 1) {
                            int nnb = 0;
                            int npr = 0;

                            total = total - pr.intValue();
                            tot.setText(((Integer) total).toString());

                            for(int i=0;i<monpanier.size();i++){
                                if((monpanier.get(i).getNomElem()==data.get(position).getNomElem())){
                                    monpanier.remove(i);
                                    i=monpanier.size();
                                }
                            }

                            HashMap<Integer,ElemPanier>tmp=new HashMap<Integer, ElemPanier>(data);
                            data.remove(position);
                            notifyDataSetChanged();

                            //on decale de 1 tous les elements de data
                            if(!data.isEmpty()) {
                                int k = 0;
                                for (int i = 0; i <tmp.size(); i++) {
                                    if (position != i) {
                                        data.put(k, tmp.get(i));
                                        k++;
                                    }
                                }
                                if(position!=data.size()) {
                                    data.remove(data.size()-1);
                                    notifyDataSetChanged();
                                }
                            }

                            notifyDataSetChanged();
                        } else {
                            int nnb = nb.intValue() - 1;
                            int npr = (pr.intValue() / (nnb + 1)) * nnb;
                            ElemPanier nelt = new ElemPanier(data.get(position).getNomElem(), nnb, npr);
                            data.put(position, nelt);
                            monpanier.get(position).setQuantite(nnb);
                            monpanier.get(position).setPrix(npr);
                            total = total - (pr.intValue() / (nnb + 1));
                            tot.setText(((Integer) total).toString());
                            notifyDataSetChanged();

                        }

                    }

                });

                //bouton ajouter
                ImageButton buttonadd = (ImageButton) v.findViewById(R.id.addItem);
                buttonadd.setTag(position);
                buttonadd.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        int nb = data.get(position).getQuantites() + 1;
                        int pr =(data.get(position).getprix()/(nb-1))*nb;
                        ElemPanier nelt = new ElemPanier(data.get(position).getNomElem(), nb, pr);
                        data.put(position,nelt);
                        monpanier.get(position).setPrix(pr);
                        monpanier.get(position).setQuantite(nb);
                        total = total +(data.get(position).getprix()/nb);
                        tot.setText(((Integer) total).toString());
                        notifyDataSetChanged();
                    }

                });

                Integer nnb = data.get(position).getQuantites();
                Integer npr = data.get(position).getprix();
                ItemCase.setText(data.get(position).getNomElem());
                quantiteCase.setText(nnb.toString());
                priceCase.setText(npr.toString());

            } else {

            }

            return v;
        }
    }
}