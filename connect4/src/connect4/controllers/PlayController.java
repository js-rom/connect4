package connect4.controllers;

import connect4.models.Player;
import connect4.models.Session;
import connect4.types.Color;
import connect4.types.PlayerType;
import utils.models.Coordinate;

public class PlayController extends Controller implements AcceptorController{

    public PlayController(Session session) {
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

    public void dropToken(int Column) {
        this.session.dropToken(Column);
    }

    public int getColumn() {
        return this.session.getColumn();
    }

    public boolean isWinner() {
        return this.session.isWinner();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
       controllerVisitor.visit(this);
    }
    
}
