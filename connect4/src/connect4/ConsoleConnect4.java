package connect4;

import connect4.controllers.Logic;
import connect4.controllers.PlayController;
import connect4.controllers.ResumeController;
import connect4.controllers.StartController;
import connect4.views.View;
import connect4.views.console.ConsoleView;

public class ConsoleConnect4 extends Connect4 {

    protected void playGames() {

        do {
            if (logic.getController() instanceof StartController) {
                this.getView().start((StartController) logic.getController());
            } else {
                if (logic.getController() instanceof PlayController) {
                    this.getView().play((PlayController) logic.getController());
                } else {
                    this.getView().resume((ResumeController) logic.getController());
                }
            }
        } while (logic.getController() != null);
    }

    @Override
    protected View createView(Logic logic) {

        return new ConsoleView(logic);

    }

    public static void main(String[] args) throws Exception {

        new ConsoleConnect4().playGames();

    }

}