package connect4.launchers.distributed.dispatchers;

public enum FrameType {
    PLAYER_TYPES,
    STATE,
    CLOSE;

    public static FrameType parser(String string) {
        for (FrameType frameType : FrameType.values()) {
            if (frameType.name().equals(string)) {
                return frameType;
            }
        }
        return null;
    }
}
