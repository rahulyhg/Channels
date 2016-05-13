package com.vontell.channels;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.vontell.channels.resources.Channel;
import com.vontell.channels.resources.ViewHelper;

public class MainActivity extends AppCompatActivity {

    private LinearLayout channelsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewChannel();
            }
        });

        // Load the view that will hold all channels
        channelsLayout = (LinearLayout) findViewById(R.id.channels_layout);

        // Load and show all channels
        showChannels();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Displays all channels this user wants
     */
    private void showChannels() {

        Channel[] channels = ViewHelper.getTestChannels();

        for(Channel channel : channels) {
            Log.d("DISP", "Showing channel \'" + channel.getName() + "\'");
            ViewHelper.addChannelView(this, channel, (LinearLayout) findViewById(R.id.channels_layout));
        }

    }

    /**
     * Opens a dialog to create a new channel on the backend
     */
    private void createNewChannel() {

        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.coordinator), "You created a channel!", Snackbar.LENGTH_SHORT);

        snackbar.show();

    }

}
