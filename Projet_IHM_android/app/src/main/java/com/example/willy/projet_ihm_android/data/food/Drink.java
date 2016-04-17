package com.example.willy.projet_ihm_android.data.food;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class Drink extends ProductAbstract {

    public Drink(String name, String description, int price) {
        super(name, description, price);
    }

    public static final Creator<Drink> CREATOR = new Creator<Drink>() {
        public Drink createFromParcel(Parcel in) {
            return new Drink(in);
        }

        public Drink[] newArray(int size) {
            return new Drink[size];
        }
    };

    public Drink(Parcel in) {
        super(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(CLASS_TYPE_DRINK);
        super.writeToParcel(dest, flags);
    }

}
