package connect4.views.graphics;

import connect4.models.Game;
import connect4.views.graphics.commands.Command;
import javax.swing.JFrame;

public class PlayView extends JFrameView {

    private Game game;
    private PanelView gameview;
    private Command nextView;

    public PlayView(Game game) {
        assert this.game != null;
        this.game = game;
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void interact() {
        if (!this.game.isFinished()) {
            this.gameview.write();
            this.updateUI();
        } else {
            this.updateUI();
            this.nextView.execute();
        }
    }

    @Override
    public void setPanel(PanelView panel) {
        this.gameview = panel;
        this.getContentPane().add(panel);
    }

    public void setNextView(Command callback) {
        this.nextView = callback;
    }

    private void updateUI() {
        this.revalidate();
        this.repaint();
    }

}
