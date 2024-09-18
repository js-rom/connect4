package connect4;
import connect4.models.Game;
import connect4.views.console.ConsoleView;

public class ConsoleConnect4 {

    private Game game;
    private ConsoleView consoleView;

    public ConsoleConnect4() {
        this.game = new Game();
        assert this.game != null;
        this.consoleView = new ConsoleView(this.game);
    }

    private void playGames() {
        do {
            this.consoleView.start();
            this.consoleView.play();
        } while (this.consoleView.resume());
    }

    public static void main(String[] args) throws Exception {
        new ConsoleConnect4().playGames();
    }
}