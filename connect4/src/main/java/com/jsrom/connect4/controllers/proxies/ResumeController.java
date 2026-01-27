package com.jsrom.connect4.controllers.proxies;

import java.io.IOException;

import com.jsrom.connect4.net.Client;
import com.jsrom.connect4.types.Color;
import com.jsrom.connect4.types.FrameType;

public class ResumeController extends com.jsrom.connect4.controllers.core.ResumeController {

    private Client client;

    public ResumeController(Client client) {
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
