package com.example.willy.projet_ihm_android.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class Chair implements Parcelable {
    //List<Reservations> reservations; //Une réservation fait un lien entre un client et une chaise.
    //Ce sera statique et non stocké ici. Normalement dans un ebase de données.
    int color;
    private static int cpt = 0;
    private final int id;

    public Chair() {
        this.color=0;
        id = ++cpt;
    }

    protected Chair(Parcel in) {
        color = in.readInt();
        cpt = in.readInt();
        id = in.readInt();
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
        dest.writeInt(color);
        dest.writeInt(cpt);
        dest.writeInt(id);
    }
    public int getColor() {
        Log.d("CHAIR_MODEL", "requested chair color : "+color);
        return color;
    }
    public void setColor(int color) {
        Log.d("CHAIR_MODEL", "set chair color : "+color);
        this.color=color;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("--- ---Chair [");
        sb.append("groupe").append(color);
        sb.append("]\n");
        return sb.toString();
    }
}
