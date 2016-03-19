package com.example.willy.projet_ihm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Willy on 15/03/2016.
 */
public class TableSetting extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_setting);


}


/*
    public void numpad(View v) {
        Button b = (Button) v;
        if (!(b.getText().toString().equals("del"))) {
            stringTable += b.getText().toString();

        } else {
            if (!stringTable.equals("")) {
                stringTable = stringTable.substring(0, stringTable.length() - 1);
            }
        }
        numTable.setText(stringTable);
    }
    */
}