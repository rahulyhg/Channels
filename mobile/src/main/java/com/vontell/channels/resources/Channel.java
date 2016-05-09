package com.vontell.channels.resources;

/**
 * Represents a channel in the users list of channels
 * @author Aaron Vontell
 */
public class Channel {

    private String name;
    private String identifier;
    private boolean enabled;

    /**
     * Creates a channel with the given name
     * @param name The name of the channel to show
     * @param identifier The unique identifier for this channel
     * @param enabled Whether or not this device has this channel enabled for notifications
     */
    public Channel(String name, String identifier, boolean enabled) {
        this.name = name;
        this.identifier = identifier;
        this.enabled = enabled;
    }

    /**
     * Retrieve the name of this channel
     * @return the channel name
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieve the unique identifier of this channel
     * @return the unique identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Retrieve whether this device is accepting notifications for this channel
     * @return whether this device is enabled
     */
    public boolean isEnabled() {
        return enabled;
    }
}
