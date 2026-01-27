package com.jsrom.connect4.views.console.turn.player;

import com.jsrom.connect4.controllers.core.PlayController;
import com.jsrom.connect4.views.console.shared.Message;

import com.jsrom.utils.views.Console;

public abstract class MachinePlayerView extends PlayerView {
    private String title;

    public MachinePlayerView(PlayController playController ,String title) {
        super(playController);
        this.title = title;
    }

    public int getColumn() {
        int column = this.playController.getColumn();
        this.writeChoosenColumn(column);
        return column;
    }

    private void  writeChoosenColumn(int column) {
        String message = Message.CHOOSEN_COLUMN.toString();
        message = message.replace("#METHOD", this.title);
        message = message.replace("#COLUMN", String.valueOf(column + 1));
        Console.getInstance().writeln(message);
    };

    public void dropToken() {
        this.playController.dropToken(this.getColumn());
    }

}
