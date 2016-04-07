package com.example.willy.projet_ihm_android.interactive_map.restaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.R;
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
        Log.d("AAA", "Activity interactive map restaurant started");

        Bundle b = getIntent().getExtras();
        restaurant = (Restaurant)b.getParcelable("restaurant");

        //Il reçoit restaurant via son start_activity
        List<Table> tables = restaurant.getTables();

        //Ici, on représente le restaurant qui compte 1 table, on lance le layout associé, et on récupère ImageView des tables sur le layout
        tableViews = new ArrayList<>();
        if(restaurant.getNbTables() == 1) {
            setContentView(R.layout.interactive_map_restaurant);
            TableImageView t = (TableImageView)findViewById(R.id.imageView);
            t.setTable(restaurant.getTables().get(0)); //On associe la table, à l'image.
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
        descrGroupActivity.putExtra("table", table);
        startActivity(descrGroupActivity);
    }
}
