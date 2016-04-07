package com.example.willy.projet_ihm_android.interactive_map.table;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import com.example.willy.projet_ihm_android.data.Restaurant;
import com.example.willy.projet_ihm_android.data.Table;
import com.example.willy.projet_ihm_android.interactive_map.GroupActivity;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanguinoche on 22/03/16.
 */
public class TableActivity extends Activity implements AdapterView.OnItemClickListener{
    public final static String GROUP = "com.example.willy.projet_ihm_android.interactive_map_table.GROUP";

    //Table with chairs
    ChairGroupListener tableView;

    //List View with adapter
    ListView groups;
    GroupAdapter adapter;
    List<AbstractMap.SimpleEntry<Integer,List<ChairImageView>>> data;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("AAA", "Activity ListViewExample started");

        setContentView(R.layout.interactive_map_table);

        Bundle b = getIntent().getExtras();
        Table table = (Table)b.getParcelable("table");
        List<Chair> chairs = table.getChairs();

        TextView num_table = (TextView) findViewById(R.id.num_table);
        num_table.setText("Table "+table.getNumero());

        ChairImageView chair1 = (ChairImageView) findViewById(R.id.left1);
        chair1.setChairModel(chairs.get(0));
        ChairImageView chair2 = (ChairImageView) findViewById(R.id.left2);
        chair2.setChairModel(chairs.get(1));
        ChairImageView chair3 = (ChairImageView) findViewById(R.id.left3);
        chair3.setChairModel(chairs.get(2));
        ChairImageView chair4 = (ChairImageView) findViewById(R.id.right1);
        chair4.setChairModel(chairs.get(3));
        ChairImageView chair5 = (ChairImageView) findViewById(R.id.right2);
        chair5.setChairModel(chairs.get(4));
        ChairImageView chair6 = (ChairImageView) findViewById(R.id.right3);
        chair6.setChairModel(chairs.get(5));
        List<ChairImageView> chairView = new ArrayList<ChairImageView>();
        chairView.add(chair1);
        chairView.add(chair2);
        chairView.add(chair3);
        chairView.add(chair4);
        chairView.add(chair5);
        chairView.add(chair6);
        groups = (ListView)findViewById(R.id.listViewGroupsTable);
        data = new ArrayList<AbstractMap.SimpleEntry<Integer,List<ChairImageView>>>();
        adapter = new GroupAdapter(data);
        groups.setAdapter(adapter);
        groups.setOnItemClickListener(this);

        tableView = new ChairGroupListener(chairView, data, adapter);


    }


    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Nouvelle activité pour plus de détails par exemple !
        Intent descrGroupActivity = new Intent(TableActivity.this, GroupActivity.class);
        descrGroupActivity.putExtra(GROUP, data.get(position).getKey());
        startActivity(descrGroupActivity);
    }

    class GroupAdapter extends BaseAdapter {

        LayoutInflater inflater;
        List<AbstractMap.SimpleEntry<Integer,List<ChairImageView>>> data;
        private Integer GRAY=0, GREEN=1, YELLOW=2, TURQUOISE=3, ORANGE=4, PURPLE=5,
                BLUE=6, RED=7, PINK=8, GROWN=9;

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
            if(colorGroup==GREEN) title.setBackgroundColor(Color.parseColor("#2e8c19"));
            else if(colorGroup==YELLOW) title.setBackgroundColor(Color.parseColor("#ffea00"));
            else if(colorGroup==TURQUOISE) title.setBackgroundColor(Color.parseColor("#3fffef"));
            else if(colorGroup==ORANGE) title.setBackgroundColor(Color.parseColor("#ff7e00"));
            else if(colorGroup==PURPLE) title.setBackgroundColor(Color.parseColor("#cc00ff"));
            else if(colorGroup==BLUE) title.setBackgroundColor(Color.parseColor("#2a00ff"));
            else if(colorGroup==RED) title.setBackgroundColor(Color.parseColor("#e30015"));
            else if(colorGroup==PINK) title.setBackgroundColor(Color.parseColor("#ff62fd"));
            else if(colorGroup==GROWN) title.setBackgroundColor(Color.parseColor("#572b00"));


            title.setText("Groupe "+Character.toChars(position+65)[0]);
            value.setText("Il y a "+data.get(position).getValue().size()+"clients !");
            return v;
        }
    }
}
