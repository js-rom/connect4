package connect4.views.graphics;

import connect4.models.Game;
import connect4.views.View;

public class GraphicsView extends View {

    JFrameViewFactory factory;

    public GraphicsView(Game game) {
        super(game);
        assert this.game != null;
        this.factory = new JFrameViewFactory(this.game);
    }

    @Override
    public void start() {
        this.factory.createStartView(this).interact();
    }

    @Override
    public void play() {
        this.factory.createPlayView(this).interact();
    }

    @Override
    public boolean resume() {

        PlayView resumeView = (PlayView) this.factory.createResumeView();

        return resumeView.isResumed();
    }

}
