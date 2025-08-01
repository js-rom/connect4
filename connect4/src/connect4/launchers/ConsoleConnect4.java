package connect4.launchers;

import connect4.views.console.ConsoleView;

public abstract class ConsoleConnect4 extends Connect4 {

    @Override
    protected void createView() {
        this.view = new ConsoleView();
    }

    @Override
    protected void playGames() {
        do {
            if (this.logic.getController() != null) {
                this.logic.getController().accept((ConsoleView) this.view);
            }
        } while (this.logic.getController() != null);
    }

}
