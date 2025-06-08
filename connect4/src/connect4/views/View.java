package connect4.views;

import connect4.controllers.PlayController;
import connect4.controllers.ResumeController;
import connect4.controllers.StartController;

public interface View {
    public abstract void start(StartController startController);
    public abstract void play(PlayController playController);
    public abstract boolean resume(ResumeController resumeController);
}
