package connect4.views.graphics;

import javax.swing.JOptionPane;
import connect4.models.Game;
import connect4.views.View;

public class GraphicsView extends View {

    JFrameViewFactory factory;

    public GraphicsView(Game game) {
        super(game);
        assert this.game != null;
        this.factory = new JFrameViewFactory(this.game);
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

        JFrameView pauseView = this.factory.createResumeView(this);

        String message;
        if (this.game.isWinner()) {
            message = Message.PLAYER_WIN.toString();
            message = message.replace("#color", this.game.getActiveColor().toString());
        } else {
            message = Message.PLAYERS_TIED.toString();
        }

        message += "\n";
        message +=  Message.RESUME.toString();
        int result = JOptionPane.showConfirmDialog(
                //new InformativeBoardView(),
                pauseView,
                message,
                "Select an Option",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE 
        );
        pauseView.setVisible(false);
        return JOptionPane.YES_OPTION == result;
    }

}
