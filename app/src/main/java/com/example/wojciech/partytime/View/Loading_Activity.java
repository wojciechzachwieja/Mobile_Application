package com.example.wojciech.partytime.View;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;

import com.example.wojciech.partytime.Model.MyListAdapter;
import com.example.wojciech.partytime.R;

public class Loading_Activity extends Activity
{

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        //Initialize a LoadViewTask object and call the execute() method
        new LoadViewTask(this).execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loading, menu);
        return true;
    }
    //To use the AsyncTask, it must be subclassed
    private static class  LoadViewTask extends AsyncTask<Void, Integer, Void>
    {
        private Activity activity;
        //Before running code in separate thread

        public LoadViewTask(Activity activity) {
            this.activity = activity;
        }


        //The code to be executed in a background thread.
        @Override
        protected Void doInBackground(Void... params)
        {
            MyListAdapter.setRestaurants();
            return null;
        }

        //after executing the code in the thread
        @Override
        protected void onPostExecute(Void result)
        {
            //close the progress dialog
            activity.setResult(Activity.RESULT_OK);
            Intent intent = new Intent(activity,MainActivity.class);
            activity.startActivity(intent);
            activity.finish();
        }
    }
}
