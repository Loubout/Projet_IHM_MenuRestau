package com.example.willy.projet_ihm_android.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class Restaurant {

    private List<Table> tables;


    public Restaurant() {
          tables = new ArrayList<>();
    }

    public Table getTable(int numero) {
        for(Table table : tables) {
            if(table.getNumero()==numero)
                return table;
        }
        return null;
    }

    public int getNbTables()
    {
        Log.d("RESTAURANT_MODEL", "requested nbTables : "+tables.size());
        return tables.size();
    }

    public int getNbPlaces()
    {
        int sum=0;
        for(Table t : tables) {
            sum+=t.getNbPlaces();
        }
        return sum;
    }

    public List<Table> getTables()
    {
        return tables;
    }

    public void setTables(List<Table> tables)
    {
        this.tables = tables;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder("Restaurant :\n[\n");
        for(Table t : tables)
            sb.append(t.toString());
        sb.append("]\n");
        return sb.toString();
    }
}
