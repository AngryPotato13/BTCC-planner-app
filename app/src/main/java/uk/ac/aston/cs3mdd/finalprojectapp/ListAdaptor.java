package uk.ac.aston.cs3mdd.finalprojectapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListAdaptor extends BaseAdapter {

    Activity mActivity;
    MyLists myLists;
    List<ListItems> originalList;


    public ListAdaptor(FragmentActivity mActivity, MyLists myLists) {
        this.mActivity = mActivity;
        this.myLists = myLists;
        this.originalList = new ArrayList<>(myLists.getMyListslist());
        updateOriginalList();
    }


    public void sortAlphabetically() {
        Collections.sort(myLists.getMyListslist());
        notifyDataSetChanged();
    }


    public void updateOriginalList() {
        originalList.clear();
        originalList.addAll(myLists.getMyListslist());
    }

    @Override
    public int getCount() {
        return myLists.getMyListslist().size();
    }

    @Override
    public ListItems getItem(int position) {
        return myLists.getMyListslist().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View onePersonLine;

        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = inflater.inflate(R.layout.display_info, parent, false);

        TextView tv_name = onePersonLine.findViewById(R.id.tv_name);
        TextView tv_Location = onePersonLine.findViewById(R.id.tv_Location);
        TextView tv_list_days = onePersonLine.findViewById(R.id.tv_list_days);
        TextView tv_list_staying = onePersonLine.findViewById(R.id.tv_list_staying);
        TextView tv_list_eating = onePersonLine.findViewById(R.id.tv_list_eating);
        TextView tv_list_amount_poi = onePersonLine.findViewById(R.id.tv_list_amount_poi);

        ListItems listItem = this.getItem(position);

        tv_name.setText(listItem.getName());
        tv_Location.setText(listItem.getLocation());
        tv_list_days.setText("Days: " + String.valueOf(listItem.getDays()));
        tv_list_staying.setText("Staying: " + listItem.getStaying());
        tv_list_eating.setText("eating: " + listItem.getEating());
        tv_list_amount_poi.setText("POI visiting: " + listItem.getPOI());

        return onePersonLine;
    }

    public void setFilter(List<ListItems> filteredList) {
        myLists.setMyListslist(filteredList);
        notifyDataSetChanged();
    }

    public void clear() {
    }

    public void addAll(List<ListItems> filteredList) {
    }
}
