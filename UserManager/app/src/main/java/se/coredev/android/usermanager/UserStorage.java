package se.coredev.android.usermanager;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UserStorage
{
    private static UserStorage INSTANCE;
    private final Map<String, User> mUsers;
    private final Context mContext;

    private UserStorage(Context context)
    {
        mUsers = new HashMap<>();
        mContext = context;

        populateFakeData();
    }

    private void populateFakeData()
    {
        for(int i = 1; i < 101; i++)
        {
            User user = new User("User " + i);
            mUsers.put(user.mId, user);
        }
    }

    public static UserStorage getInstance(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = new UserStorage(context.getApplicationContext());
        }
        return INSTANCE;
    }

    public User getUserById(String userId)
    {
        return mUsers.get(userId);
    }

    public List<User> getUsers()
    {
        return new ArrayList<User>(mUsers.values());
    }
}










