package se.coredev.android.friday;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity
{
    public static final String EXTRA_MESSAGE = "se.coredev.android.friday.EXTRA_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        EditText editText = (EditText) findViewById(R.id.edit_message);
//
//        editText.setOnEditorActionListener(new TextView.OnEditorActionListener()
//        {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
//            {
//                if (actionId == EditorInfo.IME_ACTION_DONE)
//                {
//                    Toast.makeText(v.getContext(), v.getText(), Toast.LENGTH_SHORT).show();
//                    hideKeyboard(v.getWindowToken());
//                    return true;
//                }
//
//                return false;
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.action_settings)
        {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.action_reload)
        {
            Toast.makeText(this, "Reload", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    private void hideKeyboard(IBinder binder)
    {
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(binder, 0);
    }

    public void showMessage(View view)
    {
        EditText editText = (EditText) findViewById(R.id.edit_message);

        Intent intent = new Intent(this, ShowMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, editText.getText().toString());

        startActivity(intent);
    }
}




































