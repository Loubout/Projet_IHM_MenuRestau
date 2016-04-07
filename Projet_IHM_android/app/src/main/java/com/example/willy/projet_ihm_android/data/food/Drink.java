package com.example.willy.projet_ihm_android.data.food;

import com.example.willy.projet_ihm_android.data.ProductAbstract;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class Drink extends ProductAbstract {

    public Drink(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
