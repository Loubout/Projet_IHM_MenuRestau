package com.example.willy.projet_ihm_android;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.fragment_view.LeftPaneFragment;
import com.example.willy.projet_ihm_android.fragment_view.MainPaneFragment;
import com.example.willy.projet_ihm_android.fragment_view.TopPaneFragment;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    ListView listview;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("", "MainActivity started");

        TopPaneFragment topPaneFragment = new TopPaneFragment();
        LeftPaneFragment leftMenuFragment = new LeftPaneFragment();
        MainPaneFragment mainPaneFragment = new MainPaneFragment();

        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.leftSidePanel, leftMenuFragment, "leftMenuFragment");
        transaction.add(R.id.mainPanel, mainPaneFragment, "mainFragment");

        listview = (ListView) findViewById(android.R.id.list);

        //Juste histoire d'avoir de la data, ça pourrait être n'importe quoi, n'importe où
        Random r     = new Random();
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Ici, la position récupérée est celle fournie par la méthode getItem de notre classe MyAdapter
        Toast.makeText(this, "Item " + position + "!!!", Toast.LENGTH_SHORT).show();
    }

}