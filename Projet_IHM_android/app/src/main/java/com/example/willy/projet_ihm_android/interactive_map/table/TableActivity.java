package com.example.willy.projet_ihm_android.interactive_map.table;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.data.Chair;
import com.example.willy.projet_ihm_android.data.Client;
import com.example.willy.projet_ihm_android.data.DataController;
import com.example.willy.projet_ihm_android.data.Restaurant;
import com.example.willy.projet_ihm_android.data.Table;
import com.example.willy.projet_ihm_android.data.enumeration.Color;
import com.example.willy.projet_ihm_android.interactive_map.group.GroupActivity;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanguinoche on 22/03/16.
 */
public class TableActivity extends Activity implements AdapterView.OnItemClickListener{

    //Table with chairs
    ChairGroupListener tableView;
    List<Chair> chairs;

    //List View with adapter
    ListView groups;
    GroupAdapter adapter;
    List<AbstractMap.SimpleEntry<Integer,List<ChairImageView>>> data;
    Table table;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("AAA", "Activity ListViewExample started");
        Bundle b = getIntent().getExtras();
        Restaurant r = DataController.getInstance().getRestaurant();
        table = r.getTable(b.getInt("num_table"));
        chairs = table.getChairs();
        List<ChairImageView> chairView = new ArrayList<ChairImageView>();


        ChairImageView chair;


        if(table.getNbPlaces()==2) {
            setContentView(R.layout.interactive_map_table_2);
            chair = (ChairImageView) findViewById(R.id.left1);
            chair.setChairModel(chairs.get(0));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.right1);
            chair.setChairModel(chairs.get(1));
            chairView.add(chair);

        } else if(table.getNbPlaces()==4) {
            setContentView(R.layout.interactive_map_table_4);
            chair = (ChairImageView) findViewById(R.id.left1);
            chair.setChairModel(chairs.get(0));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.right1);
            chair.setChairModel(chairs.get(1));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.left2);
            chair.setChairModel(chairs.get(2));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.right2);
            chair.setChairModel(chairs.get(3));
            chairView.add(chair);

        } else if(table.getNbPlaces()==6) {
            setContentView(R.layout.interactive_map_table_6);
            chair = (ChairImageView) findViewById(R.id.left1);
            chair.setChairModel(chairs.get(0));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.right1);
            chair.setChairModel(chairs.get(1));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.left2);
            chair.setChairModel(chairs.get(2));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.right2);
            chair.setChairModel(chairs.get(3));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.left3);
            chair.setChairModel(chairs.get(4));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.right3);
            chair.setChairModel(chairs.get(5));
            chairView.add(chair);

        } else if(table.getNbPlaces()==8) {
            setContentView(R.layout.interactive_map_table_8);
            chair = (ChairImageView) findViewById(R.id.left1);
            chair.setChairModel(chairs.get(0));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.right1);
            chair.setChairModel(chairs.get(1));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.left2);
            chair.setChairModel(chairs.get(2));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.right2);
            chair.setChairModel(chairs.get(3));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.left3);
            chair.setChairModel(chairs.get(4));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.right3);
            chair.setChairModel(chairs.get(5));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.left4);
            chair.setChairModel(chairs.get(6));
            chairView.add(chair);
            chair = (ChairImageView) findViewById(R.id.right4);
            chair.setChairModel(chairs.get(7));
            chairView.add(chair);

        }


        TextView num_table = (TextView) findViewById(R.id.num_table);
        num_table.setText("Table " + table.getNumero());

        groups = (ListView)findViewById(R.id.listViewGroupsTable);
        data = new ArrayList<AbstractMap.SimpleEntry<Integer,List<ChairImageView>>>();
        adapter = new GroupAdapter(data);
        groups.setAdapter(adapter);
        groups.setOnItemClickListener(this);

        tableView = new ChairGroupListener(chairView, data, adapter);

    }

    @Override protected void onStart() {
        super.onStart();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        Log.d("TABLEACTIVITY", "BUTTON BACK HAS BEEN PRESS");
        //TODO : C'est ici qu'on ajoute réellement les clients aux chaises.
        for(Chair c : chairs) {
            if(c.getColor() != 0)
                DataController.getInstance().addReservation(new Client(), c);
        }
        super.onBackPressed();
    }


    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Nouvelle activité pour plus de détails par exemple !
        Intent descrGroupActivity = new Intent(TableActivity.this, GroupActivity.class);
        int groupColor=data.get(position).getKey();
        descrGroupActivity.putExtra("groupColor", groupColor);
        descrGroupActivity.putExtra("num_table", table.getNumero());
        startActivity(descrGroupActivity);
    }

    class GroupAdapter extends BaseAdapter {

        LayoutInflater inflater;
        List<AbstractMap.SimpleEntry<Integer,List<ChairImageView>>> data;

        public GroupAdapter(List<AbstractMap.SimpleEntry<Integer,List<ChairImageView>>> data){
            this.data = data;
            inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override public int getCount() {
            return data.size();
        }

        @Override public Object getItem(int position) {
            return null;
        }

        @Override public long getItemId(int position) {
            return position;
        }

        @Override public View getView(int position, View recycleView, ViewGroup parent) {
            View v = recycleView;

            if(v == null){
                v = inflater.inflate(R.layout.rangee_interactive_map, parent, false);
            }

            TextView title = (TextView)v.findViewById(R.id.leftrow);
            TextView value = (TextView)v.findViewById(R.id.rightrow);

            int colorGroup=data.get(position).getKey();
            if(colorGroup==Color.GREEN) title.setBackgroundColor(Color.parseColor("#2e8c19"));
            else if(colorGroup==Color.YELLOW) title.setBackgroundColor(Color.parseColor("#ffea00"));
            else if(colorGroup==Color.TURQUOISE) title.setBackgroundColor(Color.parseColor("#3fffef"));
            else if(colorGroup==Color.ORANGE) title.setBackgroundColor(Color.parseColor("#ff7e00"));
            else if(colorGroup==Color.PURPLE) title.setBackgroundColor(Color.parseColor("#cc00ff"));
            else if(colorGroup==Color.BLUE) title.setBackgroundColor(Color.parseColor("#2a00ff"));
            else if(colorGroup==Color.RED) title.setBackgroundColor(Color.parseColor("#e30015"));
            else if(colorGroup==Color.PINK) title.setBackgroundColor(Color.parseColor("#ff62fd"));
            else if(colorGroup==Color.GROWN) title.setBackgroundColor(Color.parseColor("#572b00"));


            title.setText("Groupe "+Character.toChars(position+65)[0]);
            value.setText("Il y a "+data.get(position).getValue().size()+"clients !");
            return v;
        }
    }
}
