package com.guyjstitt.tutorial;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.PushService;

public class MainActivity extends FragmentActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(this, "MIXukOTE1J7E3LVcQl7nvopw2ZWfpW7QysycyjAe", "HFCWrW8JBT62iqX95KBspuUYMeNSa0cMUG4YLUb3");
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

        PushService.setDefaultPushCallback(this, MainActivity.class);

        FormFragment frag = new FormFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container,frag,"Form Frag");
        transaction.commit();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //broadcast custom intent
    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("com.guyjstitt.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
