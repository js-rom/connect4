package connect4;

import connect4.views.View;
import connect4.views.console.ConsoleView;

public class ConsoleConnect4 extends Connect4 {

    protected void playGames() {
        do {
            if (logic.getController() != null) {
                logic.getController().accept(this.getView());
            }
        } while (logic.getController() != null);
    }

    @Override
    protected View createView() {

        return new ConsoleView();

    }

    public static void main(String[] args) throws Exception {

        new ConsoleConnect4().playGames();

    }

}