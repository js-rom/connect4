package connect4.views;

import connect4.controllers.ControllerVisitor;
import connect4.controllers.PlayController;
import connect4.controllers.ResumeController;
import connect4.controllers.StartController;

public interface View {
    public void start(StartController startController);
    public void play(PlayController playController);
    public boolean resume(ResumeController resumeController);
}
