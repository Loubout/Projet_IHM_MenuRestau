package com.example.willy.projet_ihm_android.interactive_map;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanguinoche on 02/04/16.
 */
public class Table implements View.OnTouchListener {
    List<ChairImageView> chairs;
    List<ChairImageView> chairsSelected;

    private List<AbstractMap.SimpleEntry<Integer,List<ChairImageView>>> data;

    MapActivity.GroupAdapter adapter;

    public Table(List<ChairImageView> chairs, List<AbstractMap.SimpleEntry<Integer,List<ChairImageView>>> data, MapActivity.GroupAdapter adapter) {
        this.chairs = chairs;
        this.data=data;
        this.adapter = adapter;
        chairsSelected = new ArrayList<>();
        for(ChairImageView chair : chairs) {
            chair.setOnTouchListener(this);
        }


    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {

        final int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.d("MOTION_EVENT", "down on chair "+chairs.lastIndexOf(view));
                chairsSelected.clear();
                chairsSelected.add((ChairImageView)view);
                return true;
            case MotionEvent.ACTION_MOVE:
                float x = event.getRawX();
                float y = event.getRawY();
                ChairImageView v = findViewOnCoordinates(x, y);
                Log.d("MOTION_EVENT", "move on chair "+chairs.lastIndexOf(v));
                if(v!=null && !chairsSelected.contains(v))
                    chairsSelected.add(v);
                return true;
            case MotionEvent.ACTION_UP:
                Log.d("MOTION_EVENT", "up on chair " + chairs.lastIndexOf(view));
                if(chairsSelected.size()==1) {
                    chairsSelected.get(0).changeColor();
                } else {
                    int color = chairsSelected.get(0).getColor();
                    for(ChairImageView chair : chairsSelected)
                        chair.setColor(color);
                }
                updateData();
                return true;
            case MotionEvent.ACTION_CANCEL:
                return false;
        }
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
