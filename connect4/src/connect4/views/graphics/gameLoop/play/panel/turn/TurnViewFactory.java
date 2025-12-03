package connect4.views.graphics.gameLoop.play.panel.turn;

import connect4.controllers.core.PlayController;
import connect4.views.graphics.gameLoop.play.panel.commands.Command;

public class TurnViewFactory {

    private PlayController playController;
    private Command undoMachinePlayerCommand;
    private Command redoMachinePlayerCommand;
    private Command undoUserPlayerCommand;
    private Command redoUserPlayerCommand;

    public TurnViewFactory(PlayController playController) {
        this.playController = playController;
    }

    public TurnView createMachineTurnView() {
        TurnView turnView = new TurnView(playController);
        turnView.setUndoCommand(this.undoMachinePlayerCommand);
        turnView.setRedoComand(this.redoMachinePlayerCommand);
        return turnView;
    }

    public TurnView createUserTurnView() {
        TurnView turnView = new TurnView(playController);
        turnView.setUndoCommand(this.undoUserPlayerCommand);
        turnView.setRedoComand(this.redoUserPlayerCommand);
        return turnView;
    }

    public void setUndoMachinePlayerCommand(Command undoMachinePlayerCommand) {
        this.undoMachinePlayerCommand = undoMachinePlayerCommand;
    }

    public void setRedoMachinePlayerCommand(Command redoMachinePlayerCommand) {
        this.redoMachinePlayerCommand = redoMachinePlayerCommand;
    }

    public void setUndoUserPlayerCommand(Command undoUserPlayerCommand) {
        this.undoUserPlayerCommand = undoUserPlayerCommand;
    }

    public void setRedoUserPlayerCommand(Command redoUserPlayerCommand) {
        this.redoUserPlayerCommand = redoUserPlayerCommand;
    }

}
