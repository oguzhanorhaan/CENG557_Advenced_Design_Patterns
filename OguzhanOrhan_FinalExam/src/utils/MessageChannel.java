package utils;

public enum MessageChannel {
    TEMPERATURE  ("TEMPERATURE"),
    LIGHT ("LIGHT"),
    WATER ("WATER"),
    SMOKE ("SMOKE"),
    PRESENCE ("PRESENCE"),
    GLASS("GLASS"),
    MOTION("MOTION")
    ;


    private final String channel;

    private MessageChannel(String channel) {
        this.channel = channel;
    }

    public String getValue() {
        return this.channel;
    }
}
