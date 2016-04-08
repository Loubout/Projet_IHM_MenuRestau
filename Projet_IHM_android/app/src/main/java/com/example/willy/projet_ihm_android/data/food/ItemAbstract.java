package com.example.willy.projet_ihm_android.data.food;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tanguinoche on 07/04/2016.
 */
public abstract class ItemAbstract implements Parcelable {
    protected String name;
    protected String description;
    protected int price;

    protected ItemAbstract(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

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


    protected ItemAbstract(Parcel in) {
        name = in.readString();
        description = in.readString();
        price = in.readInt();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(price);

    }
}
