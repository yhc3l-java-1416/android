package se.coredev.android.usermanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public final class UserListAdapter extends ArrayAdapter<User>
{
    public UserListAdapter(Context context, List<User> users)
    {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_user_simple, null);
        }

        TextView idText = (TextView) convertView.findViewById(R.id.list_item_user_id);
        TextView usernameText = (TextView) convertView.findViewById(R.id.list_item_user_username);

        User user = getItem(position);

        idText.setText(user.mId);
        usernameText.setText(user.mUsername);

        return convertView;
    }
}








