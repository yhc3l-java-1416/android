package se.coredev.android.asyncdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
{
    private TextView mCounterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCounterTextView = (TextView) findViewById(R.id.counter_text_view);
    }

    public void startCounter(View view)
    {
        CounterTask counterTask = new CounterTask(mCounterTextView);
        counterTask.execute();
    }
}
