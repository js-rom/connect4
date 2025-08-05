package connect4.controllers.core;

public interface ControllerVisitor {
    
    void visit(StartController startController);

    void visit(PlayController playController);

    boolean visit(ResumeController resumeController);
}
