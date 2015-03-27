package se.coredev.android.iondemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;


public class MainActivity extends ActionBarActivity
{
    private TextView mResultTextView;
    private static final String LOG_TAG = "MainActivity";
    private static final String sUrl = "http://public.api.hitta.se/autocomplete/v1/bil.json?what=30";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultTextView = (TextView) findViewById(R.id.content_text_view);
    }

    public void startDownload(View view)
    {
        Ion.with(this).load(sUrl).asString().setCallback(new FutureCallback<String>()
        {
            @Override
            public void onCompleted(Exception e, String result)
            {
                if(e == null)
                {
                    mResultTextView.setText(result);
                }
                else
                {
                    Log.e(LOG_TAG, "Could not fetch data", e);
                }
            }
        });

    }
}
