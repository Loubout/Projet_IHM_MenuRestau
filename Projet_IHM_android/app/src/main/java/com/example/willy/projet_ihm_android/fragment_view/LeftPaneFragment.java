package com.example.willy.projet_ihm_android.fragment_view;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.willy.projet_ihm_android.R;


/**
 * Created by Tomohiro on 22/03/16.
 */
public class LeftPaneFragment extends ListFragment {

    ListView listview;
    OnArticleSelectedListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.left_pane_fragment, container, false);
        listview = (ListView) getActivity().findViewById(android.R.id.list);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final String[] items = getResources().getStringArray(R.array.menuItems);
        final ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
                R.layout.menu_item_layout, R.id.menuItem, items);

        setListAdapter(aa);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnArticleSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }
    }

    public interface OnArticleSelectedListener {
        public void onArticleSelected(String data);
    }

    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        super.onListItemClick(l, v, pos, id);
        View item = getViewByPosition(pos, l);
        item.setSelected(true);

        String data = (l.getItemAtPosition(pos)).toString();

        if(mListener != null)
            mListener.onArticleSelected(data);

        //Toast.makeText(getActivity(), data, Toast.LENGTH_SHORT).show();
    }

}
