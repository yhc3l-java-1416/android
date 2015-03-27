package se.coredev.filetest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public final class User
{
    private static final String JSON_ID = "id";
    private static final String JSON_USERNAME = "username";

    public final String mId;
    public final String mUsername;

    public User(String username)
    {
        this(UUID.randomUUID().toString(), username);
    }

    private User(String id, String username)
    {
        mId = id;
        mUsername = username;
    }

    public static User fromJson(JSONObject json) throws JSONException
    {
        return new User(json.getString(JSON_ID), json.getString(JSON_USERNAME));
    }

    public static JSONObject toJson(User user) throws JSONException
    {
        JSONObject userJson = new JSONObject();
        userJson.put(JSON_ID, user.mId);
        userJson.put(JSON_USERNAME, user.mUsername);

        return userJson;
    }
}







