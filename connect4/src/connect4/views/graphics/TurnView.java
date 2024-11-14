package connect4.views.graphics;

import javax.swing.JPanel;

import connect4.models.Game;
import connect4.models.Player;

public class TurnView extends JPanel{

    Game game;

    public TurnView(Game game) {
        this.game = game;
    }

    public Player getActivePlayer() {
        return this.game.getActivePlayer();
    }
}
