package types;

public enum Color {

    RED("Red"),
    YELLOW("Yellow"),
    NULL(" ");

    private String color;

    private Color(String color) {
        this.color = color;
    }

    public static Color get(int ordinal) {
        return Color.values()[ordinal];
    }

    public String toString() {
        return this.color;
    }
}
