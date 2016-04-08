package com.example.willy.projet_ihm_android.data.food;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class Plat extends ProductAbstract {

    public Plat(String name, String description, int price) {
        super(name, description, price);
    }

    public static final Parcelable.Creator<Plat> CREATOR = new Parcelable.Creator<Plat>() {
        public Plat createFromParcel(Parcel in) {
            return new Plat(in);
        }

        public Plat[] newArray(int size) {
            return new Plat[size];
        }
    };

    public Plat(Parcel in) {
        super(in);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(CLASS_TYPE_PLAT);
        super.writeToParcel(dest, flags);
    }
}
