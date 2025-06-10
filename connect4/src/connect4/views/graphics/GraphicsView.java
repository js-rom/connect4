package connect4.views.graphics;

import java.util.concurrent.CountDownLatch;

import connect4.controllers.ControllerVisitor;
import connect4.controllers.PlayController;
import connect4.controllers.ResumeController;
import connect4.controllers.StartController;
import connect4.views.View;

public class GraphicsView implements View, ControllerVisitor {

    MainFrame frame;
    CountDownLatch latch;

    public GraphicsView() {
        this.frame = new MainFrame();
    }

    @Override
    public void start(StartController startController) {
        this.frame.setPanel(new StartPanelView(startController, this.latch));
        this.frame.interact();
        this.frame.write();
    }

    @Override
    public void play(PlayController playController) {
        this.frame.setPanel(new PlayPanelView(playController, this.latch));
        this.frame.write();
    }

    @Override
    public boolean resume(ResumeController resumeController) {
        this.frame.write();
        boolean isResumed = this.frame.isResumed(resumeController);
        if (isResumed) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
        this.latch.countDown();
        return isResumed;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
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
