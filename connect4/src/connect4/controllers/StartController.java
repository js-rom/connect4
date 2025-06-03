package connect4.controllers;

import connect4.models.Game;
import connect4.types.PlayerType;

public class StartController extends Controller {

    public StartController(Game game) {

        super(game);

    }

    public PlayerType[] getPlayerTypes() {
        return PlayerType.values();
    }

    public int getNumberPlayers() {
        return  this.game.getNumberPlayers();
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

    public PlayerType getMinMaxMachinePlayerType() {
        return PlayerType.MIN_MAX_MACHINE_PLAYER;
    }

    public PlayerType getRandomMachinePlayerType() {
        return PlayerType.RANDOM_MACHINE_PLAYER;
    }

    public PlayerType getUserPlayerPlayerType() {
        return PlayerType.USER_PLAYER;
    }

}
