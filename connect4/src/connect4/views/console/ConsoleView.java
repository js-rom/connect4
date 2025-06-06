package connect4.views.console;

import connect4.controllers.Logic;
import connect4.views.View;

public class ConsoleView extends View {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public ConsoleView(Logic logic) {
        super(logic);

        this.startView = new StartView(this.logic);
        this.playView = new PlayView(this.logic);
        this.resumeView = new ResumeView(this.logic);
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
