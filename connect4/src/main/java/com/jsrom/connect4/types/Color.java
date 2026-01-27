package com.jsrom.connect4.types;

import java.util.Objects;

public enum Color {

    RED("Red"),
    YELLOW("Yellow"),
    NULL(" ");

    private String description;
    private static Color[] PLAYERS = { Color.RED, Color.YELLOW };

    private Color(String color) {
        this.description = color;
    }

    public static Color get(int ordinal) {
        return Color.values()[ordinal];
    }

    public static Color get(String description) {
        for (Color color : Color.values()) {
            if (Objects.equals(color.description, description)) {
                return color;
            }
        }
        return Color.NULL;
    }

    public String toString() {
        return this.description;
    }

    public Color getOpposite() {
        return Color.values()[(this.ordinal() + 1) % Color.PLAYERS.length];
    }

    public static boolean isValid(Color color) {
        return color != Color.NULL;
    }
}
