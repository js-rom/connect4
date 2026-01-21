package main.java.com.jsrom.connect4.controllers.core;

import main.java.com.jsrom.connect4.models.Session;
import main.java.com.jsrom.connect4.types.Color;
import main.java.com.jsrom.connect4.types.StateValue;

import main.java.com.jsrom.utils.models.Coordinate;

public abstract class Controller {

    protected Session session;

    public Controller(Session session) {
        this.session = session;
    }

    public Controller() {

    }

    public void nextState() {
        this.session.nextState();
    }

    public StateValue getValueState() {
        return this.session.getValueState();
    }

    public Color getActiveColor() {
        return this.session.getActiveColor();
    }

    public Color getColor(Coordinate coordinate) {
        return this.session.getColor(coordinate);
    }

}
