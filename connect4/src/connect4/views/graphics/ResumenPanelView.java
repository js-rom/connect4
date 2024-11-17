package connect4.views.graphics;

import java.awt.BorderLayout;
import connect4.models.Game;

public class ResumenPanelView extends GameLoopView {

    protected BoardView boardView;
    protected TurnView turnView;

    public ResumenPanelView(Game game) {
        super(game);
        this.setLayout(new BorderLayout());
        this.turnView = new TurnView(game);
    }

    @Override
    public void write() {
        this.boardView = new PauseBoardView(game);
        this.turnView.write();
        this.boardView.write();
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(this.turnView, BorderLayout.WEST);
        this.add(this.boardView, BorderLayout.CENTER);
    }

}
