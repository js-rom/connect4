package connect4.views;

import connect4.models.Game;

public abstract class View extends WithGameView {

    
    public View (Game game) {
        super(game);
    } 

    protected abstract void start();
    protected abstract void play();
    protected abstract boolean resume();

}
