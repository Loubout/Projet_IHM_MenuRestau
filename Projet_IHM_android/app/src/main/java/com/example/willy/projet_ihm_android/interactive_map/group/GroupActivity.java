package com.example.willy.projet_ihm_android.interactive_map.group;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.data.Chair;
import com.example.willy.projet_ihm_android.data.DataController;
import com.example.willy.projet_ihm_android.data.Restaurant;
import com.example.willy.projet_ihm_android.data.Table;
import com.example.willy.projet_ihm_android.data.enumeration.Color;
import com.example.willy.projet_ihm_android.interactive_map.table.ChairGroupListener;
import com.example.willy.projet_ihm_android.interactive_map.table.ChairImageView;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanguinoche on 02/04/16.
 */
public class GroupActivity extends Activity implements View.OnClickListener {

    //Table with chairs
    ChairGroupListener tableView;
    int groupColor;


    Table table;
    List<ChairImageView> chairView;
    Chair selectedChair;
    Button childButton;
    Button takeOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("AAA", "Activity ListViewExample started");
        childButton = (Button) findViewById(R.id.childMode);
        takeOrderButton = (Button) findViewById(R.id.doOrder);
        Bundle b = getIntent().getExtras();
        groupColor = b.getInt("groupColor");
        Restaurant r = DataController.getInstance().getRestaurant();
        table = r.getTable(b.getInt("num_table"));
        List<Chair> chairs = table.getChairs();
        chairView = new ArrayList<ChairImageView>();


        ChairImageView chair;

        if (table.getNbPlaces() == 2) {
            setContentView(R.layout.interactive_group_table_2);
        } else if (table.getNbPlaces() == 4) {
            setContentView(R.layout.interactive_group_table_4);
        } else if (table.getNbPlaces() == 6) {
            setContentView(R.layout.interactive_group_table_6);
        } else if (table.getNbPlaces() == 8) {
            setContentView(R.layout.interactive_group_table_8);
        }

        if (table.getNbPlaces() >= 2) {
            chair = (ChairImageView) findViewById(R.id.left1);
            chair.setChairModel(chairs.get(0));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
            }
            chair = (ChairImageView) findViewById(R.id.right1);
            chair.setChairModel(chairs.get(1));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
            }

        } if (table.getNbPlaces() >= 4) {
            chair = (ChairImageView) findViewById(R.id.left2);
            chair.setChairModel(chairs.get(2));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
            }
            chair = (ChairImageView) findViewById(R.id.right2);
            chair.setChairModel(chairs.get(3));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
            }

        } if (table.getNbPlaces() >= 6) {
            chair = (ChairImageView) findViewById(R.id.left3);
            chair.setChairModel(chairs.get(4));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
            }
            chair = (ChairImageView) findViewById(R.id.right3);
            chair.setChairModel(chairs.get(5));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
            }
        } if (table.getNbPlaces() >= 8) {
            chair = (ChairImageView) findViewById(R.id.left4);
            chair.setChairModel(chairs.get(6));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
            }
            chair = (ChairImageView) findViewById(R.id.right4);
            chair.setChairModel(chairs.get(7));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
            }
        }


        TextView num_table = (TextView) findViewById(R.id.num_table);
        num_table.setText("Table " + table.getNumero());

        for (ChairImageView chv : chairView)
            chv.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v instanceof ChairImageView) {
            ChairImageView chair  = (ChairImageView) v;
            selectedChair = chair.getChairModel();
            Log.d("LOGLOGLOG", "OKOKOK");
        }

        if(v.getId() == childButton.getId()) {
            //DataController.getInstance().changeChildClient(getClientselectedChair);
        } else if(v.getId() == takeOrderButton.getId()) {
            //TODO
        }
    }

}
