package connect4.views.graphics;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import connect4.models.Game;

public class InGameView extends PanelView {

    private Game game;
    private BoardViewPrototypeRegistry boardViewPrototypeRegistry;
    private BoardView boardView;
    private TurnView turnView;
    private JPanel userMessage;

    public InGameView(Game game) {
        this.game = game;
        this.setLayout(new BorderLayout());
    }

    @Override
    protected void write() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'write'");
    }
}
