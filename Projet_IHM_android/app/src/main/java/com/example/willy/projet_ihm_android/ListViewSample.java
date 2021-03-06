package com.example.willy.projet_ihm_android;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by tanguinoche on 19/03/16.
 */
public class ListViewSample extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listview;

    //Appelée lors de la création de l'activité
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("", "Activity ListViewExample started");

        setContentView(R.layout.list_view_sample_layout);
        listview = (ListView) findViewById(R.id.listView);

        //Juste histoire d'avoir de la data, ça pourrait être n'importe quoi, n'importe où
        Random r = new Random();
        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
        for (int i = 0; i < 40; i++) {
            data.put(Integer.valueOf(i), Integer.valueOf(r.nextInt(50)));
        }

        //Adapter : En gros ça permet de lier une vue (Dans notre cas la ListView) à des données
        MyAdapter adapter;
        adapter = new MyAdapter(data);
        listview.setAdapter(adapter);

        //Juste pour qu'un élément soit cliquable
        listview.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Ici, la position récupérée est celle fournie par la méthode getItem de notre classe MyAdapter
        Toast.makeText(this, "Item " + position + "!!!", Toast.LENGTH_LONG).show();
    }


    private class MyAdapter extends BaseAdapter {

        LayoutInflater inflater;
        HashMap<Integer,Integer> data;

        public MyAdapter(HashMap<Integer,Integer> data){
            inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View recycleView, ViewGroup parent) {
            View v = recycleView;

            if(v == null){
                v = inflater.inflate(R.layout.rangee, parent, false);
            }

            Random r = new Random();
            TextView title = (TextView)v.findViewById(R.id.leftrow);
            TextView value = (TextView)v.findViewById(R.id.rightrow);

            title.setText("Data "+position);
            value.setText(data.get(position).toString());
            return v;
        }
    }

}
