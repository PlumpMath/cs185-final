package edu.ucsb.cs.cs185.jason06.Checklist;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by jason on 6/10/14.
 *
 */


public class ResultsActivity extends ListActivity{
    private String [] mMain_menu_;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences mSharedPreferences_;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> temp = new ArrayList<String>();
        mSharedPreferences_ = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Map<String,?> keys = mSharedPreferences_.getAll();


        //TODO
        //PUT PARSED CODE WHERE IT SAYS STUB
        for(Map.Entry<String,?> entry : keys.entrySet()){
            if (entry.getValue().toString().equals("true")) {
                temp.add(entry.getKey().toString() + ":Stub");

            }
            Log.d("map values", entry.getKey() + ": " +
                    entry.getKey().toString());
        }






        mMain_menu_= new String[temp.size()];
        temp.toArray(mMain_menu_);

        ListView lstView = getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mMain_menu_));
    }



    public void onListItemClick(ListView parent, View v, int position, long id) {
    }

}
