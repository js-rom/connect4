package main.java.com.jsrom.connect4.controllers.core;

public interface ControllerVisitor {
    
    void visit(StartController startController);

    void visit(PlayController playController);

    void visit(SaveController saveController);

    boolean visit(ResumeController resumeController);
}
