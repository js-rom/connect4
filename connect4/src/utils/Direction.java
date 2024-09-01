package utils;

public enum Direction {

    NORTH(1, 0),
    NORTH_EAST(1, 1),
    EAST(0, 1),
    SOUTH_EAST(-1, 1),
    SOUTH(-1, 0),
    SOUTH_WEST(-1, -1),
    WEST(0, -1),
    NORTH_WEST(1, -1);

    private Coordinate coordinate;

    private Direction(int row, int column) {
        this.coordinate = new Coordinate(row, column);
    }

    public Direction getOpposite() {
        Direction opposite = null;
        for (Direction direction : Direction.values()) {
            if (direction.coordinate.shifted(this.coordinate).equals(Coordinate.ORIGIN)) {
                opposite = direction;
            }
        }
        return opposite;

    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public static Direction[] halfValues() {
        return new Direction[] {Direction.NORTH, Direction.NORTH_EAST, Direction.EAST, Direction.SOUTH_EAST};
    }


}
