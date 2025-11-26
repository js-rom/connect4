package connect4.launchers.distributed.server.dispatchers;

import java.io.IOException;

import connect4.controllers.implementation.PlayController;
import utils.models.Coordinate;

public class Color extends Dispatcher {

    public Color(PlayController playController) {
        super(playController);
    }

    @Override
    public void dispatch() {
        int row = 0;
        int column = 0;
        try {
            row = this.server.receiveInt();
            column = this.server.receiveInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Coordinate coordinate = new Coordinate(row, column);
        connect4.types.Color color = ((PlayController) this.acceptorController).getColor(coordinate);
        this.server.send(color);
    }

}
