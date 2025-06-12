package connect4.models;

import connect4.types.Color;
import connect4.types.PlayerType;
import utils.models.Coordinate;

public class Session {

    private State state;
    private Game game;
    private Registry registry;

    public Session() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(this.game);
    }

    public void nextState() {
        this.state.next();
    }

    public Color getActiveColor() {
        return this.game.getActiveColor();
    }

    public Color getColor(Coordinate coordinate) {
        return this.game.getColor(coordinate);
    }

        public int getNumberPlayers() {
        return this.game.getNumberPlayers();
    }

    public void reset() {
        this.game.reset();
    }

    public boolean isReset() {
        return this.game.isReset();
    }

    public void addPlayer(PlayerType playerType) {
        this.game.addPlayer(playerType);
    }

        public Player getActivePlayer() {
        return this.game.getActivePlayer();
    }

    public PlayerType getActivePlayerType() {
        return this.game.getActivePlayerType();
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

    public boolean isWinner() {
        return this.game.isWinner();
    }
}
