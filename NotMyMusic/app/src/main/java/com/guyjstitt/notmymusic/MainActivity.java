package com.guyjstitt.notmymusic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.guyjstitt.notmymusic.fragment.MainFragment;
import com.guyjstitt.notmymusic.fragment.SearchFragment;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment frag = new MainFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container,frag,"GuyFragment");
        transaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:NavUtils.navigateUpFromSameTask(this);return true;
            case R.id.action_settings: settings(); return true;
            case R.id.action_search: search(); return true;
            case R.id.action_add: add(); return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void add() {
       startActivity(new Intent(getApplicationContext(), AddActivity.class));
    }

    private void search() {
        SearchFragment frag = new SearchFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container,frag,"SearchFrag");
        transaction.commit();

    }

    private void settings() {
        Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
        toast.show();
    }

}
