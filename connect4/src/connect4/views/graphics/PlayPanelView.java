package connect4.views.graphics;

import java.awt.BorderLayout;
import connect4.controllers.PlayController;
import connect4.models.Player;
import connect4.types.PlayerType;
import connect4.views.graphics.commands.NextTurnCommand;

public class PlayPanelView extends ResumenPanelView {

    private BoardViewPrototypeRegistry boardViewPrototypeRegistry;

    public PlayPanelView(PlayController playController) {
        super(playController);
        assert(playController != null);
        this.boardViewPrototypeRegistry = new BoardViewPrototypeRegistry(this.getPlayController(), new NextTurnCommand(this));
    }

    @Override
    public void write() {
        if (!this.getPlayController().isFinished()) {
            Player activePlayer = this.getPlayController().getActivePlayer();
            PlayerType playerType = activePlayer.getType();
            this.removeBoard();
            this.boardView = new BoardViewPrototypeDirector().get(this.boardViewPrototypeRegistry, playerType);
            this.turnView.write();
            this.boardView.write();
            this.removeAll();
            this.setLayout(new BorderLayout());
            this.add(this.turnView, BorderLayout.WEST);
            this.add(this.boardView, BorderLayout.CENTER);
            this.getParent().revalidate();
            this.getParent().repaint();
        } else {
            this.getCallback().execute();
        }
    }

    private void removeBoard() {
        if (this.boardView != null) {
            this.remove(this.boardView);
        }
    }

}
