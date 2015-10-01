package com.example.wojciech.partytime;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;

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
            /* This is just a code that delays the thread execution 4 times,
             * during 850 milliseconds and updates the current progress. This
             * is where the code that is going to be executed on a background
             * thread must be placed.
             */
//            try
//            {
//                //Get the current thread's token
//                synchronized (this)
//                {
//                    //Initialize an integer (that will act as a counter) to zero
//                    int counter = 0;
//                    //While the counter is smaller than four
//                    while(counter <= 4)
//                    {
//                        //Wait 850 milliseconds
//                        this.wait(850);
//                        //Increment the counter
//                        counter++;
//                        //Set the current progress.
//                        //This value is going to be passed to the onProgressUpdate() method.
//                        publishProgress(counter*25);
//                    }
//                }
//            }
//            catch (InterruptedException e)
//            {
//                e.printStackTrace();
//            }
            MyListAdapter.setRestaurants();
            return null;
        }

        //after executing the code in the thread
        @Override
        protected void onPostExecute(Void result)
        {
            //close the progress dialog
            activity.setResult(Activity.RESULT_OK);
            activity.finish();
        }
    }


}
