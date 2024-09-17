package connect4.models;

import connect4.types.Color;
import utils.models.Coordinate;
import utils.models.Direction;

public class Board {

    private Color[][] colors;
    private Coordinate lastDrop;

    public Board() {
        assert Coordinate.NUMBER_ROWS > 0 && Coordinate.NUMBER_COLUMNS > 0;
        this.colors = new Color[Coordinate.NUMBER_ROWS][Coordinate.NUMBER_COLUMNS];
        this.reset();
    }

    public void reset() {
        assert Coordinate.NUMBER_ROWS > 0 && Coordinate.NUMBER_COLUMNS > 0;
        for (int i = 0; i < Coordinate.NUMBER_ROWS; i++) {
            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    public void dropToken(int column, Color color) {
        assert 0 <= column && column < Coordinate.NUMBER_COLUMNS;
        assert color != null;
        assert !this.isComplete(column);

        this.lastDrop = new Coordinate(0, column);
        while (!this.isEmpty(this.lastDrop)) {
            this.lastDrop = this.lastDrop.shifted(Direction.NORTH.getCoordinate());
        }
        this.colors[this.lastDrop.getRow()][this.lastDrop.getColumn()] = color;
    }

    public boolean isComplete(int column) {
        assert 0 <= column && column < Coordinate.NUMBER_COLUMNS;

        return !this.isEmpty(new Coordinate(Coordinate.NUMBER_ROWS - 1, column));

    }

    public boolean isComplete() {

        for (int i = 0; i < Coordinate.NUMBER_COLUMNS; i++) {
            if (!this.isComplete(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isFinished() {
        return this.isComplete() || this.isWinner();
    }

    public boolean isWinner() { // TODO me parece que el Board tiene demasiado conocimiento de como se implmenta
                                // line, analizar crear clase que integre a line y direction

        if (this.lastDrop == null ) {
            return false;
        }
        Line line = new Line(this.lastDrop);
        for (Direction direction : Direction.halfValues()) {
            line.set(direction);
            for (int i = 0; i < Line.LENGTH; i++) {
                if (this.isConnect4(line)) {
                    return true;
                }
                line.shiftOpposite();
            }
        }
        return false;
    }

    public boolean isConnect4(Line line) {
        assert line != null;

        Coordinate[] coordinates = line.getCoordinates();
        for (int i = 0; i < Line.LENGTH; i++) {
            if (!coordinates[i].isValid()) {
                return false;
            }
            if (!Color.isValid(this.getColor(coordinates[i]))) {
                return false;
            }
            if (i > 0 && this.getColor(coordinates[i - 1]) != this.getColor(coordinates[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isOccupied(Coordinate coordinate, Color color) {
        assert coordinate != null && color != null;

        return this.getColor(coordinate) == color;
    }

    public boolean isEmpty(Coordinate coordinate) {
        assert coordinate != null;
        return this.isOccupied(coordinate, Color.NULL);
    }

    public boolean isEmpty(int Column) {
        assert 0 <= Column && Column <= Coordinate.NUMBER_COLUMNS;
        return this.isEmpty(new Coordinate(0, Column));
    }

    public Color getColor(Coordinate coordinate) {
        assert coordinate != null;

        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    public Color getLastDropColor() {
        return this.getColor(this.lastDrop);
    }

    private void setColor(Coordinate coordinate, Color color) {
        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }

    public int[] getUncompletedColumns() {
        assert !this.isComplete();

        int numberImcopletedColumns = 0;
        for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
            if (!this.isComplete(j)) {
                numberImcopletedColumns++;
            }
        }
        int[] uncompletedColumns = new int[numberImcopletedColumns];
        int index = 0;
        for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
            if (!this.isComplete(j)) {
                uncompletedColumns[index] = j;
                index++;
            }
        }
        return uncompletedColumns;
    }

    public void removeTop(int column) {
        this.setColor(this.getTop(column), Color.NULL);
    }

    private Coordinate getTop(int column) {
        Coordinate coordinate = new Coordinate(Coordinate.NUMBER_ROWS - 1, column);
        while (this.isEmpty(coordinate)) {
            coordinate = coordinate.shifted(Direction.SOUTH.getCoordinate());
            //coordinate = Direction.SOUTH.next(coordinate);
        }
        return coordinate;
    }
}
