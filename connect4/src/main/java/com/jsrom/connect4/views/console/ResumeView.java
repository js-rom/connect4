package com.jsrom.connect4.views.console;

import com.jsrom.connect4.controllers.core.ResumeController;
import com.jsrom.connect4.views.console.shared.Message;

import com.jsrom.utils.views.YesNoDialog;

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
