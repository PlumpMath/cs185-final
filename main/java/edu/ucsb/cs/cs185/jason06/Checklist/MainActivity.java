package edu.ucsb.cs.cs185.jason06.Checklist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.*;

/**
 * Created by jason on 6/10/14.
 */

//
//import android.app.Activity;
//        import android.content.Intent;
//        import android.os.Bundle;
//        import android.util.Log;
//        import android.view.View;
//        import android.widget.Button;
//        import android.widget.TextView;
//
//
//
//
//public class SecondActivity extends Activity {
//    /** Called when the activity is first created. */
//
//
//
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.blank_fragment);
//
//
//
//        Intent i = getIntent();
//        // Receiving the Data
//        Log.e("Second Screen", "Second Screen");
//
//
//
//    }

//
//}
public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank_fragment);

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
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);


            }
            catch(Exception e) {
                Log.d("My Debug", "SOME EXCEPTION" + e.getMessage());

            }


            return true;
        }
        return super.onOptionsItemSelected(item);
    }







}