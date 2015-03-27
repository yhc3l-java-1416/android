package se.coredev.filetest;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UserStorage
{
    private static final String fileName = "users.data";
    private static final String LOG_TAG = "UserStorage";
    private static UserStorage INSTANCE;

    private Context mContext;
    private Map<String, User> mUsers;

    public static UserStorage getInstance(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = new UserStorage(context);
        }
        return INSTANCE;
    }

    private UserStorage(Context context)
    {
        mContext = context;
        mUsers = new HashMap<>();
    }

    public void addFakeData()
    {
        for (int i = 0; i < 100; i++)
        {
            User user = new User("User " + i);
            mUsers.put(user.mId, user);
        }
    }

    public User getUserById(String id)
    {
        return mUsers.get(id);
    }

    public List<User> getUsers()
    {
        return new ArrayList<>(mUsers.values());
    }

    public boolean persist()
    {
        BufferedWriter writer = null;

        try
        {
            OutputStream out = mContext.openFileOutput(fileName, Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));

            JSONArray usersJson = new JSONArray();

            for (User user : mUsers.values())
            {
                usersJson.put(User.toJson(user));
            }

            writer.write(usersJson.toString());

            return true;
        } catch (FileNotFoundException e)
        {
            Log.e(LOG_TAG, "Could not persist UserStorage", e);
            return false;
        } catch (IOException e)
        {
            Log.e(LOG_TAG, "Could not persist UserStorage", e);
            return false;
        } catch (JSONException e)
        {
            Log.e(LOG_TAG, "Could not persist UserStorage", e);
            return false;
        } finally
        {
            close(writer);
        }
    }

    public boolean restore()
    {
        BufferedReader reader = null;

        try
        {
            InputStream in = mContext.openFileInput(fileName);
            reader = new BufferedReader(new InputStreamReader(in));

            StringBuilder data = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null)
            {
                data.append(line);
            }

            JSONArray usersJson = (JSONArray) new JSONTokener(data.toString()).nextValue();

            for (int i = 0; i < usersJson.length(); i++)
            {
                JSONObject jsonUser = usersJson.getJSONObject(i);
                User user = User.fromJson(jsonUser);
                mUsers.put(user.mId, user);
            }

            return true;
        } catch (FileNotFoundException e)
        {
            Log.w(LOG_TAG, "Could not restore UserStorage", e);
            return false;
        } catch (IOException e)
        {
            Log.e(LOG_TAG, "Could not restore UserStorage", e);
            return false;
        } catch (JSONException e)
        {
            Log.e(LOG_TAG, "Could not restore UserStorage", e);
            return false;
        }
    }

    private void close(Closeable closeable)
    {
        if (closeable == null)
        {
            return;
        }

        try
        {
            closeable.close();
        } catch (IOException e)
        {
            Log.e(LOG_TAG, "Could not close closeable");
        }
    }
}
