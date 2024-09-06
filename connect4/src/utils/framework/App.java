package utils.framework;

public class App<M extends Game, V extends View<M>> {

    protected M game;
    protected V view;

    protected void play() {
        do { 
            this.view.playGames();
        } while (this.view.isResumed());
    }
}
