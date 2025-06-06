package connect4.controllers;

import connect4.models.Game;
import connect4.types.Color;
import utils.models.Coordinate;

public abstract class Controller {

    protected Game game;

    Controller(Game game) {
        this.game = game;
    }

    public Color getActiveColor() {
        return this.game.getActiveColor();
    }

    public Color getColor(Coordinate coordinate) {

        return this.game.getColor(coordinate);

    }
}
