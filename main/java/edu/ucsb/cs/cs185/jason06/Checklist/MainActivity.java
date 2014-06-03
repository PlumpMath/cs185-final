package edu.ucsb.cs.cs185.jason06.Checklist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.view.menu.ListMenuItemView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends ListActivity {
    String[] seven = {
            "Dark Leafy Greens",
            "Nuts",
            "Carrots",
            "Green Tea",
            "Whole Grains",
            "Fruits"};
    String[] colors = {
            "red",
            "green"};
    HashMap<String, Boolean> colorMap;

    public void onCreate(Bundle savedInstanceState) {
        colorMap= new HashMap<String, Boolean>();
        colorMap.put(colors[0], false);
        colorMap.put(colors[1], false);

        super.onCreate(savedInstanceState);
        ListView lstView = getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seven));

    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        Toast.makeText(this, "You have selected " + colors[position], Toast.LENGTH_SHORT).show();
        colorMap.put(colors[position],!colorMap.get(colors[position]));
        parent.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_checked, colors));
        int i =0;
        for(String each:colors){
            parent.setItemChecked(i,colorMap.get(each));
            i++;
            Log.d("Map", colors[position] + " " +colorMap.get(each));
        }



    }
}