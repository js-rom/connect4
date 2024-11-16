package connect4.views.graphics;

import javax.swing.JFrame;

public abstract class JFrameView extends JFrame{
    public abstract void interact();
    public abstract void setPanel(PanelView panel);
}
