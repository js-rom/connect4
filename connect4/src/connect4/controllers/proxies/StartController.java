package connect4.controllers.proxies;

import java.io.IOException;

import connect4.launchers.distributed.server.dispatchers.FrameType;
import connect4.models.Session;
import connect4.types.PlayerType;
import utils.tcpip.Client;

public class StartController extends connect4.controllers.core.StartController {

    private Client client;

    public StartController(Session session, Client client) {
        super(session);
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

    @Override
    public PlayerType getMinMaxMachinePlayerType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMinMaxMachinePlayerType'");
    }

    @Override
    public PlayerType getRandomMachinePlayerType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRandomMachinePlayerType'");
    }

    @Override
    public PlayerType getUserPlayerPlayerType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserPlayerPlayerType'");
    }

}
