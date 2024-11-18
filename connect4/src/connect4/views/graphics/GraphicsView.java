package connect4.views.graphics;

import connect4.models.Game;
import connect4.views.View;
import connect4.views.graphics.commands.Command;
import connect4.views.graphics.commands.PlayCommand;
import connect4.views.graphics.commands.ResumeCommand;

public class GraphicsView extends View {

    mainFrame frame;

    public GraphicsView(Game game) {
        super(game);
        assert this.game != null;
        this.frame = new mainFrame(this.game);
    }

    @Override
    public void start() {
        this.frame.setPanel(new StartPanelView(game));
        Command nextView = new PlayCommand(this);
        this.frame.setPanelCallback(nextView);
        this.frame.interact();
        this.frame.write();
    }

    @Override
    public void play() {
        GameLoopView gameView = new PlayPanelView(this.game);
        gameView.setCallback(new ResumeCommand(this));
        this.frame.setPanel(gameView);
        this.frame.write();
    }

    @Override
    public boolean resume() {
        GameLoopView gameView = new ResumenPanelView(this.game);
        this.frame.setPanel(gameView);
        this.frame.write();
        return this.frame.isResumed();
    }

}