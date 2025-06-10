package connect4.views.console;

import connect4.controllers.ControllerVisitor;
import connect4.controllers.PlayController;
import connect4.controllers.ResumeController;
import connect4.controllers.StartController;
import connect4.views.View;

public class ConsoleView implements View, ControllerVisitor {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public ConsoleView() {
        this.startView = new StartView();
        this.playView = new PlayView();
        this.resumeView = new ResumeView();
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


}
