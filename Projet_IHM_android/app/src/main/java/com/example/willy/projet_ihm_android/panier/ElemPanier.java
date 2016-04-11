package com.example.willy.projet_ihm_android.panier;

/**
 * Created by Masa on 2016/03/29.
 */
public class ElemPanier {

    String nomElem;
    int quantite;
    int prix;

    public ElemPanier(String nomE,int q,int p){
        this.quantite=q;
        this.prix=p;
        this.nomElem=nomE;
    }
    public int getQuantites(){
        return quantite;

    }
    public int getprix(){
        return prix;
    }

    public String getNomElem(){
        return nomElem;
    }

}
