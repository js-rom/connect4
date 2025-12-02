package connect4.views.graphics.gameLoop.play;

import connect4.controllers.core.PlayController;
import connect4.views.graphics.gameLoop.play.commands.PlayPanelViewVisitor;
import connect4.views.graphics.gameLoop.play.commands.RedoMachinePlayerCommand;
import connect4.views.graphics.gameLoop.play.commands.RedoUserPlayerCommand;
import connect4.views.graphics.gameLoop.play.commands.UndoMachinePlayerCommand;
import connect4.views.graphics.gameLoop.play.commands.UndoUserPlayerCommand;

public class TurnFactory {

    public TurnView createMachineTurnView(PlayController playController, PlayPanelViewVisitor visitor) {
        TurnView turnView = new TurnView(playController);
        turnView.setUndoCommand(new UndoMachinePlayerCommand(visitor));
        turnView.setRedoComand(new RedoMachinePlayerCommand(visitor));    
        return turnView;
    }

    public TurnView createUserTurnView(PlayController playController, PlayPanelViewVisitor visitor) {
        TurnView turnView = new TurnView(playController);
        turnView.setUndoCommand(new UndoUserPlayerCommand(visitor));
        turnView.setRedoComand(new RedoUserPlayerCommand(visitor));    
        return turnView;
    }

}
