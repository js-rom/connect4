package connect4;

import connect4.models.Game;
import connect4.views.View;
import connect4.views.graphics.GraphicsView;

public class GraphicsConnect4 extends Connect4 {

    protected void playGames() {

        this.getView().start();

    }

    @Override
    protected View createView(Game game) {

        return new GraphicsView(game);

    }

    public static void main(String[] args) throws Exception {

        new GraphicsConnect4().playGames();

    }
}
