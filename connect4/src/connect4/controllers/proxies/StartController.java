package connect4.controllers.proxies;

import java.io.IOException;

import connect4.types.FrameType;
import connect4.types.PlayerType;
import connect4.net.Client;

public class StartController extends connect4.controllers.core.StartController {

    private Client client;

    public StartController(Client client) {
        this.client = client;
    }

    @Override
    public PlayerType[] getPlayerTypes() {
        this.client.send(FrameType.PLAYER_TYPES.name());
        PlayerType[] playerTypes = null;
        try {
            playerTypes = this.client.receivePlayerTypes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playerTypes;
    }

    @Override
    public int getNumberPlayers() {
        this.client.send(FrameType.NUMBRE_PPLAYERS.name());
        int numberPlayers = 0;
        try {
            numberPlayers = this.client.receiveInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberPlayers;
    }

    @Override
    public void reset() {
        this.client.send(FrameType.RESET.name());
    }

    @Override
    public boolean isReset() {
        this.client.send(FrameType.IS_RESET.name());
        boolean isReset = false;
        try {
            isReset = this.client.receiveBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isReset;
    }

    @Override
    public void addPlayer(PlayerType playerType) {
        this.client.send(FrameType.ADD_PLAYER.name());
        this.client.send(playerType);
    }

    public void nextState() {
        this.client.send(FrameType.START_NEXT_STATE.name());
    }

    @Override
    public void start() {
        // TODO
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    @Override
    public void start(String gameName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    @Override
    public String[] getGameNames() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGameNames'");
    }

    @Override
    public boolean hasSavedGames() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasSavedGames'");
    }

}
