package se.coredev.filetest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;


public class MainActivity extends ActionBarActivity
{
    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restoreStorage();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        persistStorage();
    }

    public void addFake(View view)
    {
        UserStorage.getInstance(this).addFakeData();
        Log.d(LOG_TAG, "Added fake data. Current size:" + UserStorage.getInstance(this).getUsers().size());
    }

    public void persist(View view)
    {
        persistStorage();
    }

    public void restore(View view)
    {
        restoreStorage();
    }

    public void showSize(View view)
    {
        Log.d(LOG_TAG, "Current size:" + UserStorage.getInstance(this).getUsers().size());
    }

    private void persistStorage()
    {
        UserStorage.getInstance(this).persist();
        Log.d(LOG_TAG, "Restored storage. Current size:" + UserStorage.getInstance(this).getUsers().size());
    }

    private void restoreStorage()
    {
        UserStorage.getInstance(this).restore();
        Log.d(LOG_TAG, "Persisted storage Current size:" + UserStorage.getInstance(this).getUsers().size());
    }
}
