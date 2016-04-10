package com.example.willy.projet_ihm_android.interactive_map.restaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.data.Chair;
import com.example.willy.projet_ihm_android.data.DataController;
import com.example.willy.projet_ihm_android.data.Restaurant;
import com.example.willy.projet_ihm_android.data.Table;
import com.example.willy.projet_ihm_android.interactive_map.table.TableActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class RestaurantActivity extends Activity implements View.OnClickListener {

    Restaurant restaurant;
    List<TableImageView> tableViews;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        restaurant = DataController.getInstance().getRestaurant();
        List<Table> tables = restaurant.getTables();

        tableViews = new ArrayList<>();
        if(restaurant.getNbTables() == 9) {
            setContentView(R.layout.interactive_map_restaurant);
            TableImageView t = (TableImageView)findViewById(R.id.table1);
            t.setTable(restaurant.getTables().get(0));
            tableViews.add(t);
            t = (TableImageView)findViewById(R.id.table2);
            t.setTable(restaurant.getTables().get(1));
            tableViews.add(t);
            t = (TableImageView)findViewById(R.id.table3);
            t.setTable(restaurant.getTables().get(2));
            tableViews.add(t);
            t = (TableImageView)findViewById(R.id.table4);
            t.setTable(restaurant.getTables().get(3));
            tableViews.add(t);
            t = (TableImageView)findViewById(R.id.table5);
            t.setTable(restaurant.getTables().get(4));
            tableViews.add(t);
            t = (TableImageView)findViewById(R.id.table6);
            t.setTable(restaurant.getTables().get(5));
            tableViews.add(t);
            t = (TableImageView)findViewById(R.id.table7);
            t.setTable(restaurant.getTables().get(6));
            tableViews.add(t);
            t = (TableImageView)findViewById(R.id.table8);
            t.setTable(restaurant.getTables().get(7));
            tableViews.add(t);
            t = (TableImageView)findViewById(R.id.table9);
            t.setTable(restaurant.getTables().get(8));
            tableViews.add(t);
        }

        for(TableImageView t : tableViews) {
            t.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View tableView) {
        Table table = ((TableImageView) tableView).getTable();
        Intent descrGroupActivity = new Intent(RestaurantActivity.this, TableActivity.class);
        descrGroupActivity.putExtra("num_table", table.getNumero());
        startActivity(descrGroupActivity);
    }
}
