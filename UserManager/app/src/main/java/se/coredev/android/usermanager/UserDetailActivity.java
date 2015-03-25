package se.coredev.android.usermanager;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public final class UserDetailActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_fragment_container_layout);

        String userId = getIntent().getStringExtra(UserDetailFragment.USER_DETAIL_ID_EXTRA);

        // Add UserDetailFragment
        FragmentManager manager = getFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.single_fragment_container);

        if(fragment == null)
        {
            manager.beginTransaction().add(R.id.single_fragment_container, UserDetailFragment.newInstance(userId)).commit();
        }
    }
}
