package com.example.willy.projet_ihm_android.interactive_map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.interactive_map.table.TableActivity;

/**
 * Created by tanguinoche on 02/04/16.
 */
public class GroupActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On récupère l'intent qui a lancé cette activité
        Intent i = getIntent();

        // Puis on récupère l'âge donné dans l'autre activité, ou 0 si cet extra n'est pas dans l'intent
        int group = i.getIntExtra(TableActivity.GROUP, 0);

    }
}
