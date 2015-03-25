package se.coredev.android.usermanager;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;


public class UserListActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_fragment_container_layout);

        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.single_fragment_container);

        if(fragment == null)
        {
            fragmentManager.beginTransaction().add(R.id.single_fragment_container, new UserListFragment()).commit();
        }
    }
}
