package main.java.com.jsrom.connect4.controllers.implementation;

import main.java.com.jsrom.connect4.controllers.core.Controller;
import main.java.com.jsrom.connect4.models.Player;
import main.java.com.jsrom.connect4.models.Session;
import main.java.com.jsrom.connect4.types.Color;
import main.java.com.jsrom.connect4.types.PlayerType;

import main.java.com.jsrom.utils.models.Coordinate;

public class ActionContoller extends Controller {

    ActionContoller(Session session) {
        super(session);
    }

     public Player getActivePlayer() {
        return this.session.getActivePlayer();
    }

    public PlayerType getActivePlayerType() {
        return this.session.getActivePlayerType();
    }

    public Color getColor(Coordinate coordinate) {
        return this.session.getColor(coordinate);
    }

    public boolean isFinished() {
        return this.session.isFinished();
    }

    public void next() {
        this.session.next();
    }

    public void registerMemento() {
        this.session.register();
    }

    public void dropToken(int Column) {
        this.session.dropToken(Column);
    }

    public int getColumn() {
        return this.session.getColumn();
    }

    public boolean isWinner() {
        return this.session.isWinner();
    }

    public boolean isComplete(int column) {
        return this.session.isComplete(column);
    }

}
