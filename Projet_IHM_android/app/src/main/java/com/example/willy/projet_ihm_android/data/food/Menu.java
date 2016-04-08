package com.example.willy.projet_ihm_android.data.food;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class Menu extends ItemAbstract {
    public List<ProductAbstract> getProducts() {
        return products;
    }

    public void setProducts(List<ProductAbstract> products) {
        this.products = products;
    }

    private List<ProductAbstract> products;

    public Menu (String name, String description, int price, List<ProductAbstract> products) {
        super(name, description, price);
        this.products = products;
    }

    public static final Parcelable.Creator<Menu> CREATOR = new Parcelable.Creator<Menu>() {
        public Menu createFromParcel(Parcel in) {
            return new Menu(in);
        }

        public Menu[] newArray(int size) {
            return new Menu[size];
        }
    };

    private Menu(Parcel in) {
        super(in);
        in.readTypedList(products, ProductAbstract.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeTypedList(products);
    }
}
