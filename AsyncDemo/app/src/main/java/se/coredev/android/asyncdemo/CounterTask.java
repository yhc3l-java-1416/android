package se.coredev.android.asyncdemo;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.TextView;

public final class CounterTask extends AsyncTask<Void, Integer, Integer>
{
    private final TextView mCounterTextView;

    public CounterTask(TextView counterTextView)
    {
        mCounterTextView = counterTextView;
    }

    @Override
    protected Integer doInBackground(Void... params)
    {
        int counter = 0;

        while (counter < 100)
        {
            SystemClock.sleep(250);
            counter++;

            if (counter % 5 == 0)
            {
                publishProgress(counter);
            }
        }

        return counter;
    }

    @Override
    protected void onProgressUpdate(Integer... progress)
    {
        mCounterTextView.setText(progress[0] + "% completed");
    }

    @Override
    protected void onPostExecute(Integer result)
    {
        mCounterTextView.setText("Count to " + result + " completed");
    }
}










