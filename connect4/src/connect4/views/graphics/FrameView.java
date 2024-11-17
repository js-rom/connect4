package connect4.views.graphics;

import connect4.views.graphics.commands.Command;

public interface FrameView {
    
    public void interact();

    public void setPanel(GameLoopView panel);

    public void setPanelCallback(Command command);

    public void write();

    public boolean isResumed();
}
