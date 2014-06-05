package edu.ucsb.cs.cs185.jason06.Checklist;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;


import edu.ucsb.cs.cs185.jason06.Checklist.dummy.DummyContent;

/**
 * A fragment representing a list of Items.

 */
public class checkMenuFragment extends ListFragment {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final int AGEDISTRIBUTION = 0;
    public static final int CENSUSELEMENTS = 1;
    public static final int ERROR = 2;
    public static final int ETHNICDISTRIBUTION=3;
    public static final int INCOMEDISTRIBUTION=4;
    public static final int OTHERINFORMATION=5;
    public static final int RACEDISTRIBUTION=6;
    public static final int URBANCLASSIFICATION=7;

    public static final int MAINMENU = 8;
    SharedPreferences mSharedPreferences_;
    private int mMode_;
    String [] choice={""};
    boolean was_main=false;

    private String [] mMain_menu_;
    private String [] mAgeDistribution_;
    private String [] mCensusElements_;
    private String [] mError_;
    private String [] mEthnicDistribution_;
    private String [] mIncomeDistribution_;
    private String [] mOtherInformation_;
    private String [] mRaceDistribution_;
    private String [] mUrbanClassification_;
    private SharedPreferences.Editor mEditor_;
    private LinearLayout ll;
    private FragmentActivity fa;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mMode_ = MAINMENU;
        mMain_menu_ = getResources().getStringArray(R.array.main_menu);
        mAgeDistribution_ = getResources().getStringArray(R.array.AgeDistribution);
        mCensusElements_ = getResources().getStringArray(R.array.CensusElements);
        mError_ = getResources().getStringArray(R.array.Error);
        mEthnicDistribution_ = getResources().getStringArray(R.array.EthnicDistribution);
        mIncomeDistribution_ = getResources().getStringArray(R.array.IncomeDistribution);
        mOtherInformation_ = getResources().getStringArray(R.array.OtherInformation);
        mRaceDistribution_ = getResources().getStringArray(R.array.RaceDistribution);
        mUrbanClassification_ = getResources().getStringArray(R.array.UrbanClassification);

        mSharedPreferences_ = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mEditor_= mSharedPreferences_.edit();

//To avoid collisions in the preferences I prepend the category number to each key
        for(String each:mAgeDistribution_){
            mEditor_.putBoolean(AGEDISTRIBUTION + each,false);
        }
        for(String each:mCensusElements_){
            mEditor_.putBoolean(CENSUSELEMENTS + each,false);
        }
        for(String each:mError_){
            mEditor_.putBoolean(ERROR + each,false);
        }
        for(String each:mEthnicDistribution_){
            mEditor_.putBoolean(ETHNICDISTRIBUTION + each,false);
        }
        for(String each:mIncomeDistribution_){
            mEditor_.putBoolean(INCOMEDISTRIBUTION+ each,false);
        }
        for(String each:mOtherInformation_){
            mEditor_.putBoolean(OTHERINFORMATION +each,false);
        }
        for(String each:mRaceDistribution_){
            mEditor_.putBoolean(RACEDISTRIBUTION +each,false);
        }
        for(String each:mUrbanClassification_){
            mEditor_.putBoolean(URBANCLASSIFICATION + each,false);
        }
        mEditor_.commit();

        Log.d ("Fuck","I get here dmsdadasdsadasanit");

        ll = (LinearLayout) inflater.inflate(R.layout.fragment_checkmenu_list, container, false);
        Log.d ("Fuck","I get here dma111111nit");



        fa = super.getActivity();

        return ll;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        ListView lstView = getListView();
        lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lstView.setTextFilterEnabled(true);
        Log.d ("Fuck","I get here dmanit");

        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mMain_menu_));
        super.onActivityCreated(savedInstanceState);
    }
    //If we are in a checkbox then when we hit the back button we want to go to the main menu
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mMode_ !=MAINMENU) {
            mMode_ = MAINMENU;
            setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mMain_menu_));

            return true;
        }
        return false;
        //return super.onKeyDown(keyCode, event);
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
//I have arranged it so that the position in mainmenu is equal to the constants for the submenus
        was_main = false;
        if (mMode_== MAINMENU) {
            was_main=true;
            switch (position) {
                case AGEDISTRIBUTION:
                    mMode_ = AGEDISTRIBUTION;
                    choice = mAgeDistribution_;
                    break;
                case CENSUSELEMENTS:
                    mMode_ = CENSUSELEMENTS;
                    choice = mCensusElements_;
                    break;
                case ERROR:
                    mMode_ = ERROR;
                    choice = mError_;
                    break;
                case ETHNICDISTRIBUTION:
                    mMode_ = ETHNICDISTRIBUTION;
                    choice = mEthnicDistribution_;
                    break;
                case INCOMEDISTRIBUTION:
                    mMode_ = INCOMEDISTRIBUTION;
                    choice = mIncomeDistribution_;
                    break;
                case OTHERINFORMATION:
                    mMode_ = OTHERINFORMATION;
                    choice = mOtherInformation_;
                    break;
                case RACEDISTRIBUTION:
                    mMode_ = RACEDISTRIBUTION;
                    choice = mRaceDistribution_;
                    break;
                case URBANCLASSIFICATION:
                    mMode_ = URBANCLASSIFICATION;
                    choice = mUrbanClassification_;
                    break;
                default:
                    break;

            }
        }
        if (mMode_!=MAINMENU) {

            Log.d("choice", "I happen");
            parent.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_checked, choice));

            if(!was_main) {
                mEditor_.putBoolean(choice[position], !mSharedPreferences_.getBoolean(choice[position], false));
                mEditor_.commit();
            }
            int i = 0;
            for (String each : choice) {
                parent.setItemChecked(i, mSharedPreferences_.getBoolean(each, false));
                i++;
            }
            was_main=false;
        }



    }
}
