package com.example.willy.projet_ihm_android.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class Chair implements Parcelable {
    //List<Reservations> reservations; //Une réservation fait un lien entre un client et une chaise.
    //Ce sera statique et non stocké ici. Normalement dans un ebase de données.

    public Chair() {

    }

    protected Chair(Parcel in) {
    }

    public static final Creator<Chair> CREATOR = new Creator<Chair>() {
        @Override
        public Chair createFromParcel(Parcel in) {
            return new Chair(in);
        }

        @Override
        public Chair[] newArray(int size) {
            return new Chair[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
