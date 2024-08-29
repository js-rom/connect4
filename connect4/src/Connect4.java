import models.Game;
import views.GameView;

public class Connect4 {

    private Game game;
    private GameView gameView;

    public Connect4() {
        this.game = new Game();
        this.gameView = new GameView(this.game);
    }

    public void playGames() {
        this.gameView.playGames();
    }

    public static void main(String[] args) throws Exception {
        new Connect4().playGames();
    }
}
