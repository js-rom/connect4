package main.java.com.jsrom.connect4.views;

import main.java.com.jsrom.connect4.controllers.core.PlayController;
import main.java.com.jsrom.connect4.controllers.core.ResumeController;
import main.java.com.jsrom.connect4.controllers.core.SaveController;
import main.java.com.jsrom.connect4.controllers.core.StartController;

public interface View {
    public void start(StartController startController);
    public void play(PlayController playController);
    public void save(SaveController saveController);
    public boolean resume(ResumeController resumeController);
}
