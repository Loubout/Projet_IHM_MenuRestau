package com.example.willy.projet_ihm_android.data.food;

import com.example.willy.projet_ihm_android.data.ProductAbstract;

/**
 * Created by Willy on 07/04/2016.
 */
public class Entree extends ProductAbstract {

    public Entree(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
