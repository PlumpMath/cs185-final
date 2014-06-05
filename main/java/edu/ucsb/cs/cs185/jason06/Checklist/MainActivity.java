package edu.ucsb.cs.cs185.jason06.Checklist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.*;

public class MainActivity extends ActionBarActivity {
    private checkMenuFragment mCheckList_;
    final static String MYTAG = "mytag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
             View rootView = inflater.inflate(R.layout.blank_fragment, container, false);
            return rootView;
        }



    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            try {

                mCheckList_ = new checkMenuFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
                    fm.popBackStack();
                }
                fragmentTransaction.replace(R.id.container, mCheckList_, MYTAG);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
            catch(Exception e) {
                Log.d("My Debug", "SOME EXCEPTION" + e.getMessage());

            }


            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        final checkMenuFragment fragment=
                (checkMenuFragment)getSupportFragmentManager().findFragmentByTag(MYTAG);
        if (fragment.allowBack())
        {
            super.onBackPressed();
        }
    }




}