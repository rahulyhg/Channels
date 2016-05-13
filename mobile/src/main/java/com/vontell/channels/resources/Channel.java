package com.vontell.channels.resources;

/**
 * Represents a channel in the users list of channels
 * @author Aaron Vontell
 */
public class Channel {

    private String name;
    private String identifier;
    private int registered;
    private Long lastCalled;
    private boolean enabled;

    /**
     * Creates a channel with the given name
     * @param name The name of the channel to show
     * @param identifier The unique identifier for this channel
     * @param enabled Whether or not this device has this channel enabled for notification
     * @param lastCalled The last time, in milliseconds, since this channel was called
     * @param registered How many users are registered on this channel
     */
    public Channel(String name, String identifier, boolean enabled, Long lastCalled, int registered) {
        this.name = name;
        this.identifier = identifier;
        this.enabled = enabled;
        this.lastCalled = lastCalled;
        this.registered = registered;
    }

    /**
     * Retrieve the name of this channel
     * @return the channel name
     */
    public String getName() { return name; }

    /**
     * Retrieve the unique identifier of this channel
     * @return the unique identifier
     */
    public String getIdentifier() { return identifier; }

    /**
     * Retrieve whether this device is accepting notifications for this channel
     * @return whether this device is enabled
     */
    public boolean isEnabled() { return enabled; }

    /**
     * Retrieve the last time this channel was called since the epoch in milliseconds
     * @return the time in seconds
     */
    public Long getLastCalled() { return lastCalled; }

    /**
     * Retrieve how many users are registered on this channel
     * @return the number of users
     */
    public int getRegistered() { return registered; }

}
