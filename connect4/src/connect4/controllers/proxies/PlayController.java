package connect4.controllers.proxies;

import connect4.launchers.distributed.server.dispatchers.FrameType;
import connect4.models.Player;
import connect4.types.Color;
import connect4.types.PlayerType;
import utils.models.Coordinate;
import utils.tcpip.Client;

public class PlayController extends connect4.controllers.core.PlayController {

    private Client client;

    public PlayController(Session session, Client client) {
        super(session);
        this.client = client;
    }

    @Override
    public void undo() {
        this.client.send(FrameType.UNDO.name());
    }

    @Override
    public boolean undoable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'undoable'");
    }

    @Override
    public void redo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'redo'");
    }

    @Override
    public boolean redoable() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'redoable'");
    }

    @Override
    public Player getActivePlayer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActivePlayer'");
    }

    @Override
    public PlayerType getActivePlayerType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActivePlayerType'");
    }

    @Override
    public Color getColor(Coordinate coordinate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getColor'");
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isFinished'");
    }

    @Override
    public void next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

    @Override
    public void registerMemento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registerMemento'");
    }

    @Override
    public void dropToken(int Column) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dropToken'");
    }

    @Override
    public int getColumn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getColumn'");
    }

    @Override
    public boolean isWinner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isWinner'");
    }

    @Override
    public boolean isComplete(int column) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isComplete'");
    }

}
