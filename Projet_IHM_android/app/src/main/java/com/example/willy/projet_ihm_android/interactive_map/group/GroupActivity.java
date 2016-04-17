package com.example.willy.projet_ihm_android.interactive_map.group;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.MainActivity;
import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.data.Chair;
import com.example.willy.projet_ihm_android.data.DataController;
import com.example.willy.projet_ihm_android.data.Restaurant;
import com.example.willy.projet_ihm_android.data.Table;
import com.example.willy.projet_ihm_android.interactive_map.restaurant.RestaurantActivity;
import com.example.willy.projet_ihm_android.interactive_map.table.ChairGroupListener;
import com.example.willy.projet_ihm_android.interactive_map.table.ChairImageView;

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
    List<ImageView> highlights;
    List<ImageView> babyStickers;
    ChairImageView selectedChair = null;
    Button childButton;
    Button takeOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("AAA", "Activity ListViewExample started");

        Bundle b = getIntent().getExtras();
        groupColor = b.getInt("groupColor");
        Restaurant r = DataController.getInstance().getRestaurant();
        Log.d("ERROR", " "+b.getInt("num_table"));
        table = r.getTable(b.getInt("num_table"));
        List<Chair> chairs = table.getChairs();
        chairView = new ArrayList<ChairImageView>();
        highlights = new ArrayList<>();
        babyStickers = new ArrayList<>();


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
                highlights.add((ImageView)findViewById(R.id.highlight_left1));
                babyStickers.add((ImageView)findViewById(R.id.childmode_left1));
            }
            chair = (ChairImageView) findViewById(R.id.right1);
            chair.setChairModel(chairs.get(1));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
                highlights.add((ImageView)findViewById(R.id.highlight_right1));
                babyStickers.add((ImageView)findViewById(R.id.childmode_right1));
            }

        } if (table.getNbPlaces() >= 4) {
            chair = (ChairImageView) findViewById(R.id.left2);
            chair.setChairModel(chairs.get(2));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
                highlights.add((ImageView)findViewById(R.id.highlight_left2));
                babyStickers.add((ImageView)findViewById(R.id.childmode_left2));
            }
            chair = (ChairImageView) findViewById(R.id.right2);
            chair.setChairModel(chairs.get(3));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
                highlights.add((ImageView)findViewById(R.id.highlight_right2));
                babyStickers.add((ImageView)findViewById(R.id.childmode_right2));
            }

        } if (table.getNbPlaces() >= 6) {
            chair = (ChairImageView) findViewById(R.id.left3);
            chair.setChairModel(chairs.get(4));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
                highlights.add((ImageView)findViewById(R.id.highlight_left3));
                babyStickers.add((ImageView)findViewById(R.id.childmode_left3));
            }
            chair = (ChairImageView) findViewById(R.id.right3);
            chair.setChairModel(chairs.get(5));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
                highlights.add((ImageView)findViewById(R.id.highlight_right3));
                babyStickers.add((ImageView)findViewById(R.id.childmode_right3));
            }
        } if (table.getNbPlaces() >= 8) {
            chair = (ChairImageView) findViewById(R.id.left4);
            chair.setChairModel(chairs.get(6));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
                highlights.add((ImageView)findViewById(R.id.highlight_left4));
                babyStickers.add((ImageView)findViewById(R.id.childmode_left4));
            }
            chair = (ChairImageView) findViewById(R.id.right4);
            chair.setChairModel(chairs.get(7));
            if(chair.getChairModel().getColor()/4 == groupColor) {
                chairView.add(chair);
                highlights.add((ImageView)findViewById(R.id.highlight_right4));
                babyStickers.add((ImageView)findViewById(R.id.childmode_right4));
            }
        }


        TextView num_table = (TextView) findViewById(R.id.num_table);
        num_table.setText("Table " + table.getNumero());

        for (ChairImageView chv : chairView)
            chv.setOnClickListener(this);

        childButton = (Button) findViewById(R.id.childMode);
        childButton.setOnClickListener(this);
        takeOrderButton = (Button) findViewById(R.id.doOrder);
        takeOrderButton.setOnClickListener(this);
        childButton.setVisibility(View.INVISIBLE);
        takeOrderButton.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof ChairImageView) {
            ChairImageView chair  = (ChairImageView) v;

            //On enlève le précédent highlight
            int position;
            if(selectedChair !=null) {
                position =chairView.indexOf(selectedChair);
                highlights.get(position).setVisibility(View.INVISIBLE);
            }

            //On met à jour le chaise sélectionée
            selectedChair = chair;

            //On met le nouveau highlight
            position = chairView.indexOf(v);
            highlights.get(position).setVisibility(View.VISIBLE);

            //Les boutons deviennent visibles.
            childButton.setVisibility(View.VISIBLE);
            takeOrderButton.setVisibility(View.VISIBLE);

            Log.d("LOGLOGLOG", "OKOKOK");
        } else if(v.getId() == childButton.getId()) {
            //DataController.getInstance().changeChildClient(getClientselectedChair);
            //TODO : Faire autre chose que de l'affichage
            Toast.makeText(getApplicationContext(), "Mode enfant activé", Toast.LENGTH_SHORT).show();
            int position;
            if(selectedChair !=null) {
                position = chairView.indexOf(selectedChair);
                ImageView babyView =  (ImageView) babyStickers.get(position);
                if(babyView.getVisibility() == View.VISIBLE) {
                    babyView.setVisibility(View.INVISIBLE);
                } else {
                    babyView.setVisibility(View.VISIBLE);
                }
            }
        } else if(v.getId() == takeOrderButton.getId()) {
            //TODO
            Intent descrGroupActivity = new Intent(GroupActivity.this, MainActivity.class);
            startActivity(descrGroupActivity);
            Toast.makeText(getApplicationContext(), "take order instead of client", Toast.LENGTH_SHORT).show();
        }
    }

}
