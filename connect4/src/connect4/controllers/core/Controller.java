package connect4.controllers.core;

import connect4.models.Session;
import connect4.types.Color;
import utils.models.Coordinate;

public abstract class Controller {

    protected Session session;

    public Controller(Session session) {
        this.session = session;
    }

    public void nextState() {
        this.session.nextState();
    }

    public Color getActiveColor() {
        return this.session.getActiveColor();
    }

    public Color getColor(Coordinate coordinate) {

        return this.session.getColor(coordinate);

    }
    
}
