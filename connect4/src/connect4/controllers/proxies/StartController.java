package connect4.controllers.proxies;

import java.io.IOException;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

    @Override
    public boolean isReset() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isReset'");
    }

    @Override
    public void addPlayer(PlayerType playerType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPlayer'");
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
