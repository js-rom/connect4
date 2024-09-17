package connect4;
import connect4.models.Game;
import connect4.views.console.GameView;

public class ConsoleConnect4 {

    private Game game;
    private GameView gameView;

    public ConsoleConnect4() {
        this.game = new Game();
        this.gameView = new GameView(this.game);
    }

    private void playGames() {
        this.gameView.playGames();
    }

    public static void main(String[] args) throws Exception {
        new ConsoleConnect4().playGames();
    }
}