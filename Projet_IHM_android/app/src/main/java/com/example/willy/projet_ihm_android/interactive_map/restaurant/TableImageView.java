package com.example.willy.projet_ihm_android.interactive_map.restaurant;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.willy.projet_ihm_android.data.Table;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class TableImageView extends ImageView {
    private Table table;

    public TableImageView(Context context) {
        super(context);
    }

    public TableImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TableImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Table getTable() {
        return table;
    }
}
