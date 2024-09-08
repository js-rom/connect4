package connect4;
import connect4.models.Game;
import connect4.views.GameView;
import utils.framework.App;

public class Connect4 extends App<Game, GameView> {

    public Connect4() {
        this.game = new Game();
        this.view = new GameView(this.game);
    }

    public static void main(String[] args) throws Exception {
        new Connect4().play();
    }
}