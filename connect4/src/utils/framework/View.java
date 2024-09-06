package utils.framework;

public abstract class View <G extends Game> {

    protected G Game;

    public View(G game) {
        assert game != null;
        this.Game = game;
    }

    public abstract void playGames();
    public abstract boolean isResumed();

}
