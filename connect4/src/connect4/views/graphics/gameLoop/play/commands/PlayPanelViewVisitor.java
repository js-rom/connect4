package connect4.views.graphics.gameLoop.play.commands;

import connect4.views.graphics.gameLoop.play.board.MachinePlayerBoardView;
import connect4.views.graphics.gameLoop.play.board.UserPlayerBoardView;

public interface PlayPanelViewVisitor {

    public void visit(MachinePlayerBoardView machinePlayerBoardView);

    public void visit(UserPlayerBoardView userPlayerBoardView);

    public void write();

    public void redo();

    public void undo();

    public boolean undoable();

    public void interruptDropToken();

}
