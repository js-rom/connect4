package connect4.views.graphics;

import java.awt.BorderLayout;
import connect4.models.Game;
import connect4.models.Player;
import connect4.types.PlayerType;

public class PlayGameView extends PauseGameView {

    private BoardViewPrototypeRegistry boardViewPrototypeRegistry;


    public PlayGameView(Game game) {
        super(game);
    }

    public PlayGameView(Game game, BoardViewPrototypeRegistry boardViewPrototypeRegistry) {
        this(game);
        this.boardViewPrototypeRegistry = boardViewPrototypeRegistry;
    }

    @Override
    protected void write() {
        Player activePlayer = this.game.getActivePlayer();
        PlayerType playerType = activePlayer.getType();
        this.removeBoard();
        this.boardView = new BoardViewPrototypeDirector().get(this.boardViewPrototypeRegistry, playerType);
        this.turnView.write();
        this.boardView.write();
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(this.turnView, BorderLayout.WEST);
        this.add(this.boardView, BorderLayout.CENTER);
    }

    private void removeBoard() {
        if (this.boardView != null) {
            this.remove(this.boardView);
        }
    }

}
