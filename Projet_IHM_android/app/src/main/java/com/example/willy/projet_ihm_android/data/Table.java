package com.example.willy.projet_ihm_android.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.List;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class Table implements Parcelable{
    List<Chair> chairs;
    int numero;

    public int getNumero() {
        Log.d("TABLE_MODEL", "requested numero "+numero);
        return numero;
    }


    public Table (List<Chair> chairs, int numero) {
        Log.d("TABLE_MODEL", "Constructed new table n"+numero);
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

        Log.d("TABLE_MODEL", "requested nbPlaces of table "+numero+" : "+chairs.size());
        return chairs.size();
    }

    public void setNumero(int n) {
        Log.d("TABLE_MODEL", "set numero of table "+numero+" : "+n);
        this.numero = n;
    }

    public List<Chair> getChairs() {

        Log.d("TABLE_MODEL", "requested chairs of table "+numero);
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

    public String toString() {
        StringBuilder sb = new StringBuilder("---Table n");
        sb.append(numero);
        sb.append("\n---[\n");
        for(Chair c : chairs)
            sb.append(c.toString());
        sb.append("---]\n");
        return sb.toString();
    }
}
