package connect4.views.graphics;

import connect4.models.Game;
import connect4.models.Player;
import connect4.types.PlayerType;
import connect4.views.graphics.commands.Command;
import connect4.views.graphics.commands.MacroCommand;
import connect4.views.graphics.commands.NextTurnCommand;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class PlayView extends  JFrameView {

    private Game game;
    private BoardViewPrototypeRegistry boardViewPrototypeRegistry;
    private PanelView inGameview;
    private BoardView boardView;
    private MacroCommand callback;

    public PlayView(Game game) {
        assert this.game != null;
        this.game = game;
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Command callback = new NextTurnCommand(this);
        this.boardViewPrototypeRegistry = new BoardViewPrototypeRegistry(this.game, callback);
    }

    public void interact() {
        this.setVisible(true);
        //this.next();
        if (!this.game.isFinished()) {
            Player activePlayer = this.game.getActivePlayer();
            PlayerType playerType = activePlayer.getType();
            this.removeBoard();
            this.boardView = new BoardViewPrototypeDirector().get(this.boardViewPrototypeRegistry, playerType);
            this.addBoard();
            this.updateUI();
            this.game.next();
        } else {
            this.updateUI();
            this.callback.execute();
        }
    }

    @Override
    public void setPanel(PanelView panel) {
        this.inGameview = panel;
        this.getContentPane().add(panel);
    }

    public void setCallback(MacroCommand callback) {
        this.callback = callback;
    }

    // <<receiver>>
    /* public void next() {
        if (!this.game.isFinished()) {
            Player activePlayer = this.game.getActivePlayer();
            PlayerType playerType = activePlayer.getType();
            this.removeBoard();
            this.boardView = new BoardViewPrototypeDirector().get(this.boardViewPrototypeRegistry, playerType);
            this.addBoard();
            this.updateUI();
            this.game.next();
        } else {
            this.updateUI();
            this.callback.execute();
        }
    } */

    private void removeBoard() {
        if (this.boardView != null) {
            inGameview.remove(this.boardView);
        }
    }

    private void addBoard() {
        inGameview.setLayout(new BorderLayout());
        inGameview.add(this.boardView, BorderLayout.CENTER);
    }

    private void updateUI() {
        this.revalidate();
        this.repaint();
    }

}
