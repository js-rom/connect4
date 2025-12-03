package connect4.views.graphics.gameLoop.play.panel.board;

public interface BoardVisitor {

    public void visit(MachinePlayerBoardView machinePlayerBoardView);

    public void visit(UserPlayerBoardView userPlayerBoardView);
    
}
