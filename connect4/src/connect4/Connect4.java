package connect4;

import connect4.launchers.factories.LauncherProvider;

public abstract class Connect4 {

    protected LauncherProvider launcherProvider;

    protected Connect4() {
        this.launcherProvider = this.createLauncherProvider();
    }

    protected abstract LauncherProvider createLauncherProvider();

    protected abstract void playGames();

}
