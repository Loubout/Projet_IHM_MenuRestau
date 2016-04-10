package com.example.willy.projet_ihm_android.interactive_map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.data.Chair;
import com.example.willy.projet_ihm_android.data.DataController;
import com.example.willy.projet_ihm_android.data.Restaurant;
import com.example.willy.projet_ihm_android.data.Table;
import com.example.willy.projet_ihm_android.interactive_map.restaurant.RestaurantActivity;
import com.example.willy.projet_ihm_android.listing.ClientsActivity;

import java.util.ArrayList;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class StartActivity extends Activity implements View.OnClickListener {

    Button buttonMap, buttonClients, buttonCommands;
    Restaurant restaurant;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("AAA", "Activity interactive map restaurant started");

        setContentView(R.layout.start_activity);

        //TABLE 1
        ArrayList<Chair> chairs = new ArrayList<>();
        for(int i =0; i<6; i++) {
            chairs.add(new Chair());
        }
        ArrayList<Table> tables = new ArrayList<>();
        tables.add(new Table(chairs, 1));

        //TABLE 2
        chairs = new ArrayList<>();
        for(int i =0; i<6; i++) {
            chairs.add(new Chair());
        }
        tables.add(new Table(chairs, 2));

        //TABLE 3
        chairs = new ArrayList<>();
        for(int i =0; i<6; i++) {
            chairs.add(new Chair());
        }
        tables.add(new Table(chairs, 3));

        //TABLE 4
        chairs = new ArrayList<>();
        for(int i =0; i<6; i++) {
            chairs.add(new Chair());
        }
        tables.add(new Table(chairs, 4));

        //TABLE 5
        chairs = new ArrayList<>();
        for(int i =0; i<8; i++) {
            chairs.add(new Chair());
        }
        tables.add(new Table(chairs, 5));

        //TABLE 6
        chairs = new ArrayList<>();
        for(int i =0; i<8; i++) {
            chairs.add(new Chair());
        }
        tables.add(new Table(chairs, 6));

        //TABLE 7
        chairs = new ArrayList<>();
        for(int i =0; i<4; i++) {
            chairs.add(new Chair());
        }
        tables.add(new Table(chairs, 7));

        //TABLE 8
        chairs = new ArrayList<>();
        for(int i =0; i<2; i++) {
            chairs.add(new Chair());
        }
        tables.add(new Table(chairs, 8));

        //TABLE 9
        chairs = new ArrayList<>();
        for(int i =0; i<2; i++) {
            chairs.add(new Chair());
        }
        tables.add(new Table(chairs, 9));

        //Le restaurant
        DataController dc = DataController.getInstance();
        dc.addTables(tables);

        buttonMap = (Button) findViewById(R.id.buttonMap);
        buttonMap.setOnClickListener(this);
        buttonClients = (Button) findViewById(R.id.buttonClients);
        buttonClients.setOnClickListener(this);
        buttonCommands = (Button) findViewById(R.id.buttonCommands);
        buttonCommands.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == buttonMap.getId()) {
            Intent descrGroupActivity = new Intent(StartActivity.this, RestaurantActivity.class);
            startActivity(descrGroupActivity);
        } else if(v.getId() == buttonClients.getId()) {
            Intent descrGroupActivity = new Intent(StartActivity.this, ClientsActivity.class);
            startActivity(descrGroupActivity);
        } else if(v.getId() == buttonCommands.getId()) {
            Intent descrGroupActivity = new Intent(StartActivity.this, RestaurantActivity.class);
            startActivity(descrGroupActivity);
        }
    }
}
