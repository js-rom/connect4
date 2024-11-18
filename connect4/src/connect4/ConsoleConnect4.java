package connect4;

import connect4.models.Game;
import connect4.views.View;
import connect4.views.console.ConsoleView;

public class ConsoleConnect4 extends Connect4 {

    @Override
    protected View createView(Game game) {

        return new ConsoleView(game);

    }

    protected void playGames() {

        do {
            this.getView().start();
            this.getView().play();
        } while (this.getView().resume());

    }

    public static void main(String[] args) throws Exception {

        new ConsoleConnect4().playGames();

    }

}