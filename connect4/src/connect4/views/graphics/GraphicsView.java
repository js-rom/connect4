package connect4.views.graphics;

import connect4.controllers.Logic;
import connect4.views.View;
import connect4.views.graphics.commands.Command;
import connect4.views.graphics.commands.PlayCommand;
import connect4.views.graphics.commands.ResumeCommand;

public class GraphicsView extends View {

    mainFrame frame;

    public GraphicsView(Logic logic) {
        super(logic);
        this.frame = new mainFrame(this.logic);
    }

    @Override
    public void start() {
        this.frame.setPanel(new StartPanelView(this.logic));
        Command nextView = new PlayCommand(this);
        this.frame.setPanelCallback(nextView);
        this.frame.interact();
        this.frame.write();
    }

    @Override
    public void play() {
        GameLoopView gameView = new PlayPanelView(this.logic);
        gameView.setCallback(new ResumeCommand(this));
        this.frame.setPanel(gameView);
        this.frame.write();
    }

    @Override
    public boolean resume() {
        GameLoopView gameView = new ResumenPanelView(this.logic);
        this.frame.setPanel(gameView);
        this.frame.write();
        return this.frame.isResumed();
    }

}
