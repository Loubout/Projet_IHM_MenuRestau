package com.example.willy.projet_ihm_android.listing;

/**
 * Created by tanguinoche on 11/04/16.
 */

import android.app.Activity;
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

import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.data.Client;
import com.example.willy.projet_ihm_android.data.DataController;

import java.util.HashMap;
import java.util.List;
import java.util.Random;


/**
 * Created by tanguinoche on 19/03/16.
 */
public class ClientsActivity extends Activity {
    MyAdapter adapter;
    ListView listview;

    //Appelée lors de la création de l'activité
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.simple_list_view);
        listview = (ListView) findViewById(R.id.listView);

        adapter = new MyAdapter(DataController.getInstance().getClients());
        listview.setAdapter(adapter);
        //listview.setOnItemClickListener(this);

    }

    @Override protected void onStart() {
        super.onStart();
        adapter.notifyDataSetChanged();
    }


    private class MyAdapter extends BaseAdapter {

        LayoutInflater inflater;
        List<Client> data;

        public MyAdapter(List<Client> data){
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
            TextView title = (TextView)v.findViewById(R.id.leftrow);
            TextView value = (TextView)v.findViewById(R.id.rightrow);

            title.setText("Client "+position);
            value.setText("id : "+data.get(position).getId());
            return v;
        }
    }

}

