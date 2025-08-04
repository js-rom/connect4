package connect4.controllers.proxies;

import java.io.IOException;

import connect4.launchers.distributed.server.dispatchers.FrameType;
import connect4.types.Color;
import connect4.types.PlayerType;
import utils.models.Coordinate;
import utils.net.Client;
import connect4.models.Session;

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
        this.client.send(FrameType.UNDOABLE.name());
        boolean undoable = false;
        try {
            undoable = this.client.receiveBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return undoable;
    }

    @Override
    public void redo() {
        this.client.send(FrameType.REDO.name());
    }

    @Override
    public boolean redoable() {
        this.client.send(FrameType.REDOABLE.name());
        boolean redoable = false;
        try {
            redoable = this.client.receiveBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return redoable;
    }

    @Override
    public PlayerType getActivePlayerType() {
        this.client.send(FrameType.ACTIVE_PLAYER_TYPE.name());
        PlayerType playerType = null;
        try {
            playerType = this.client.receivePlayerType();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playerType;
    }

    @Override
    public Color getColor(Coordinate coordinate) {
        this.client.send(FrameType.COLOR.name());
        this.client.send(coordinate.getRow());
        this.client.send(coordinate.getColumn());
        Color color = null;
        try {
            color = this.client.receiveColor();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return color;
    }

    @Override
    public boolean isFinished() {
        this.client.send(FrameType.IS_FINISHED.name());
        boolean finished = false;
        try {
            finished = this.client.receiveBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return finished;
    }

    @Override
    public void next() {
        this.client.send(FrameType.NEXT.name());
    }

    @Override
    public void registerMemento() {
        this.client.send(FrameType.REGISTER_MEMENTO.name());
    }

    @Override
    public void dropToken(int column) {
        this.client.send(FrameType.DROP_TOKEN.name());
        this.client.send(column);
    }

    @Override
    public int getColumn() {
        this.client.send(FrameType.COLUMN.name());
        int column = 0;
        try {
            column = this.client.receiveInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return column;
    }

    @Override
    public boolean isWinner() {
        this.client.send(FrameType.IS_WINNER.name());
        boolean isWinner = false;
        try {
            isWinner = this.client.receiveBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isWinner;
    }

    @Override
    public boolean isComplete(int column) {
        this.client.send(FrameType.IS_COMPLETE.name());
        this.client.send(column);
        boolean isComplete = false;
        try {
            isComplete = this.client.receiveBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isComplete;
    }

    @Override
    public Color getActiveColor() {
        this.client.send(FrameType.ACTIVE_COLOR.name());
        Color activeColor = null;
        try {
            activeColor = this.client.receiveColor();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return activeColor;
    }

        public void nextState() {
        this.client.send(FrameType.PLAY_NEXT_STATE.name());
    }

}
