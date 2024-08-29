package models;

public class Board {

    private Color[][] colors;
    private Coordinate lastDrop;

    public Board() {
        this.colors = new Color[Coordinate.NUMBER_ROWS][Coordinate.NUMBER_COLUMNS];
        /*
         * for (int i = 0; i < Coordinate.NUMBER_ROWS; i++) {
         * this.colors[i] = new Color[Coordinate.NUMBER_COLUMNS];
         * }
         */
        this.reset();
    }

    public void reset() {

        for (int i = 0; i < Coordinate.NUMBER_ROWS; i++) {
            for (int j = 0; j < Coordinate.NUMBER_COLUMNS; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    public void dropToken(int column, Color color) {

        this.lastDrop = new Coordinate(0, column);
        while (!this.isEmpty(this.lastDrop)) {
            this.lastDrop = this.lastDrop.shifted(Direction.NORTH.getCoordinate());
        }
        this.colors[this.lastDrop.getRow()][this.lastDrop.getColumn()] = color;
    }

    public boolean isComplete(int column) {

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

    public boolean isWinner() { //TODO
        if (this.lastDrop == null) {
            return false;
        }
        Line line = new Line(this.lastDrop);
        for (let direction of Direction.values().splice(0, 3)) {
            line.set(direction);
            for (let i = 0; i < Line.LENGTH; i++) {
                if (this.isConnect4(line)) {
                    return true;
                }
                line.shift();
            }
        }
        return false;
    }

    public boolean isConnect4(Line line) {
        Coordinate[] coordinates = line.getCoordinates();
        for (int i = 0; i < Line.LENGTH; i++) {
            if (!coordinates[i].isValid()) {
                return false;
            }
            if (i > 0 && this.getColor(coordinates[i - 1]) != this.getColor(coordinates[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isOccupied(Coordinate coordinate, Color color) {
        return this.getColor(coordinate) == color;
    }

    public boolean isEmpty(Coordinate coordinate) {
        return this.isOccupied(coordinate, Color.NULL);
    }

    public Color getColor(Coordinate coordinate) {
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }
}
