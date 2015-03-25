package se.coredev.android.usermanager;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public final class UserListFragment extends ListFragment
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        List<User> users = UserStorage.getInstance(getActivity()).getUsers();
        UserListAdapter userListAdapter = new UserListAdapter(getActivity(), users);

        setListAdapter(userListAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        User user = (User) getListAdapter().getItem(position);
        Intent intent = new Intent(getActivity(), UserDetailActivity.class);

        intent.putExtra(UserDetailFragment.USER_DETAIL_ID_EXTRA, user.mId);

        startActivity(intent);
    }
}






