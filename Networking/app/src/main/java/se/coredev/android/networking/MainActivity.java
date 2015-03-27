package se.coredev.android.networking;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
{
    private TextView mResultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResultTextView = (TextView) findViewById(R.id.result_text_view);
    }

    public void startDownload(View view)
    {
        new DownloaderTask(mResultTextView).execute("http://www.google.se");
    }
}
