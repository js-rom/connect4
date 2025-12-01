package connect4.views.graphics.play.commands;

import connect4.views.graphics.play.board.MachinePlayerBoardView;
import connect4.views.graphics.play.board.UserPlayerBoardView;

public interface PlayPanelViewVisitor {

    public void visit(MachinePlayerBoardView machinePlayerBoardView);
    public void visit(UserPlayerBoardView userPlayerBoardView);
    public void write();
    public void redo(RedoMachinePlayerCommand command);
    public void redo(RedoUserPlayerCommand command);
    public void undo(UndoMachinePlayerCommand command);
    public void undo(UndoUserPlayerCommand command);
}
