package connect4.views.graphics;

import connect4.controllers.PlayController;
import connect4.controllers.ResumeController;
import connect4.controllers.StartController;
import connect4.views.View;
import connect4.views.graphics.commands.Command;
import connect4.views.graphics.commands.PlayCommand;
import connect4.views.graphics.commands.ResumeCommand;

public class GraphicsView extends View {

    mainFrame frame;

    public GraphicsView(StartController startController, PlayController playController, ResumeController resumeController) {
        super(startController, playController, resumeController);
        this.frame = new mainFrame(this.resumeController);
    }

    @Override
    public void start() {
        this.frame.setPanel(new StartPanelView(this.startController));
        Command nextView = new PlayCommand(this);
        this.frame.setPanelCallback(nextView);
        this.frame.interact();
        this.frame.write();
    }

    @Override
    public void play() {
        GameLoopView gameView = new PlayPanelView(this.playController);
        gameView.setCallback(new ResumeCommand(this));
        this.frame.setPanel(gameView);
        this.frame.write();
    }

    @Override
    public boolean resume() {
        GameLoopView gameView = new ResumenPanelView(this.playController); // TODO hacer un facade PlayResumeController de ambos 
        this.frame.setPanel(gameView);
        this.frame.write();
        return this.frame.isResumed();
    }

}
