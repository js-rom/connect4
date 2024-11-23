package connect4.controllers;

import connect4.models.Game;
import connect4.models.MachinePlayer;
import connect4.models.Player;
import connect4.types.Color;
import connect4.types.PlayerType;
import utils.models.Coordinate;

public class PlayController extends Controller {

    public PlayController(Game game) {
        super(game);
    }

    public Player getActivePlayer() {
        return this.game.getActivePlayer();
    }

    public PlayerType getActivePlayerType() {
        return this.game.getActivePlayerType();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

    public boolean isFinished() {
        return this.game.isFinished();
    }

    public void next() {
        this.game.next();
    }

    public void dropToken(int Column) {
        this.getActivePlayer().dropToken(Column);
    }

    public int getColumn() {
        MachinePlayer machinePlayer = (MachinePlayer) this.getActivePlayer();
        return machinePlayer.getColumn();
    }

}
