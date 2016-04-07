package com.example.willy.projet_ihm_android.interactive_map.table;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanguinoche on 02/04/16.
 */
public class ChairGroupListener implements View.OnTouchListener, View.OnLongClickListener{
    List<ChairImageView> chairs;
    List<ChairImageView> chairsSelected;

    private List<AbstractMap.SimpleEntry<Integer,List<ChairImageView>>> data;

    TableActivity.GroupAdapter adapter;
    private boolean longClick = false;

    public ChairGroupListener(List<ChairImageView> chairs, List<AbstractMap.SimpleEntry<Integer, List<ChairImageView>>> data, TableActivity.GroupAdapter adapter) {
        this.chairs = chairs;
        this.data=data;
        this.adapter = adapter;
        chairsSelected = new ArrayList<>();
        for(ChairImageView chair : chairs) {
            chair.setOnTouchListener(this);
            chair.setOnLongClickListener(this);
        }
    }

    @Override public boolean onTouch(View chair, MotionEvent event) {
        final int action = event.getAction();
        float x;
        float y;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.d("MOTION_EVENT", "down on chair "+chairs.lastIndexOf(chair));
                chairsSelected.clear();
                chairsSelected.add((ChairImageView)chair);
                return false;
            case MotionEvent.ACTION_MOVE:
                x = event.getRawX();
                y = event.getRawY();
                ChairImageView v;

                if((v = findViewOnCoordinates(x, y))!=null && !chairsSelected.contains(v))
                {
                    int color = chairsSelected.get(0).getColor();
                    ((ChairImageView)v).setColor(color);
                    chairsSelected.add(v);
                }
                Log.d("MOTION_EVENT", "move on chair "+chairs.lastIndexOf(v));
                return false;
            case MotionEvent.ACTION_UP:
                Log.d("MOTION_EVENT", "up on chair " + chairs.lastIndexOf(chair));
                x = event.getRawX();
                y = event.getRawY();
                if(longClick==true)
                {//Long tap
                    longClick = false;

                }
                else if(chair==findViewOnCoordinates(x, y))
                {//Short tap
                    chairsSelected.get(0).changeColor();
                }

                updateData();
                return false;
            case MotionEvent.ACTION_CANCEL:
                return false;
        }
        return false;
    }
    @Override public boolean onLongClick(View view) {
        chairsSelected.get(0).setColor(0);
        longClick=true;
        return false;
    }



    private ChairImageView findViewOnCoordinates(float x, float y) {
        int location[] = new int[2];
        for(ChairImageView chair : chairs) {
            chair.getLocationOnScreen(location);
            int viewX = location[0];
            int viewY = location[1];
            if(( x > viewX && x < (viewX + chair.getWidth())) && ( y > viewY && y < (viewY + chair.getHeight()))){
                return chair;
            }
        }
        return null;
    }

    private void updateData() {

        data.clear();
        //On détermine les groupes !
        for(ChairImageView chair : chairs) {
            Integer colorGroup = (chair.getColor()/4);
            if(colorGroup != 0) { //GRAY => Aucun groupe associé
                boolean foundGroup=false;
                for(AbstractMap.SimpleEntry<Integer,List<ChairImageView>> group : data) {
                    if(group.getKey()==colorGroup) {
                        group.getValue().add(chair);
                        foundGroup=true;
                        break;
                    }
                }
                if(!foundGroup) {
                    List<ChairImageView> group = new ArrayList<ChairImageView>(6);
                    group.add(chair);
                    data.add(new AbstractMap.SimpleEntry<Integer,List<ChairImageView>>(colorGroup, group));
                }
            }
        }
        adapter.notifyDataSetChanged();
    }


}
