package com.jsrom.connect4.views.console;

import com.jsrom.connect4.controllers.core.ControllerVisitor;
import com.jsrom.connect4.controllers.core.PlayController;
import com.jsrom.connect4.controllers.core.ResumeController;
import com.jsrom.connect4.controllers.core.SaveController;
import com.jsrom.connect4.controllers.core.StartController;
import com.jsrom.connect4.views.View;
import com.jsrom.connect4.views.console.play.PlayView;
import com.jsrom.connect4.views.console.start.StartView;

public class ConsoleView implements View, ControllerVisitor {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;
    private SaveView saveView;

    public ConsoleView() {
        this.startView = new StartView();
        this.playView = new PlayView();
        this.resumeView = new ResumeView();
        this.saveView = new SaveView();
    }

    @Override
    public void start(StartController startController) {
        this.startView.interact(startController);
    }

    @Override
    public void play(PlayController playController) {
        this.playView.interact(playController);
    }

    @Override
    public void save(SaveController saveController) {
        this.saveView.interact(saveController);
    }

    @Override
    public boolean resume(ResumeController resumeController) {
        return this.resumeView.interact(resumeController);
    }

    @Override
    public void visit(StartController startController) {
        this.start(startController);
    }

    @Override
    public void visit(PlayController playController) {
        this.play(playController);
    }

    @Override
    public boolean visit(ResumeController resumeController) {
        return this.resume(resumeController);
    }

    @Override
    public void visit(SaveController saveController) {
        this.save(saveController);
    }


}
