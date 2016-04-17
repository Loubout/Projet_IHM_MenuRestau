package com.example.willy.projet_ihm_android.data.food;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by tanguinoche on 07/04/2016.
 */
public class Entree extends ProductAbstract {

    public Entree(String name, String description, int price) {
        super(name, description, price);
    }



    public static final Creator<Entree> CREATOR = new Creator<Entree>() {
        public Entree createFromParcel(Parcel in) {
            return new Entree(in);
        }

        public Entree[] newArray(int size) {
            return new Entree[size];
        }
    };

    public Entree(Parcel in) {
        super(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(CLASS_TYPE_ENTREE);
        super.writeToParcel(dest, flags);
    }
}
