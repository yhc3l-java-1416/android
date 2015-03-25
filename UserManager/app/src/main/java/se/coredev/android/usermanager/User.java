package se.coredev.android.usermanager;

import java.util.UUID;

public final class User
{
    public final String mId;
    public final String mUsername;

    public User(String username)
    {
        mId = UUID.randomUUID().toString();
        mUsername = username;
    }
}
