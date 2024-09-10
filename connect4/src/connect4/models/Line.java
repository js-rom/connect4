package connect4.models;

import utils.Direction;
import utils.Coordinate;

public class Line {

    public static final int LENGTH = 4;
    private Coordinate origin;
    private Coordinate[] coordinates;
    private Direction oppositeDirection;

    public Line(Coordinate coordinate) {
        assert coordinate != null;

        this.origin = coordinate;
        this.coordinates = new Coordinate[Line.LENGTH];
    }

    public void set(Direction direction) {
        assert direction != null;

        this.coordinates[0] = this.origin;
        for (int i = 1; i < Line.LENGTH; i++) {
            this.coordinates[i] = this.coordinates[i - 1].shifted(direction.getCoordinate());
        }
        this.oppositeDirection = direction.getOpposite();
    }

    public void shiftOpposite() {
        for (int i = 0; i < Line.LENGTH; i++) {
            this.coordinates[i] = this.coordinates[i].shifted(this.oppositeDirection.getCoordinate());
        }
    }

    public Coordinate[] getCoordinates() {
        return this.coordinates;
    }
}
