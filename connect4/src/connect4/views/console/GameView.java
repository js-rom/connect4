package connect4.views.console;

import connect4.models.Game;
import utils.views.YesNoDialog;

public class GameView {
    private Game game;
    private BoardView boardView;
    private TurnView turnView;
    PlayerViewPrototypeRegistry playerViewRegistry;

    public GameView(Game game) {
        assert game != null;
        this.game = game;
        this.boardView = new BoardView(this.game);
        this.playerViewRegistry = new PlayerViewPrototypeRegistry();
        this.turnView = new TurnView(this.game, this.playerViewRegistry);
    }

    public void playGames() {
        do {
            this.playGame();
        } while (this.isResumed());
    }

    private void playGame() {
        this.turnView.resetPlayers();
        Message.TITLE.writeln();
        this.boardView.writeln();
        do {
            this.turnView.dropToken();
            this.boardView.writeln();
        } while (!this.game.isFinished());
        this.turnView.writeResult();
    }

    private boolean isResumed() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
        }
        return yesNoDialog.isAffirmative();
    }
}
