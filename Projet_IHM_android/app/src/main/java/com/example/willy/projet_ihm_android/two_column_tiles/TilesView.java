package com.example.willy.projet_ihm_android.two_column_tiles;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.R;
import com.origamilabs.library.views.StaggeredGridView;

/**
 * Created by lboutin on 07/04/16.
 */

public class TilesView extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_column_tiles);


        //GridView gridview = (GridView) findViewById(R.id.gridview);
        StaggeredGridView gridview = (StaggeredGridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        /*gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(TilesView.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}

