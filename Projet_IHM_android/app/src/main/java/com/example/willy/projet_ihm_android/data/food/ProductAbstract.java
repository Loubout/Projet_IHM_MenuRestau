package com.example.willy.projet_ihm_android.data.food;

import android.os.Parcel;

/**
 * Created by tanguinoche on 07/04/2016.
 */
public abstract class ProductAbstract extends ItemAbstract {

    protected ProductAbstract(String name, String description, int price) {
        super(name, description, price);
    }

    protected static final int CLASS_TYPE_ENTREE = 1;
    protected static final int CLASS_TYPE_PLAT = 2;
    protected static final int CLASS_TYPE_DESSERT = 3;
    protected static final int CLASS_TYPE_DRINK = 4;

    public static final Creator<ProductAbstract> CREATOR = new Creator<ProductAbstract>() {
        @Override
        public ProductAbstract createFromParcel(Parcel source) {
            return ProductAbstract.getConcreteClass(source);
        }

        @Override
        public ProductAbstract[] newArray(int size) {
            return new ProductAbstract[size];
        }
    };

    public static ProductAbstract getConcreteClass(Parcel source) {

        switch (source.readInt()) {
            case CLASS_TYPE_ENTREE:
                return new Entree(source);
            case CLASS_TYPE_PLAT:
                return new Plat(source);
            case CLASS_TYPE_DESSERT:
                return new Dessert(source);
            case CLASS_TYPE_DRINK:
                return new Drink(source);
            default:
                return null;
        }
    }

    protected ProductAbstract(Parcel in) {
        super(in);
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

    }


}
