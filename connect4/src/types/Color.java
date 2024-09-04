package types;

public enum Color {

    RED("Red"),
    YELLOW("Yellow"),
    NULL(" ");

    private String color;
    private static Color[] PLAYERS = {Color.RED, Color.YELLOW};

    private Color(String color) {
        this.color = color;
    }

    public static Color get(int ordinal) {
        return Color.values()[ordinal];
    }

    public String toString() {
        return this.color;
    }

    public Color getOpposite() {
        return Color.values()[(this.ordinal() + 1) % Color.PLAYERS.length];
    }

    public static boolean isValid(Color color) {
        return color != Color.NULL;
    }
}
