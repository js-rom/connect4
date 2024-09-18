package connect4.views.console;

import connect4.models.Game;
import connect4.views.WithGameView;
import utils.views.YesNoDialog;

public class ResumeView extends WithGameView {

    public ResumeView(Game game) {
        super(game);
        assert this.game != null;
    }

    public boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
        } // OJOOO fix smellcode no sorprises, resetGame should be in ResumeView
        return isResumed.isAffirmative();
    }

}
