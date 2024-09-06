package connect4.views;

import connect4.models.Game;

public class GameView extends utils.framework.View<Game> {
    private Game game;
    private BoardView boardView;
    private TurnView turnView;

    public GameView(Game game) {
        super(game);
        this.game = game;
        this.boardView = new BoardView(this.game);
        this.turnView = new TurnView(this.game);
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

    public boolean isResumed() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
        }
        return yesNoDialog.isAffirmative();
    }
}
