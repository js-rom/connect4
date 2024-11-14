package connect4.views.graphics;

import connect4.models.Game;
import javax.swing.*;

public class StartView extends JFrameView {

    private Game game;
    private JPanel panel;
   

    public StartView(Game game) {
        assert this.game != null;
        this.game = game;
        
        //this.panel = new PlayerSelectionView(this.game);
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public void interact() {
        this.setVisible(true);
    }

    public void setPanel(PanelView panel) {
        this.getContentPane().add(panel);
    }

}
