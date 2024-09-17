package connect4.views;

import connect4.models.Game;

public abstract class WithGameView {

    Game game;
    
    public WithGameView (Game game) {
        this.game = game;
    } 
}
