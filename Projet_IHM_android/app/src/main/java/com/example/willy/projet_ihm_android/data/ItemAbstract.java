package com.example.willy.projet_ihm_android.data.food;

/**
 * Created by Willy on 07/04/2016.
 */
public abstract class ItemAbstract {
    String name;
    String description;
    int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
