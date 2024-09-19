package connect4.views.graphics;

import connect4.models.Game;
import connect4.views.View;

public class GraphicsView extends View {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public GraphicsView(Game game) {
        super(game);
        assert this.game != null;
        this.startView = new StartView(this.game);
        this.playView = new PlayView(this.game);
        this.resumeView = new ResumeView(this.game);

    }

    @Override
    public void start() {
        this.startView.interact();
    }

    @Override
    public void play() {
        this.playView.interact();
    }

    @Override
    public boolean resume() {
        return this.resumeView.interact();
    }

}
