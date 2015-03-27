package se.coredev.android.networking;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class DownloaderTask extends AsyncTask<String, Void, String>
{
    private static final String LOG_TAG = "DownloaderTask";
    private final TextView mResultTextView;

    public DownloaderTask(TextView resultTextView)
    {
        mResultTextView = resultTextView;
    }

    @Override
    protected String doInBackground(String... params)
    {
        BufferedReader reader = null;
        StringBuilder result = new StringBuilder();

        try
        {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null)
            {
                result.append(line);
            }

        } catch (MalformedURLException e)
        {
            Log.e(LOG_TAG, "Could not start download", e);
        } catch (IOException e)
        {
            Log.e(LOG_TAG, "Could not start download", e);
        } finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                } catch (IOException e)
                {
                    Log.e(LOG_TAG, "Could not close stream", e);
                }
            }
        }

        return result.toString();
    }

    @Override
    protected void onPostExecute(String result)
    {
        mResultTextView.setText(result);
    }
}
















