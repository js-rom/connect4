package main.java.com.jsrom.connect4.views.console;

import main.java.com.jsrom.connect4.controllers.core.ResumeController;
import main.java.com.jsrom.connect4.views.console.shared.Message;

import main.java.com.jsrom.utils.views.YesNoDialog;

public class ResumeView {

    public boolean interact(ResumeController resumeController) {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
        return isResumed.isAffirmative();
    }

}
