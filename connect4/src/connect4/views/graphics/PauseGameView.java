package connect4.views.graphics;

import java.awt.BorderLayout;
import connect4.models.Game;

public class PauseGameView extends PanelView {

    protected Game game;
    protected BoardView boardView;
    protected TurnView turnView;

    public PauseGameView(Game game) {
        this.game = game;
        this.setLayout(new BorderLayout());
        this.turnView = new TurnView(game);
    }

    @Override
    protected void write() {
        this.boardView = new PauseBoardView(game, null);
        this.turnView.write();
        this.boardView.write();
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(this.turnView, BorderLayout.WEST);
        this.add(this.boardView, BorderLayout.CENTER);
    }

}
