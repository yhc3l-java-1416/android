package se.coredev.android.usermanager;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public final class UserDetailFragment extends Fragment
{
    public static final String USER_DETAIL_ID_EXTRA = "user.detail.id.extra";

    private User mUser;

    public static UserDetailFragment newInstance(String userId)
    {
        UserDetailFragment userDetailFragment = new UserDetailFragment();

        Bundle args = new Bundle();
        args.putString(USER_DETAIL_ID_EXTRA, userId);
        userDetailFragment.setArguments(args);

        return userDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        String userId = getArguments().getString(USER_DETAIL_ID_EXTRA);
        mUser = UserStorage.getInstance(getActivity()).getUserById(userId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_user_detail, container, false);

        TextView idText = (TextView) view.findViewById(R.id.detail_user_id);
        TextView usernameText = (TextView) view.findViewById(R.id.detail_user_username);

        idText.setText(mUser.mId);
        usernameText.setText(mUser.mUsername);

        return view;
    }
}
