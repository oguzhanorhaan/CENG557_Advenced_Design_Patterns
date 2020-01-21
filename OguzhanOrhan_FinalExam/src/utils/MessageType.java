package utils;

public enum MessageType {
    CRITIC ("CRITIC"),
    NOT_CRITIC ("NOT CRITIC");


    private final String type;

    private MessageType(String channel) {
        this.type = channel;
    }

    public String getValue() {
        return this.type;
    }
}
