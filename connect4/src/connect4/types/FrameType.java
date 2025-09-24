package connect4.types;

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
    REGISTER_MEMENTO,
    DROP_TOKEN,
    COLUMN,
    IS_WINNER,
    IS_COMPLETE,
    START_NEXT_STATE,
    PLAY_NEXT_STATE,
    ACTIVE_COLOR,
    RESUME_NEXT_STATE,
    HAS_GAME_NAME,
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
