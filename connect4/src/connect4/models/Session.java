package connect4.models;

import connect4.types.Color;
import connect4.types.PlayerType;
import connect4.types.StateValue;
import utils.models.Coordinate;

public class Session {

    private State state;
    private Game game;
    private Registry registry;
    private String name;

    public Session() {
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(this.game);
    }

    public void undo() {
        this.registry.undo();
    }

    public boolean undoable() {
        return this.registry.undoable();
    }

    public void redo() {
        this.registry.redo();
    }

    public boolean redoable() {
        return this.registry.redoable();
    }

    public StateValue getValueState() {
        return this.state.getValueState();
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
        this.state.reset();
        this.registry.reset();
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
        this.register();
    }

    public void register() {
        this.registry.register();
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

    public boolean isComplete(int column) {
        return this.game.isComplete(column);
    }

    public boolean hasName() {
        return this.name != null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Game getGame() {
        return this.game;
    }
}
