package se.coredev.android.apiversion;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
        {
            TextView kitKatView = new TextView(this);
            kitKatView.setText("Hello KitKat!");
            setContentView(kitKatView);
        }
        else
        {
            TextView upgradeText = new TextView(this);
            upgradeText.setText("Time to upgrade!");
            setContentView(upgradeText);
        }

    }
}
