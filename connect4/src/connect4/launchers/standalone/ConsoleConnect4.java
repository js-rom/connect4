package connect4.launchers.standalone;

import connect4.Connect4;
import connect4.launchers.factories.LauncherProvider;
import connect4.launchers.factories.StandaloneConsole;
import connect4.views.console.ConsoleView;

public class ConsoleConnect4 extends Connect4 {

    protected void playGames() {
        do {
            if (launcherProvider.getController() != null) {
                launcherProvider.getController().accept((ConsoleView) launcherProvider.getView());
            }
        } while (launcherProvider.getController() != null);
    }

    @Override
    protected LauncherProvider createLauncherProvider() {
        return this.launcherProvider = new StandaloneConsole();
    }

    public static void main(String[] args) throws Exception {

        new ConsoleConnect4().playGames();

    }

}