package connect4;

import connect4.controllers.Logic;
import connect4.views.View;
import connect4.views.console.ConsoleView;

public class ConsoleConnect4 extends Connect4 {

    protected void playGames() {

        do {
            this.getView().start();
            this.getView().play();
        } while (this.getView().resume());

    }

    @Override
    protected View createView(Logic logic) {

        return new ConsoleView(logic);

    }

    public static void main(String[] args) throws Exception {

        new ConsoleConnect4().playGames();

    }

}