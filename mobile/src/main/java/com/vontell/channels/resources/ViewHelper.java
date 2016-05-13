package com.vontell.channels.resources;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.vontell.channels.R;

/**
 * Class with static methods to create and modify views
 */
public class ViewHelper {


    /**
     * Adds a channel view from the given channel to the channel layout
     * @param channel The channel to display
     * @param context The calling activity
     * @param channelsLayout The layout to place this view in
     */
    public static void addChannelView(Context context, Channel channel, ViewGroup channelsLayout) {

        // Inflate the default view
        LayoutInflater inflater = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View root = inflater.inflate(R.layout.channel_view, null);

        Log.d("DISP", "Created root: " + root);

        // Retrieve each field for modification
        TextView channelTitle = (TextView) root.findViewById(R.id.channel_title);
        TextView registeredCount = (TextView) root.findViewById(R.id.registered_view);
        Switch disabledSwitch = (Switch) root.findViewById(R.id.disable_switch);

        // Set each parameter
        channelTitle.setText(channel.getName());
        registeredCount.setText(Integer.toString(channel.getRegistered()));
        disabledSwitch.setChecked(channel.isEnabled());

        Resources r = context.getResources();
        float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, r.getDisplayMetrics());
        int px = (int) pixels;

        LinearLayout.LayoutParams params  = new LinearLayout.LayoutParams(channelsLayout.getLayoutParams());
        params.setMargins(px, px, px, px);
        channelsLayout.addView(root, params);

    }

    /**
     * Returns a list of fake channels for testing
     * @return The list of fake channels
     */
    public static Channel[] getTestChannels() {

        Channel[] channels = new Channel[8];

        channels[0] = new Channel("Hsin Hsin", "aadf", true, System.currentTimeMillis() - 10000, 5);
        channels[1] = new Channel("Dinner Time", "34562", true, System.currentTimeMillis() - 10000, 16);
        channels[2] = new Channel("Pizza Pizza", "35646345646", false, System.currentTimeMillis() - 10000, 3454);
        channels[3] = new Channel("Class Canceled", "fds", true, System.currentTimeMillis() - 10000, 5);
        channels[4] = new Channel("A really really long channel title for testing", "sjfggdujki", true, System.currentTimeMillis() - 10000, 45);
        channels[5] = new Channel("This is a time test", "safwe345sdf34", true, System.currentTimeMillis(), 11);
        channels[6] = new Channel("This is a time disabled", "dsf", false, System.currentTimeMillis(), 3);
        channels[7] = new Channel("A single user :(", "7683", true, System.currentTimeMillis() - 10000, 1);

        return channels;

    }

}
