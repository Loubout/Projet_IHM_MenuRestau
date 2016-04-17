package com.example.willy.projet_ihm_android.data.food;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class Dessert extends ProductAbstract {

    public Dessert(String name, String description, int price) {
        super(name, description, price);
    }


    public static final Creator<Dessert> CREATOR = new Creator<Dessert>() {
        public Dessert createFromParcel(Parcel in) {
            return new Dessert(in);
        }

        public Dessert[] newArray(int size) {
            return new Dessert[size];
        }
    };

    public Dessert(Parcel in) {
        super(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(CLASS_TYPE_DESSERT);
        super.writeToParcel(dest, flags);
    }


}
