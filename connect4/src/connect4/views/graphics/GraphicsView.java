package connect4.views.graphics;

import javax.swing.JOptionPane;
import connect4.models.Game;
import connect4.views.View;

public class GraphicsView extends View {

    GameViewFactory factory;

    public GraphicsView(Game game) {
        super(game);
        assert this.game != null;
        this.factory = new GameViewFactory(this.game);
    }

    @Override
    public void start() {
        this.factory.createStartView(this).interact();
    }

    @Override
    public void play() {
        this.factory.createPlayView(this).interact();
    }

    @Override
    public boolean resume() {
        int result = JOptionPane.showConfirmDialog(
                null,
                Message.RESUME,
                "Select an Option",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE 
        );
        return JOptionPane.YES_OPTION == result;
    }

}
