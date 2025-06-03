package connect4.views.graphics;

public interface PlayPanelViewVisitor {

    public void visit(MachinePlayerBoardView machinePlayerBoardView);
    public void visit(UserPlayerBoardView userPlayerBoardView);
}
