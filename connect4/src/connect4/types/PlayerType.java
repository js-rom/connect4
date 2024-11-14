package connect4.types;

public enum PlayerType {
    USER_PLAYER("User player"),
    RANDOM_MACHINE_PLAYER("Random player"),
    MIN_MAX_MACHINE_PLAYER("IA player");

    private String name;

    private PlayerType(String name) {
        this.name = name;
    }
    public String toString() {
        return this.name;
    }
}
