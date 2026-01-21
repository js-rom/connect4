package com.jsrom.connect4.controllers.core;

import com.jsrom.connect4.models.Session;
import com.jsrom.connect4.types.PlayerType;

public abstract class StartController extends Controller implements AcceptorController {

    public StartController(Session session) {
        super(session);
    }

    public StartController() {

    }

    public abstract void start();

    public abstract void start(String gameName);

    public abstract PlayerType[] getPlayerTypes();

    public abstract int getNumberPlayers();

    public abstract void reset();

    public abstract boolean isReset();

    public abstract void addPlayer(PlayerType playerType);

    public abstract String[] getGameNames();

    public abstract boolean hasSavedGames();

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }

}
