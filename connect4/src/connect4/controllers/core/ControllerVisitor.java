package connect4.controllers.core;

import connect4.controllers.core.PlayController;
import connect4.controllers.core.ResumeController;
import connect4.controllers.core.StartController;

public interface ControllerVisitor {
    
    void visit(StartController startController);

    void visit(PlayController playController);

    boolean visit(ResumeController resumeController);
}
