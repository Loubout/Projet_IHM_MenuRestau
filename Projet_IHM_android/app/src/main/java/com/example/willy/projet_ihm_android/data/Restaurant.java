package com.example.willy.projet_ihm_android.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class Restaurant implements Parcelable {

    List<Table> tables;

    public Restaurant(List<Table> tables) {
        this.tables = tables;

    }


    protected Restaurant(Parcel in) {
        tables = in.createTypedArrayList(Table.CREATOR);
    }

    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
        @Override
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        @Override
        public Restaurant[] newArray(int size) {
            return new Restaurant[size];
        }
    };

    public int getNbTables() {
        return tables.size();
    }

    public int getNbPlaces() {
        int sum=0;
        for(Table t : tables) {
            sum+=t.getNbPlaces();
        }
        return sum;
    }

    public List<Table> getTables() {
        return tables;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(tables);
    }
}
