package edu.ucsb.cs.cs185.jason06.Checklist;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import android.app.ListActivity;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends ListActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final int SUBMENU = 0;
    public static final int MAINMENU = 1;
    SharedPreferences mSharedPreferences_;
    private int mMode_;

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
    private SharedPreferences.Editor mEditor_;
    HashMap<String, Boolean> colorMap;

    public void onCreate(Bundle savedInstanceState) {
        mMode_ = MAINMENU;
        colorMap= new HashMap<String, Boolean>();
        mSharedPreferences_ = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mEditor_= mSharedPreferences_.edit();
        for(String each:colors) {
            mEditor_.putBoolean(each, false);
        }
        mEditor_.commit();


        super.onCreate(savedInstanceState);
        ListView lstView = getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seven));

    }

    //If we are in a checkbox then when we hit the back button we want to go to the main menu
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mMode_ ==SUBMENU) {
            mMode_ = MAINMENU;
            setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seven));

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        mMode_ = SUBMENU;
        Toast.makeText(this, "You have selected " + colors[position], Toast.LENGTH_SHORT).show();
        mEditor_.putBoolean(colors[position], !mSharedPreferences_.getBoolean(colors[position], false));
        mEditor_.commit();
        parent.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_checked, colors));
        int i =0;
        for(String each:colors){
            parent.setItemChecked(i,mSharedPreferences_.getBoolean(each,true));
            i++;
        }



    }
}