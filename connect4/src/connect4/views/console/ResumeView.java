package connect4.views.console;

import connect4.controllers.Logic;
import utils.views.YesNoDialog;

public class ResumeView {

    private Logic logic;

    public ResumeView(Logic logic) {
        assert this.logic != null;
        this.logic = logic;
    }

    public boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.logic.reset();
        }
        return isResumed.isAffirmative();
    }

}
