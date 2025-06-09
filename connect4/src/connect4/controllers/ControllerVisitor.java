package connect4.controllers;

public interface ControllerVisitor {
    
    void visit(StartController startController);

    void visit(PlayController playController);

    boolean visit(ResumeController resumeController);
}
