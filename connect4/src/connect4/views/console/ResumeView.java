package connect4.views.console;

import connect4.controllers.ResumeController;
import utils.views.YesNoDialog;

public class ResumeView {

    private ResumeController resumeController;

    public ResumeView(ResumeController resumeController) {
        assert this.resumeController != null;
        this.resumeController = resumeController;
    }

    public boolean interact() {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            this.resumeController.reset();
        }
        return isResumed.isAffirmative();
    }

}
