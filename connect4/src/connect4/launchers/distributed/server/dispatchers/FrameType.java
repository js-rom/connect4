package connect4.launchers.distributed.server.dispatchers;

public enum FrameType {
    PLAYER_TYPES,
    NUMBRE_PPLAYERS,
    RESET,
    IS_RESET,
    ADD_PLAYER,
    UNDO,
    UNDOABLE,
    REDO,
    REDOABLE,
    ACTIVE_PLAYER_TYPE,
    COLOR,
    IS_FINISHED,
    NEXT,
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
