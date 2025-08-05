package connect4.controllers.proxies;

import java.io.IOException;

import connect4.models.Session;
import connect4.types.Color;
import connect4.types.FrameType;
import connect4.net.Client;

public class ResumeController extends connect4.controllers.core.ResumeController {

    private Client client;

    public ResumeController(Session session, Client client) {
        super(session);
        this.client = client;
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
    public void reset() {
        this.client.send(FrameType.RESET.name());
    }

    public void nextState() {
        this.client.send(FrameType.RESUME_NEXT_STATE.name());
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
}
