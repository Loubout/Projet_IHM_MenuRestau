package com.example.willy.projet_ihm_android.interactive_map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.data.Chair;
import com.example.willy.projet_ihm_android.data.Restaurant;
import com.example.willy.projet_ihm_android.data.Table;
import com.example.willy.projet_ihm_android.interactive_map.restaurant.RestaurantActivity;
import com.example.willy.projet_ihm_android.interactive_map.restaurant.TableImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanguinoche on 07/04/16.
 */
public class StartActivity extends Activity implements View.OnClickListener {

    Restaurant restaurant;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("AAA", "Activity interactive map restaurant started");

        setContentView(R.layout.start_activity);

        //Les chaises
        ArrayList<Chair> chairs = new ArrayList<>();
        for(int i =0; i<6; i++) {
            chairs.add(new Chair());
        }
        //Les tables
        ArrayList<Table> tables = new ArrayList<>();
        tables.add(new Table(chairs));
        //Le restaurant
        restaurant = new Restaurant(tables);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent descrGroupActivity = new Intent(StartActivity.this, RestaurantActivity.class);
        descrGroupActivity.putExtra("restaurant", restaurant);
        startActivity(descrGroupActivity);
    }
}
