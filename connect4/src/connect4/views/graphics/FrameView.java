package connect4.views.graphics;

import connect4.controllers.ResumeController;

public interface FrameView {

    public void interact();

    public void setPanel(GameLoopView panel);

    public void write();

    public boolean isResumed(ResumeController resumeController);
}
