package connect4.controllers;

import connect4.models.Game;
import connect4.models.Player;
import connect4.types.Color;
import connect4.types.PlayerType;
import utils.models.Coordinate;

public class Logic {

    private Game game;
    private StartController startController;
    private PlayController playController;
    private ResumeController resumeController;

    public Logic(Game game) {
        this.game = game;
        this.startController = new StartController(this.game);
        this.playController = new PlayController(this.game);
        this.resumeController = new ResumeController(this.game);
    }

    public boolean isWinner() {
        return this.resumeController.isWinner();
    }

    public Color getActiveColor() {
        return this.resumeController.getActiveColor();
    }

    public PlayerType[] getPlayerTypes() {
        return this.startController.getPlayerTypes();
    }

    public int getNumberPlayers() {
        return this.startController.getNumberPlayers();
    }

    public void reset() {
        this.startController.reset();
    }

    public void addPlayer(PlayerType playerType) {
        this.startController.addPlayer(playerType);
    }

    public Color getColor(Coordinate coordinate) {
        return this.playController.getColor(coordinate);
    }

    public boolean isFinished() {
        return this.playController.isFinished();
    }

    public Player getActivePlayer() {
        return this.playController.getActivePlayer();
    }

    public void dropToken(int Column) {
        this.playController.dropToken(Column);
    }

    public void next() {
        this.playController.next();
    }

    public int getColumn() {
        return playController.getColumn();
    }

    public PlayerType getActivePlayerType() {
        return this.playController.getActivePlayerType();
    }

    public boolean isReset() {
        return this.startController.isReset();
    }

    public PlayerType getMinMaxMachinePlayerType() {
        return this.startController.getMinMaxMachinePlayerType();
    }

    public PlayerType getRandomMachinePlayerType() {
        return this.startController.getRandomMachinePlayerType();
    }

    public PlayerType getUserPlayerPlayerType() {
        return this.startController.getUserPlayerPlayerType();
    }
}
