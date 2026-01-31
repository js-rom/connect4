package com.jsrom.connect4.views;

import com.jsrom.connect4.controllers.core.PlayController;
import com.jsrom.connect4.controllers.core.ResumeController;
import com.jsrom.connect4.controllers.core.SaveController;
import com.jsrom.connect4.controllers.core.StartController;
import com.jsrom.connect4.controllers.core.ControllerVisitor;

public interface View extends ControllerVisitor {
    public void start(StartController startController);
    public void play(PlayController playController);
    public void save(SaveController saveController);
    public boolean resume(ResumeController resumeController);
}
