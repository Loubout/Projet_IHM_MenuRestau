package com.example.willy.projet_ihm_android.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class Table implements Parcelable{
    List<Chair> chairs;
    int numero;

    public int getNumero() {
        return numero;
    }


    public Table (List<Chair> chairs, int numero) {
        this.chairs = chairs;
        this.numero = numero;
    }


    protected Table(Parcel in) {
        chairs = in.createTypedArrayList(Chair.CREATOR);
        numero = in.readInt();
    }

    public static final Creator<Table> CREATOR = new Creator<Table>() {
        @Override
        public Table createFromParcel(Parcel in) {
            return new Table(in);
        }

        @Override
        public Table[] newArray(int size) {
            return new Table[size];
        }
    };

    public int getNbPlaces() {
        return chairs.size();
    }

    public List<Chair> getChairs() {
        return chairs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(chairs);
        dest.writeInt(numero);
    }
}
